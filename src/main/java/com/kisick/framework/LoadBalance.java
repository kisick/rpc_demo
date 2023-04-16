package com.kisick.framework;

import java.util.List;
import java.util.Random;


public class LoadBalance {

    public static Invoker random(List<Invoker> invokers) {
        Random random = new Random();
        int index = random.nextInt(invokers.size());
        return invokers.get(index);
    }

}
