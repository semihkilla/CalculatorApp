package org.example.calculator;
import org.example.calculator.operator.OperatorUtils;
import org.example.calculator.operator.Operator;

import java.util.List;
import java.util.Map;

public class Calculator {
    private final ExpressionEvaluator evaluator ;

    public Calculator(){
        Map<String, Operator> operatorMap = OperatorUtils.createOperatorMap();
        this.evaluator = new ExpressionEvaluator(operatorMap);
    }
    public double calculate(String expression){
        List<String> tokens = evaluator.tokenize(expression);
        List<String> postfix = evaluator.infixToPostfix(tokens);
        return evaluator.evaluatePostfix(postfix);
    }

    public String calculateSafe(String expression){
        try{
            double result = calculate(expression);
            return String.valueOf(result);
        } catch (ArithmeticException e) {
            return "Fehler: " + e.getMessage();
        }catch (Exception e){
            return "Ungültiger Ausdruck!";
        }

    }
}
