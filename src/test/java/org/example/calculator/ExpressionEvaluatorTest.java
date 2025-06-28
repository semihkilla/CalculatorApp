package org.example.calculator;

import org.example.calculator.operator.Operator;
import org.example.calculator.operator.OperatorUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExpressionEvaluatorTest {
    public static void main(String[] args){

        Map<String, Operator> operatorMap = OperatorUtils.createOperatorMap();

        ExpressionEvaluator exprev = new ExpressionEvaluator(operatorMap);



        // Beispiel 1: 2 + 3 * 4
        List<String> postfix6 = Arrays.asList("2", "3", "4", "*", "+");
        System.out.println(exprev.evaluatePostfix(postfix6)); // Erwartet: 14

// Beispiel 2: 5 * (1 + 2)
        List<String> postfix7 = Arrays.asList("5", "1", "2", "+", "*");
        System.out.println(exprev.evaluatePostfix(postfix7)); // Erwartet: 15

// Beispiel 3: 10 / 2 + 3
        List<String> postfix = Arrays.asList("10", "2", "/", "3", "+");
        System.out.println(exprev.evaluatePostfix(postfix)); // Erwartet: 8

    }
}
