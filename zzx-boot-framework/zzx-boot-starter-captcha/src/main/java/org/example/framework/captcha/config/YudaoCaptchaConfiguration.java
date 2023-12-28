package org.example.framework.captcha.config;

import com.xingyuv.captcha.properties.AjCaptchaProperties;
import com.xingyuv.captcha.service.CaptchaCacheService;
import com.xingyuv.captcha.service.impl.CaptchaServiceFactory;
import jakarta.annotation.Resource;
import org.example.framework.captcha.core.service.RedisCaptchaServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@AutoConfiguration
public class YudaoCaptchaConfiguration {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    public CaptchaCacheService captchaCacheService(AjCaptchaProperties config) {
        // 缓存类型 redis/local/....
        CaptchaCacheService ret = CaptchaServiceFactory.getCache(config.getCacheType().name());
        if (ret instanceof RedisCaptchaServiceImpl) {
            ((RedisCaptchaServiceImpl) ret).setStringRedisTemplate(stringRedisTemplate);
        }
        return ret;
    }

}
