package org.example.chap07;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2751
public class 수정렬하기2 {
    /*
        N개의 수를 오름차순으로 정렬
        1 <= N <= 1000000 이니까 N^2은 못씀
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }


        for (int i = 1; i < N; i++) {
            int temp = A[i];

            int j = i;
            while (j > 0 && A[j - 1] >= temp) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = temp;
        }
        Arrays.sort(A); // 단순 정렬만 요구하면
        System.out.println("정렬 후: " + Arrays.toString(A));
    }
}
