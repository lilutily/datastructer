package org.example.chap06.bubble;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] arr) {

        for (int i=arr.length-1; i>0; i--) { // 회차가 끝날때 마다 하나씩 제외되니까

            boolean flag = false;
            for (int j=0; j<i; j++) { // i 앞에서 시프트 f6누르면 다바꿀수 있음 j로 바꿈, 하나씩 제외되니까 i만큼반복한다
                if(arr[j] > arr[j+1]) { // 인접 자료를 비교해서 원쪽이 더 크면 스왑해준다
                    // swap 앞과 뒤를 비교했을때 앞이 더 크면 뒤랑 자리를 바꿔줘야됨
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag=true;
                } // 블록으로 지정하고 컨트롤 알트 t 누르면 for문으로 감쌀 수 있음
            }
            // 만약 스왑이 일어나지 않으면 정렬이 끝난것
            if(!flag) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {33, 11, 99, 1, 22, 88, 55, 44, 66, 77};

        sort(arr); // 버블정렬

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }
    // 선택정렬도 버블정렬과 유사함 가장 작은것과 스왑하는거니까..
}
