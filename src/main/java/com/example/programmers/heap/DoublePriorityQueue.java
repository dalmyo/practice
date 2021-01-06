package com.example.programmers.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 이중우선순위큐
 */
public class DoublePriorityQueue {

    public static void main(String[] args) {

        int[] answer = {0,0};

        String[] operations = {"I 7","I -5","I 5","I 5546","I 50","D -1"};

        List<Integer> queue = new ArrayList<>();

        for (String operation : operations) {

            String[] s = operation.split(" ");

            if (s[0].equals("I")) {

                // 삽입
                queue.add(Integer.valueOf(s[1]));

                // 내림차순 정렬
                queue = queue.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            } else if (queue.size() >= 1) { // 삭제할게 있으면

                if (s[1].equals("1")) {
                    // 최댓값 삭제
                    queue.remove(0);

                } else {
                    // 최솟값 삭제
                    queue.remove(queue.size()-1);

                }

            }

            System.out.println(queue);

        }

        int size = queue.size();

        if (size >= 2) {
            answer[0] = queue.get(0);
            answer[1] = queue.get(size-1);
        } else if (size == 1) {
            answer[0] = queue.get(0);
            answer[1] = queue.get(0);
        }

        System.out.println("answer = [" + answer[0] + ", " + answer[1] + "]");

    }

}
