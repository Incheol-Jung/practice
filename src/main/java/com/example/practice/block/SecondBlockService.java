package com.example.practice.block;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Incheol Jung
 */
@Service
public class SecondBlockService {
    private static Logger logger = LoggerFactory.getLogger(BlockService.class);

    @Async
    public void async(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("BlockService.async");
    }
}
