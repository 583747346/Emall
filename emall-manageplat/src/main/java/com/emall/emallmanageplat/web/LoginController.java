package com.emall.emallmanageplat.web;

import com.emall.emallcommon.core.exception.SystemErrorType;
import com.emall.emallcommon.core.result.Result;
import com.emall.emallmanageplat.entity.form.UsersLoginForm;
import com.emall.emallmanageplat.entity.vo.UserInfoVo;
import com.emall.emallmanageplat.service.IUsersService;
import com.emall.emallmanageplat.verification.VerificationCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/login")
@Api(tags = "LoginController",value = "登录API")
@Slf4j
public class LoginController {

    @Autowired
    private IUsersService usersService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static String RANDOMREDISKEY = "RANDOMREDISKEY";

    @ApiOperation(value = "用户登录", notes = "根据用户名和密码登录")
    @ApiResponse(code = 200, message = "处理成功",response = Result.class)
    @RequestMapping("/login")
    public Result<UserInfoVo> getUserInfo(@RequestBody UsersLoginForm usersLoginForm) {
        //校验验证码
//        String vcode = stringRedisTemplate.opsForValue().get(RANDOMREDISKEY);
/*        if(StringUtils.equals(vcode, usersLoginForm.getValidcode())){
            return Result.fail(SystemErrorType.INVALID_VERIFICATIONCODE);
        }*/
        UserInfoVo userInfoVo = usersService.getUsersInfo(usersLoginForm);
        if(userInfoVo == null){
            return Result.fail(SystemErrorType.INVALID_CREDENTIALS);
        }
        return Result.success(userInfoVo);
    }


    @ApiOperation(value = "获取与刷新验证码", notes = "获取与刷新验证码")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    @GetMapping("/refreshcode")
    @ResponseBody
    public void refreshCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            VerificationCode verificationCode = new VerificationCode();
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setCharacterEncoding("UTF-8"); //设置字符
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            response.setCharacterEncoding("UTF-8");
            String verid = UUID.randomUUID().toString().replaceAll("-", "");
            Cookie cookie = new Cookie("v_code", verid);        //将uuid串存入cookie
            cookie.setMaxAge(5 * 60);// 设置存在时间为5分钟
            cookie.setPath("/");//设置作用域
            response.addCookie(cookie);
            verificationCode.getRandcode(request, response);
            //将验证码放到redis中
            stringRedisTemplate.opsForValue().set(verid, (String) request.getSession().getAttribute(RANDOMREDISKEY), Long.parseLong("60"), TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("获取验证码异常：", e);
            throw e;
        }
    }
}
