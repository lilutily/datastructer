package org.example.chap04;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1253
public class 투포인터2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int N = 10; // 재료의 수
        long[] A = {3, 5, 7, 11, 24, 8, 12, 20, 17, 10};
        int count = 0; // target 에 대해 다른 두 수의 합이 N인 경우 ++
        /*
        int M = scan.nextInt();
        int N = scan.nextInt();
        long[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextLong();
        }
        scan.close();

         */

        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        // 모든 수를 순회하여 좋은 수 인지 판단
        // 좋은 수 판단을 위한 숫자 타겟팅
        for (int i = 0; i < A.length; i++) {
            long target = A[i]; // 좋은 수 판단 타겟 숫자

            // 투포인터 알고리즘

            // 투 포인터 초기화
            int start = 0;
            int end = N-1;
            while (start < end) {
                long M = A[start] + A[end];
                System.out.printf("%d %d %d %d \n", start, end, M, target);

                if(target == M) {
                    //
                    if(start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    } else {
                        count++;
                        break;
                    }
                }
                else if(target > M) {
                    start++;
                } else {
                    end--;
                }
            }
            System.out.println(count);
        }
        }
}
