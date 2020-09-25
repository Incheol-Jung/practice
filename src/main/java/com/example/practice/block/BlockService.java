package com.example.practice.block;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author Incheol Jung
 */
@Service
public class BlockService {
    private static Logger logger = LoggerFactory.getLogger(BlockService.class);

    private final SecondBlockService secondBlockService;
    public BlockService(SecondBlockService secondBlockService) {this.secondBlockService = secondBlockService;}

    @Async
    public void async(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("BlockService.async");
        secondBlockService.async();
    }

    public void sync(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("BlockService.async");
    }


}
