package com.example.programmers.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능개발
 */
public class FunctionDevelopment {

    public static void main(String[] args) {

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] answer = {};

        int l = progresses.length;

        // 남은 일수 배열
        int[] days = new int[l];

        for (int i = 0; i < l; i++) {
            days[i] = (int) Math.ceil((100 - progresses[i]) / speeds[i]);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < l;) {

            int c = 1;

            while (i+c < l && days[i] > days[i+c]) {
                c++;
            }

            list.add(c);
            i = i + c;

        }

        int size = list.size();
        answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }

        System.out.println(answer);
        System.out.println("answer : " + answer);

    }

}
