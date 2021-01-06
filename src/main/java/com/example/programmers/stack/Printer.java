package com.example.programmers.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 프린터
 */
public class Printer {

    public static void main(String[] args) {

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 3;

        int answer = 0;

        List<Map<String, Integer>> list = new ArrayList<>();

        Map<String, Integer> target = new HashMap<>();
        target.put("index", location);
        target.put("priority", priorities[location]);

        int length = priorities.length;

        for (int i = 0; i < length; i++) {

            Map<String, Integer> m = new HashMap<>();

            m.put("index", i);
            m.put("priority", priorities[i]);

            list.add(m);

        }

        while (list.stream().anyMatch(m -> m.get("index") == location)) {

            Map<String, Integer> now = list.get(0);
            Integer p = now.get("priority");

            // 1
            list.remove(now);

            List<Map<String, Integer>> list1 = list.stream().filter(m -> m.get("priority") > p).collect(Collectors.toList());

            if (list1.size() >= 1) {

                // 2
                list.add(now);

            } else {

                // 3
                answer++;

            }

        }

        System.out.println(answer);
        System.out.println("answer : " + answer);

    }

}
