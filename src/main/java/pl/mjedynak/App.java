package pl.mjedynak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SlowService slowService = applicationContext.getBean(SlowService.class);
        logger.debug(String.valueOf(slowService.isVipClient("Michal")));
        logger.debug(String.valueOf(slowService.isVipClient("Kasia")));
        logger.debug(String.valueOf(slowService.isVipClient("Kasia")));
    }
}
