package io.mario.springcloudconfigclient.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("db")
@Getter
@Setter
public class DBModel {
    private String connection;
    private String host;
    private String port;
}
