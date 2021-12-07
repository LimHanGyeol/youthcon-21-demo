package com.yoouthcon21.secondservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    private static final Logger log = LoggerFactory.getLogger(SecondController.class);

    private final SecondService secondService;

    public SecondController(SecondService secondService) {
        this.secondService = secondService;
    }

    @GetMapping("/receive")
    public ResponseEntity<Integer> receive() {
        log.info("<--- Second Service Receive");
        Integer result = secondService.getResponseCondition();
        log.info("<--- END Second Service, result: {}", result);

        if (result <= 5) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(result);
    }
}
