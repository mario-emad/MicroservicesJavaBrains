package io.mario.springcloudconfigclient.controller;

import io.mario.springcloudconfigclient.model.DBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class SpringCloudConfigClientResource {


        @Value("${my.greeting: default value}")
        private String greetingMessage;

        @Value("some static message")
        private String staticMessage;

        @Value("${my.list.values}")
        private List<String> listValues;

        @Autowired
        private DBModel dbModel;

        @Autowired
        private Environment env;

        @GetMapping("/greeting")
        public String greeting() {
                return "my.greeting: " + greetingMessage + " db.connection: " + dbModel.getConnection();
        }
        @GetMapping("/envdetails")
        public String envDetails() { return env.toString(); }

}
