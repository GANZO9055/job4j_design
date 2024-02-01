package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int add = 0;
        int replace = 0;
        int remove = 0;

        Map<Integer, String> mapPrevious = new HashMap<>();
        for (User userOne : previous) {
            mapPrevious.put(userOne.getId(), userOne.getName());
        }

        Map<Integer, String> mapCurrent = new HashMap<>();
        for (User userTwo : current) {
            mapCurrent.put(userTwo.getId(), userTwo.getName());
        }

        for (Integer userOne : mapCurrent.keySet()) {
            if (!mapPrevious.containsKey(userOne)) {
                add++;
            }
        }

        for (Map.Entry<Integer, String> userOne : mapPrevious.entrySet()) {
            if (mapCurrent.containsKey(userOne.getKey())
                    && !mapCurrent.containsValue(userOne.getValue())) {
                replace++;
            }
        }

        for (Integer userOne : mapPrevious.keySet()) {
            if (!mapCurrent.containsKey(userOne)) {
                remove++;
            }
        }
        return new Info(add, replace, remove);
    }

}
