package org.example.chap06;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11399
public class ATM {
        /*
        돈을 뽑는데 걸리는시간이 다름
        예를 들어서 5명이 있는데 각각 어떻게 줄을 서느냐에 따라 기다리는 시간을 더함
        여기서 각 사람들이 기다린 시간을 최소화 하고싶음
        가장 작은 수를 맨 앞으로 끄집어 내면 되자않을까
        정렬하고 구간합
        */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N]; // 수를 저장할 배열
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            int temp = A[i];

            int j = i;
            while (j > 0 && A[j - 1] >= temp) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = temp;
        }

        // 구간 합배열 생성
        int[] S = new int[N + 1];

        for (int i = 1; i < S.length; i++) {
            S[i] = S[i - 1] + A[i - 1];
        }

        // 합배열 총합 구하기
        int total = 0;
        for (int i = 1; i < S.length; i++) {
            total += S[i];
        }
        System.out.println(total);
        //        Arrays.sort(arr); // 단순 정렬만 요구하면
    }

}
