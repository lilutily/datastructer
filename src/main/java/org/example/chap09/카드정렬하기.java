package org.example.chap09;

import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1715
public class 카드정렬하기 {
    /*
        카드 묶음이 있으면 묶음끼리 합치고 비교하는건데
        10 + 20 + 25 + 28
        10 + 20 = 30 (제일 작은 두 수를 합치자) 1
        30 + 25 + 28
        25 + 28 = 53 2
        30 + 53
        30 + 53 = 83 3
        따라서 1+2+3하면 30+53+83=166
    */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 묶음 수

        // 우선순위 큐는 큐의 정렬을 지정한 우선순위에 따라 자동정렬하는 자료구조다
        // 일반 큐는 10 30 20 이렇게 들어가는데 우선순위 큐는 10 30 20 이 들어가면 10 20 30으로 우선순위를 변경함
        PriorityQueue<Integer> cardList = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            cardList.add(sc.nextInt()); // 오름차 순으로 정렬이 되어있으니까 앞에서부터 더하자
        }

        int total = 0;
        while (cardList.size() != 1) {
            int data1 = cardList.poll();
            int data2 = cardList.poll();
            total += data1 + data2;
            cardList.offer(data1 + data2); // 더하고 다시 넣는다
        }
        System.out.println(total);

    }
}
