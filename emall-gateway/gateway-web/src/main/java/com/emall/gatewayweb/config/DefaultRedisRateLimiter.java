package com.emall.gatewayweb.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
public class DefaultRedisRateLimiter extends RedisRateLimiter {

    Config getDefaultConfig() {
        return super.getConfig().get("defaultFilters");
    }

    /**
     * 这里2.2.0 版本以下使用的是ReactiveRedisTemplate，以上使用的是ReactiveStringRedisTemplate
     * @param redisTemplate
     * @param script
     * @param validator
     */
    public DefaultRedisRateLimiter(ReactiveStringRedisTemplate redisTemplate,
                                   RedisScript<List<Long>> script,
                                   @Qualifier("defaultValidator") Validator validator) {
        super(redisTemplate, script, validator);
    }


    /**
     * Mono ,是指最多只能触发(emit) (事件)一次。它对应于 RxJava 库的 Single 和 Maybe 类型或者是java的Optional。
     * 因此一个异步任务，如果只是想要在完成时给出完成信号，就可以使用 Mono<Void>。
     */
    @Override
    public Mono<Response> isAllowed(String routeId, String id) {
        if (null == super.getConfig().get(routeId))
            getConfig().put(routeId, getDefaultConfig());
        return super.isAllowed(routeId, id);
    }

}
