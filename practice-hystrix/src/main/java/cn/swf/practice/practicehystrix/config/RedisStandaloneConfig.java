package cn.swf.practice.practicehystrix.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by 宋维飞
 * 2019/7/1 20:00
 */
@Configuration
@ConditionalOnProperty(name = "standalone.index")
@Slf4j
public class RedisStandaloneConfig {

    @Value("${redis.custom.host}")
    private String host;
    @Value("${redis.custom.port}")
    private Integer port;
    @Value("${redis.custom.password}")
    private String password;
    @Value("${redis.custom.dbindex}")
    private Integer dbIndex;

    public LettuceConnectionFactory lettuceConnectionFactory(GenericObjectPoolConfig localPoolConfig) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setPassword(password);
        redisStandaloneConfiguration.setDatabase(dbIndex);
        LettuceConnectionFactory lettuceConnectionFactorynew = new LettuceConnectionFactory(
                redisStandaloneConfiguration);
        log.info("创建LettuceConnectionFactory成功");
        return lettuceConnectionFactorynew;
    }

    @Bean
    public GenericObjectPoolConfig localPoolConfig() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(200);
        config.setMaxIdle(10);
        config.setMinIdle(100);
        config.setMaxWaitMillis(3000);
        return config;
    }

    @Bean
    public <K, V> RedisTemplate<K, V> redisTemplate() {
        RedisTemplate<K, V> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory(localPoolConfig()));

        redisTemplate.setDefaultSerializer(new StringRedisSerializer());

        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        log.info("#######################create RedisTemplate success");
        return redisTemplate;
    }

}
