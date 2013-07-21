package pl.mjedynak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

public class SlowService {

    private Logger logger = LoggerFactory.getLogger(SlowService.class.getName());

    @Cacheable(AppConfig.VIP_CLIENTS_CACHE)
    public boolean isVipClient(String clientName) {
        logger.debug("Checking " + clientName);
        boolean result = false;
        if (clientName.hashCode() % 2 == 0) {
            result = true;
        }
        return result;
    }
}
