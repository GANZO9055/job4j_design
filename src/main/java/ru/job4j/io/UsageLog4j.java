package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        char paramOne = 'j';
        byte paramTwo = 125;
        short paramThree = 1000;
        long paramFour = 1_000_000L;
        double paramFive = 1428.2027;
        float paramSix = 15.25F;
        boolean paramSeven = true;
        LOG.debug("Parameters: {}, {}, {}, {}, {}, {}, {}, {}, {}", name, age, paramOne, paramTwo,
                paramThree, paramFour, paramFive, paramSix, paramSeven);
    }
}
