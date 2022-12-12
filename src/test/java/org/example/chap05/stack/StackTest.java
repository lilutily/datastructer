package org.example.chap05.stack;

import org.example.chap05.queue.Queue;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void stackTest() {

        Stack<String> foodStack = new Stack<>();
        foodStack.push("짜장면");
        foodStack.push("짬뽕");
        foodStack.push("탕수육");
        foodStack.push("볶음밥");

        String r1=foodStack.pop();
        System.out.println("r1 = " + r1);

        assertEquals("볶음밥", r1);

        foodStack.pop();
        foodStack.pop();
        foodStack.pop();
        foodStack.pop();


//        Queue<String> queue = new LinkedList<>();   --> Queue는 new 할수 없음

    }
}
