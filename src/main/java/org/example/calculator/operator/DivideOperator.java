package org.example.calculator.operator;

public class DivideOperator implements Operator {

    @Override
    public String getSymbol(){
        return "/";
    }

    @Override
    public int getPrecedence(){
        return 2;
    }

    @Override
    public double apply(double a, double b){
        if(b == 0){
            throw new ArithmeticException("Can not divide with zero");
        }
        return a/b;
    }

    @Override
    public boolean isLeftAssociative(){
        return true;
    }
}
