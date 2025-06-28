package org.example.calculator;

import org.example.calculator.operator.*;

public class OperatortTest {
    public static void main (String[] args){
        Operator add = new AdditionOperator();
        Operator sub = new SubtractionOperator();
        Operator mult = new MultiplyOperator();
        Operator div = new DivideOperator();



        try{
            System.out.println("15 / 0 = " + div.apply(15, 0));
        }catch (ArithmeticException ex){
            System.out.println("Fehler: " + ex.getMessage());
        }

    }
}
