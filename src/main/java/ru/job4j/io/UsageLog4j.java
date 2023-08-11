package ru.job4j.io;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    //    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

//    public static void main(String[] args) {
//        LOG.trace("trace message");
//        LOG.debug("debug message");
//        LOG.info("info message");
//        LOG.warn("warn message");
//        LOG.error("error message");
//    }

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        boolean boo = true;
        char ch = 'a';
        byte b = 10;
        short s = 200;
        int i = 10000;
        float f = 1.5f;
        double d = 2.8;
        long l = 50L;
        LOG.debug("Boolean data type : {}, character data type : {}, "
                + "byte data type : {}, short data type : {}, "
                + "integer data type : {}, float data type : {}, "
                + "double data type : {}, long data type : {}", boo, ch, b, s, i, f, d, l);
    }
}