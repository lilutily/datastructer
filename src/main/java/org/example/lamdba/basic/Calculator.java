package org.example.lamdba.basic;

@FunctionalInterface // 람다식을 쓸 수 있는 인터페이스 인지 컴파일 라인에서 체크해줌
public interface Calculator {

    int calc(int n1, int n2); // 호출을 할때 더할지 뺄지 나눌지 등등을 알려달라!

    // void zz(); // 만약 추상메서드가 하나 더있으면 에러가 뜸
    default void zz() {}; // default 메서드는 됨
    /*
    int add(int n1, int n2);

    int sub(int n1, int n2);

    default  int multi(int n1, int n2) {
        return 0; // 오버라이딩 강제를 막아줌
    };

     */
}
