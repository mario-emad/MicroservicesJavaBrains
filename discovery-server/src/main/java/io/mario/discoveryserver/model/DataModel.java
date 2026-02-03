package io.mario.discoveryserver.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("data")
@Getter
@Setter
public class DataModel {
    private String name;
    private String description;
}
