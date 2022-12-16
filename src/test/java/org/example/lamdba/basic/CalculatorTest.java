package org.example.lamdba.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void test() {
        /*
            람다식을 쓰기 위한 전제조건
            해당 인터페이스에 추상메서드가 반드시 단 한개일 것

        Calculator addCalc = new Calculator() {
            @Override
            public int calc(int n1, int n2) { // 강제 오바라이딩 하는건 하나니까,,
                return n1 + n2; // 익명 클래스를 사용하면 내가 하고싶은 식만 쓰면됨
            }
        };
        */

        Calculator addCalc = (n1, n2) -> n1 + n2;
        int r1 = addCalc.calc(10,20);
        System.out.println("r1 = " + r1);

        Calculator multiCalc = (n1,n2) -> n1 * n2;
        int r2= multiCalc.calc(4,5);
        System.out.println("r2 = " + r2);

        // 연산이 필요할 때 마다 객체를 만들어서 계속 만드는건 효율적이지 못함
        Operator op = new Operator(10,20);

        op.operate(addCalc);

        int r3 = op.operate((n1,n2) -> n1 -n2);
        System.out.println("r3 = " + r3);

        int r4 = op.operate((n1, n2) -> n1 % n2);
        System.out.println("r4 = " + r4);

    }


        /*
        Calculator casio = new CasioCalculator();
        casio.add(10,20);

        Calculator sharp = new Calculator() { // 한번쓰고 버릴거임 --> 익명클래스
            @Override
            public int add(int n1, int n2) {
                System.out.println("샤프 계산기로 더하기");
                return n1+n2;
            }

            @Override
            public int sub(int n1, int n2) {
                return 0;
            }
        };
        sharp.add(3, 4);

         */
}

