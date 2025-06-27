package org.example.calculator.operator;

public interface Operator {
    String getSymbol();
    int getPrecedence();
    double apply(double a, double b);
    boolean isLeftAssociative();
}
