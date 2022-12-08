package org.example.chap04;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1940
public class 투포인터 {
    public static void main(String[] args) {
        // int M = 9; // 갑옷이 완성되는 합
        // int N = 6; // 재료의 수
        // int[] A = {2, 7, 4, 1, 5, 3}; // 배열을 정렬해버리면 해결하기 쉬워짐

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 재료의 개수
        int M = sc.nextInt(); // 갑옷이 완성되는 번호의 합
        int[] A = new int[N]; // 재료들

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        sc.close();

        // 오름차 정렬
        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));

        int count = 0; // 갑옷이 완성되는 경우의 수
        int start = 0; // 스타트 포인터의 초기 인덱스
        int end = N - 1; // 엔드 포인터의 초기 인덱스

        // 투 포인터 알고리즘
        // start와 end가 역전될 때까지
        while (start < end) {
            int sum = A[start] + A[end];
//            System.out.printf("start: %d, end: %d, sum: %d, M: %d\n"
//                                , start, end, sum, M);
            if (sum == M) { // 갑옷이 완성되는 경우
                count++; // 경우의 수 증가
                start++;
                end--;
            } else if (sum > M) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(count);

    }
}
