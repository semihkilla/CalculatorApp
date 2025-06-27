package org.example.calculator.operator;

public class SubtractionOperator implements Operator{
    @Override
    public String getSymbol(){
        return "-";
    }

    @Override
    public int getPrecedence(){
        return 1;
    }

    @Override
    public double apply(double a, double b){
        return a - b;
    }

    @Override
    public boolean isLeftAssociative(){
        return true;
    }
}
