package org.example.lamdba.basic;

public class Operator {
    private int n1, n2;
    public Operator(int n1, int n2) {
        this.n1=n1;
        this.n2=n2;
    }
    public int operate(Calculator calculator) {
        return calculator.calc(n1,n2);
    }
}
