package com.example.practice.block;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Incheol Jung
 */
@RestController
@RequestMapping("block")
public class BlockController {
    private static Logger logger = LoggerFactory.getLogger(BlockController.class);

    final BlockService blockService;
    public BlockController(BlockService blockService) {this.blockService = blockService;}

    @GetMapping("sync-block")
    public void syncBlock(){
        blockService.sync();
        logger.info("BlockController.syncBlock");
    }

    @GetMapping("async-block")
    public void asyncBlock(){
        blockService.async();
        logger.info("BlockController.asyncBlock");
    }

    @GetMapping("sync-nonblock")
    public void syncNonBlock(){
        ExecutorService service = Executors.newSingleThreadExecutor();

        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("BlockController.syncNonBlock.call");
                return "Future Done!!";
            }
        };

        Future<String> future = service.submit(task);

        try {
            logger.info("BlockController.syncNonBlock.main");
            String futureResult = future.get();
            System.out.println("futureResult: " + futureResult);
        } catch (Exception e) {
            // Exception Handling
        }
    }
}
