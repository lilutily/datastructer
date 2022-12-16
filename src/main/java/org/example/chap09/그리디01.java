package org.example.chap09;

import org.example.chap05.stack.Stack;

// https://www.acmicpc.net/problem/11047
public class 그리디01 {
    public static void main(String[] args) {
        // 적절한 해 : 도달액수보다 액면가가 작은 동전부터 최대치로 개수를 만들면서 액면가를 내려가면서 개수를 만든다

        int N = 10; // 동전 개수
        int K = 4790; // 목표 액수

        // 동전을 담을 자료구조
        Stack<Integer> A = new Stack<>();
        A.push(1);
        A.push(5);
        A.push(10);
        A.push(50);
        A.push(100);
        A.push(500);
        A.push(1000);
        A.push(5000);
        A.push(10000);
        A.push(50000);
        /*
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //동전의 개수
        int K = sc.nextInt(); //목표 액수

        //동전을 담을 자료구조
        Stack<Integer> A = new Stack<>();
        for (int i = 0; i < N; i++) {
            A.push(sc.nextInt());
        }
        sc.close();

        실전문제에서는 buffer로 풀것
     */


        int count=0; // 뽑은 동전의 수
        while (!A.isEmpty()) { // 동전이 빌때까지 뽑아보자 , 만약 내가 5000보다 작을때까지 찾을거면 반대로 적어줄 것 money>5000 --> 반대로 생각하면 편함
            int coinAmt = A.pop(); // 꼭대기 동전부터 추출
            if(coinAmt <= K) { // 동전 액면가가 목표액 이하면
                count += (K / coinAmt); // 동전 개수 누적
                K %= coinAmt; // 잔액 갱신
            }
            if(K==0) break;
        }
        System.out.println("동전의 개수 : " + count);
    }
}
