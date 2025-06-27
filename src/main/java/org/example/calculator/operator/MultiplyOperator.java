package org.example.calculator.operator;

public class MultiplyOperator implements Operator {
    @Override
    public String getSymbol(){
        return "*";
    }

    @Override
    public int getPrecedence(){
        return 2;
    }

    @Override
    public double apply(double a, double b){
        return a*b;
    }
    @Override
    public boolean isLeftAssociative() {
        return true;
    }
}
