package com.example.programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 전화번호 목록
 */
public class PhoneNumbers {

    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "195524421"};

        boolean answer = true;

        ArrayList<String> list = new ArrayList<>(Arrays.asList(phone_book));

        for (String s : list) {
            long count = list.stream().filter(s1 -> s1.startsWith(s)).count();
            if (count >= 2) {
                answer = false;
            }
        }

        System.out.println(answer);

    }
}
