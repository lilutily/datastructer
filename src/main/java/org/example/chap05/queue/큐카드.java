package org.example.chap05.queue;

import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/2164
public class 큐카드 {
    public static void main(String[] args) {

        // 카드의 수
        int N=4;

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N; i++) {
            queue.add(i);
        }

        // 카드 조작 ( 맨 위 한장 버리고, 그다음장 버리고 맨 아래에추가 반복)
        while (queue.size() > 1) {
            queue.poll(); // 맨 위 한장 버리고
            queue.add(queue.poll()); // 한장 더 버리고 맨 뒤에 추가
        }
        System.out.println(queue.peek()); // 마지막 한장 출력
    }
}
