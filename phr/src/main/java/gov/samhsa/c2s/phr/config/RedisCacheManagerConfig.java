package gov.samhsa.c2s.phr.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Feruz.Abdella on 12/15/2015.
 */
@Configuration
public class RedisCacheManagerConfig extends CachingConfigurerSupport {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CacheManager cacheManager;

    @Value("${phr.redis.defaultExpirationInSeconds}")
    private long defaultExpirationInSeconds;

    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(".");
            sb.append(method.getName());
            sb.append(".");
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        if (cacheManager instanceof RedisCacheManager) {
            logger.info("Setting RedisCacheManager.defaultExpiration to " + defaultExpirationInSeconds);
            ((RedisCacheManager) cacheManager).setDefaultExpiration(defaultExpirationInSeconds);
            logger.info("RedisCacheManager.defaultExpiration is set to " + defaultExpirationInSeconds + " successfully");
        }
    }
}
