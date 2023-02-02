package org.example.chap09;

import org.example.chap05.stack.Stack;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11047
public class 그리디01_buffer {
    public static void main(String[] args) throws IOException {
        // 적절한 해 : 도달액수보다 액면가가 작은 동전부터 최대치로 개수를 만들면서 액면가를 내려가면서 개수를 만든다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];

        for (int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int count=0;

        for(int i=N-1; i>=0; i--) {
            if(coin[i] <= K) {
                count += (K/coin[i]);
                K = K % coin[i];
            }
        }
        System.out.println("동전의 개수 :" + count);
    }
}
