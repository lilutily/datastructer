package org.example.chap09;

import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1541
public class 잃어버린괄호 {

    // 최소값을 만드는거니까 그냥 +끼리 괄호를 쳐버리면? -할때 크게 빠질듯

    public static void main(String[] args) {

        // 문자열 분리함수
        // split, StringTokenizer
        String str =  "100-40+50+74-30+29-45+43+11";

        StringTokenizer st = new StringTokenizer(str, "-"); // ""을 따로 안주면 기본적으로 공백을 기준으로 잘라줌

        int answer = 0; // 연산결과 저장
        for (int i=0; st.hasMoreTokens(); i++) { // 토큰을 다 뽑을때까지
            String s = st.nextToken();
            int sum = makeSum(s);
            if(i==0) {
                answer += sum;
            } else {
                answer -= sum;
            }
            System.out.println(answer);
        }
        /* 문자를 배열로 리턴해줌
        String[] sArr = str.split("-");
        System.out.println(Arrays.toString(sArr));

        */

    }

    // 토큰 문자열을 받아서 총합을 구해주는 메서드
    private static int makeSum(String s) {
        int total = 0; // 총합
        StringTokenizer st = new StringTokenizer(s, "+");
        while (st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken());
        }
        return total;
    }

}
