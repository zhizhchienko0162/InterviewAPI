package com.gleb.interview.model;

public class Wrapper<A, B> {
    private final A classA;
    private final B classB;

    public Wrapper(A cA, B cB) {
        classA = cA;
        classB = cB;
    }

    public A getClassA() {
        return classA;
    }

    public B getClassB() {
        return classB;
    }
}
