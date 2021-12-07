package com.youthcon21.thirdservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdController {

    private static final Logger log = LoggerFactory.getLogger(ThirdController.class);

    @GetMapping("/receive")
    public ResponseEntity<String> receive() {
        log.info("<--- Third Service Receive");
        return ResponseEntity.ok().build();
    }
}
