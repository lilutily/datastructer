package org.example.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static org.example.chap07.merge.MergeSort.sort;

// https://www.acmicpc.net/problem/1517
public class 버블소트 {
    /*
        N^2 사용하는듯
        수열에 대해 버블소트를 진행했을때 몇번의 스왑이 일어나는지

       p1                p2
       |                 |
       0   1   2   3     4  5   6   7
    [ 24, 32, 42, 60 ] [ 5, 15, 45, 90 ]

    [  5 ]
      |
     insertSpot

    - 병합 과정에서 뒤쪽 배열의 값이 작은경우 5의 값이
       4번인덱스에서 0번으로 이동하므로
       버블정렬에서 4번 스왑이 일어났다고 볼 수 있음

                             |  |
       0   1   2   3     4   5  6   7
    [ 24, 32, 42, 60 ] [ 5, 15, 45, 90 ]

    [  5, 15, 24, 32  , 42, 45 ]

    - 병합 과정에서 뒤쪽 배열의 값이 작은경우 45의 값이 6번인덱스에서 5번으로 이동하므로
      버블정렬에서 1번 스왑이 일어났다고 볼 수 있음

    */
    private static int[] temp;
    private static long count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        sort(A);

        System.out.println(count);
    }

    private static void mergeSort(int[] arr, int start, int end) {

        if (end - start < 1) return;

        int middle = (start + end) / 2;

        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);

        for (int i = start; i < end; i++) {
            temp[i] = arr[i];
        }

        int p1 = start;
        int p2 = middle + 1;

        int insertSpot = start;

        while (p1 <= middle && p2 <= end) {
            if (temp[p1] > temp[p2]) {
                arr[insertSpot++] = temp[p2++];
            } else if (p1 < p2) {
                arr[insertSpot++] = temp[p1++];
            }
        }

        // 만약에 p1이 먼저 끝나면 끝값이 middle, p2이 먼저 끝나면 end
        if (p1 <= middle) {
            arr[insertSpot++] = temp[p1++];
        } else if (p2 <= end) {
            arr[insertSpot++] = temp[p2++];
        }
    }

    public static void sort(int[] arr) {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

}
