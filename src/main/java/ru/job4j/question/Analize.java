package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> mapCurrent = new HashMap<>();
        Map<Integer, String> mapPrevious = new HashMap<>();
        previous.forEach(p -> mapPrevious.put(p.getId(), p.getName()));
        current.forEach(p -> mapCurrent.put(p.getId(), p.getName()));
        int added = (int) mapCurrent.keySet()
                .stream()
                .filter(c -> !mapPrevious.containsKey(c))
                .count();
        int deleted = (int) mapPrevious.keySet()
                .stream()
                .filter(c -> !mapCurrent.containsKey(c))
                .count();
        int changed = (int) mapCurrent.entrySet()
                .stream()
                .filter(c -> mapPrevious.containsKey(c.getKey()) && !mapPrevious.containsValue(c.getValue()))
                .count();
        return new Info(added, changed, deleted);

    }

}