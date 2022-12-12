package org.example.chap05.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1874
// 1. Scanner -> 메모리 많이 잡아먹음
// 2. String s -> Scanner 다음으로 많이먹음 배열은 칸을 늘릴수 없음
// 예를 들어 String s = "asdfg";  |a|s|d|f|g| 이렇게 들어있는데 s="asdfghjk"; 로 바뀌면 기존에 있던 곳 x 새로 만듬
public class 스택수열 {

    public static void main(String[] args) throws IOException {
        // 만들어야 할 수열
//        int N = 8;
//        int[] A = {4, 3, 6, 8, 7, 5, 2, 1};
//        Scanner sc = new Scanner(System.in);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int N = sc.nextInt(); // 1 ~ N까지의 자연수
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        // 만들어야 할 수열
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
//            A[i] = sc.nextInt();
            A[i] = Integer.parseInt(br.readLine());
        }



        // 자연수 변수
        int num = 1;

        // 기호를 저장할 문자열 변수
        // String s= "";
        StringBuilder s = new StringBuilder("");


        // 수열배열 A에서 값을 하나씩 타겟팅해서 push, pop 여부 확인
        for (int i = 0; i < N; i++) {
            int targetNum = A[i]; // 현재 타겟 값


            // push 인 경우
            if(targetNum >= num) {
                while (targetNum >= num) {
                    stack.push(num++);
//                    s += "+\n";
                    s.append("+\n");
                }
                // targetNum에 도달하는 순간 해당 숫자를 pop해준다
                Integer k = stack.pop();
//                s += "-\n";
                s.append("-\n");
            }

            // pop인 경우
            else {
                Integer n = stack.pop();
                if(n > targetNum) {
                    // 스택 수열 실패 케이스
//                    System.out.println("no");
                    s = new StringBuilder("no");
                    break;
                }
                else {
                    s.append("-\n");
                }
            }
        }
    }

}
