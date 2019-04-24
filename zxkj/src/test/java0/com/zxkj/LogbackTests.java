package com.zxkj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTests {
    private static Logger logger= LoggerFactory.getLogger(LogbackTests.class);

    public static void main(String[] args) {
        logger.info("haha");
        logger.warn("haha");
        logger.error("haha");
        logger.debug("haha");
    }

}
