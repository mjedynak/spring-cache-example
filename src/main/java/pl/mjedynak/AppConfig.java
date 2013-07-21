package pl.mjedynak;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching
@ComponentScan("pl.mjedynak")
public class AppConfig {

    public static final String VIP_CLIENTS_CACHE = "vipClients";

    @Bean
    public SlowService slowService() {
        return new SlowService();
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache(VIP_CLIENTS_CACHE)));
        return cacheManager;
    }
}
