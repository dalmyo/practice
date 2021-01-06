package com.example.programmers.stack;

/**
 * 주식 가격
 */
public class StockPrice {

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3}; // 2 <= length <= 100,000

        int length = prices.length;

        int[] answer = new int[length];

        for (int i = 0; i < length-1; i++) {

            int i1 = i + 1;
            int p = prices[i];

            while (i1 < length-1 && p <= prices[i1]) {
                i1++;
            }

            answer[i] = i1 - i;

        }

        answer[length-1] = 0;

        System.out.println("answer : " + answer);

    }

}
