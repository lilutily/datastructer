package org.example.chap06.insertion;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr) {
        // [6, 9, 15, 5, 2]
        // 두 번째 데이터부터 타겟팅해서 시작
        for (int i = 1; i < arr.length; i++) {

            // 타겟 데이터 백업
            int target = arr[i]; // 9
            int j = i; // i를 백업
            while (j > 0 && arr[j-1] >= target) {
                // 타겟의 왼쪽 데이터가 타겟보다 크면 왼쪽 데이터를 우측으로 한 칸 이동
                arr[j] = arr[j-1];
                j--;
            }
            // while 문이 끝났을때 그 자리가 target 가 들어갈 자리
            arr[j] = target; // 찾은 위치에 타겟데이터 삽입
        }
    }

    public static void main(String[] args) {
        int[] arr = {33, 11, 99, 1, 22, 88, 55, 44, 66, 77};

        sort(arr); // 삽입정렬

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }
}
