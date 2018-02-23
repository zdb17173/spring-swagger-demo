package org.fran.demo.springboot.swagger.config.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "swagger")
public class Swagger {
    private String host;
    private APIInfo apiInfo;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public APIInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(APIInfo apiInfo) {
        this.apiInfo = apiInfo;
    }
}
