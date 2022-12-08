package org.example.chap03;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11659

public class 구간합 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 배열에 저장할 숫자 개수
        int M = scan.nextInt(); // 테스트 케이스 숫자 (합을 몇번 구할것인지)

        int[] A = new int[N];
//        System.out.println(Arrays.toString(A));
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        // 합배열 S 구하기
        // S[i] = S[i-1] + A[i]
        int[] S = new int[A.length];
        S[0] = A[0];
        for (int i = 1; i < S.length; i++) {
            S[i] = S[i-1] + A[i];
        }
//        System.out.println(Arrays.toString(A));

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt() - 1, y = scan.nextInt() - 1;
            if (x > 0) {
                System.out.println(S[y] - S[x - 1]);
            } else {
                System.out.println(S[y]);
            }
        }
        scan.close();
    }
}
