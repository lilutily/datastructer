package org.example.lamdba.advance;

public interface Predicate<T> { // 제너릭 타입을 써서 범용적으로 사용해보자

    boolean test(T t);
}
