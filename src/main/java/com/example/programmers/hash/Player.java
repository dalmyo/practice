package com.example.programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 완주하지 못한 선수
 */
public class Player {

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = "";

        ArrayList<String> list = new ArrayList<>(Arrays.asList(participant));

        for (String s : completion) {
            list.remove(list.indexOf(s));
        }

        answer = list.get(0);

        System.out.println(answer);
    }
}
