package com.yoouthcon21.secondservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class SecondService {

    private static final Logger log = LoggerFactory.getLogger(SecondService.class);

    public Integer getResponseCondition() {
        log.info("--- Start Calculate Response Condition");
        int result = ThreadLocalRandom.current().nextInt(1, 10) + 1;
        log.info("--- Finish Calculate Response Condition");
        return result;
    }
}
