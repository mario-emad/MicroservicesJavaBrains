package io.mario.discoveryserver.controller;

import io.mario.discoveryserver.model.DataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discoveryServer")
public class DiscoveryServerResource {

    private static final Logger log = LoggerFactory.getLogger(DiscoveryServerResource.class);
    @Value("${profile.name}")
    private String value;
    @Autowired
    private DataModel dataModel;
    @Autowired
    private Environment environment;

    @RequestMapping("/testResource")
    public ResponseEntity<?> getDiscoveryServerResource() {
        log.info("<h1>" + value + "</h1>");
        log.info(dataModel.getName() + " : " + dataModel.getDescription());
        log.info(environment.toString());
        return ResponseEntity.ok().body(environment.toString());
    }

}
