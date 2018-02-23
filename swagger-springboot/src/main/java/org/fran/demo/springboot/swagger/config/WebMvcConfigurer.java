package org.fran.demo.springboot.swagger.config;

import org.fran.demo.springboot.swagger.config.cors.UrlBasedCorsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.DispatcherType;
import java.util.List;
import java.util.Map;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private UrlBasedCorsConfiguration urlBasedCorsConfiguration;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(twoFactorAuthInterceptor).addPathPatterns(twoFactorAuthCfg.getPath());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false)
                .favorParameter(true)
                /*.defaultContentType(MediaType.APPLICATION_JSON).
                mediaType("xml", MediaType.APPLICATION_XML)*/;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        Map<String, CorsConfiguration> configs = urlBasedCorsConfiguration.getConfigs();
        CorsConfiguration corsConfiguration;
        CorsRegistration corsRegistration;
        List<String> list;
        Boolean yes;
        Long age;
        for (String path : configs.keySet()) {
            corsConfiguration = configs.get(path);
            corsRegistration = registry.addMapping(path);
            list = corsConfiguration.getAllowedOrigins();
            if (list != null) {
                corsRegistration.allowedOrigins(list.toArray(new String[0]));
            }
            list = corsConfiguration.getAllowedMethods();
            if (list != null) {
                corsRegistration.allowedMethods(list.toArray(new String[0]));
            }
            list = corsConfiguration.getAllowedHeaders();
            if (list != null) {
                corsRegistration.allowedHeaders(list.toArray(new String[0]));
            }
            list = corsConfiguration.getExposedHeaders();
            if (list != null) {
                corsRegistration.exposedHeaders(list.toArray(new String[0]));
            }
            yes = corsConfiguration.getAllowCredentials();
            if (yes != null) {
                corsRegistration.allowCredentials(yes);
            }
            age = corsConfiguration.getMaxAge();
            if (age != null) {
                corsRegistration.maxAge(age);
            }
        }
    }

}
