package com.emall.emallweb.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 用户上下文
 */
public class UserApplicationContext {

    //用于存储当前线程信息
    private ThreadLocal<Map<String, String>> threadLocal;

    //构造方法初始化threadLocal
    private UserApplicationContext() {
        this.threadLocal = new ThreadLocal<>();
    }

    public static UserApplicationContext getInstance() {
        return SingletonApplicationContext.instance;
    }

    /**
     * 清空上下文
     */
    public void clear() {
        threadLocal.remove();
    }

    public static class SingletonApplicationContext {
        private static final UserApplicationContext instance = new UserApplicationContext();
    }

    /**
     * 插入到当前线程threadLocal中
     *
     * @param map
     */
    public void setContext(Map<String, String> map) {
        threadLocal.set(map);
    }

    /**
     * 获取当前用户
     */
    public String getUsername() {
        return Optional.ofNullable(threadLocal.get()).orElse(new HashMap<>()).get("user_name");
    }

}
