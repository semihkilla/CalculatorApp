package org.example.util;
import org.example.calculator.operator.Operator;

import java.util.List;

public class InputValidator {

    public static boolean hasBalancedParantheses(List<String> tokens){
        int count = 0;
        for(String token : tokens){
            if(token.equals("(")) count++;
            else if (token.equals(")")) count--;
            if(count<0) return false;
        }
        return count == 0;
    }

    public static boolean hasNoConsecutiveOperators(List<String> tokens, List<String> operatorSymbols){
        String prev = " ";
        for(String token : tokens){
            if(operatorSymbols.contains(token)&& operatorSymbols.contains(prev)){
                return false;
            }
            prev = token;
        }
        return true;

    }

    public static boolean doesNotStartOrEndWithOperator(List<String> tokens, List<String> operatorSymbols){
        if(tokens.isEmpty()) return false;
        if(operatorSymbols.contains(tokens.get(0)))return false;
        if(operatorSymbols.contains(tokens.get(tokens.size()-1)))return false;
        return true;
    }

    public static boolean numbersAreValid(List<String> tokens){
        for(String token : tokens){
            if (token.equals(".")) return false; // Einzelner Punkt nicht erlaubt!
            if(token.chars().filter(ch->ch == '.').count() >1) return false;
        }
        return true;
    }

    public static boolean isValidExpression(List<String> tokens, List<String> operatorSymbols){
        return hasBalancedParantheses(tokens)
                && hasNoConsecutiveOperators(tokens, operatorSymbols)
                && numbersAreValid(tokens)
                && doesNotStartOrEndWithOperator(tokens, operatorSymbols);

    }
}
