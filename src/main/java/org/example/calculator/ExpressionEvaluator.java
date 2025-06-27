package org.example.calculator;

import org.example.calculator.operator.Operator;

import java.util.*;

public class ExpressionEvaluator {

    private final Map<String, Operator> operatorMap;

    private boolean isNumber(String token){
        try{
            Double.parseDouble(token);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isOperator(String token){
        return operatorMap.containsKey(token);
    }

    public ExpressionEvaluator(Map<String,Operator> operatorMap){
        this.operatorMap = operatorMap;
    }

    public List<String> tokenize(String expr){

        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        char[] chars = expr.replaceAll(" ","").toCharArray();

        for(int i =0; i< chars.length;i++){
            char c = chars[i];

            if(Character.isDigit(c) || c == '.'){
                number.append(c);
            }

            else if(operatorMap.containsKey(String.valueOf(c))){
                if(!number.isEmpty()) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }
                tokens.add(String.valueOf(c));

        }
            else if(c == '(' || c == ')'){
                if(!number.isEmpty()){
                    tokens.add(number.toString());
                    number.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }


    }
        if(!number.isEmpty()){
            tokens.add(number.toString());
        }
        return tokens;
}

    public List<String> infixToPostfix(List<String> tokens ){

        Stack<String> opStack = new Stack<>();
        List<String> output = new ArrayList<>();

        for(String token : tokens){
            if(isNumber(token)) {
                output.add(token);
            }
            else if(isOperator(token)){
                while(!opStack.isEmpty() &&
                        isOperator(opStack.peek()) &&
                        (operatorMap.get(opStack.peek()).getPrecedence() >= operatorMap.get(token).getPrecedence())){
                    output.add(opStack.pop());
                }
                opStack.push(token);
            }
            else if(token.equals("(")){
                opStack.push(token);
            }
            else if(token.equals(")")){
                while(!opStack.peek().equals("(")){
                    output.add(opStack.pop());
                }
                opStack.pop();
            }
        }
        while(!opStack.isEmpty()){
            output.add(opStack.pop());
        }
        return output;
    }

    public double evaluatePostfix(List<String> postfix){
        Stack<Double> stack = new Stack<>();
        for(String token : postfix){
            if(isNumber(token)){
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                double result = operatorMap.get(token).apply(a, b);
                stack.push(result);

            }
        }
        return stack.pop();
    }
}
