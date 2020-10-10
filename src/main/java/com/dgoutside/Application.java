package com.dgoutside;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dgoutside.config.MyProperties;
import com.dgoutside.utils.ApplicationContextUtil;

@EnableConfigurationProperties({MyProperties.class})
@EnableTransactionManagement
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(Application.class, args);
        ApplicationContextUtil.setApplicationContext(app);
    }
    

}
