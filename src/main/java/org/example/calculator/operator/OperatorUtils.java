package org.example.calculator.operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorUtils {
    public static Map<String, Operator> createOperatorMap(){
        Map<String, Operator> map = new HashMap<>();
        map.put("+", new AdditionOperator());
        map.put("-", new SubtractionOperator());
        map.put("*", new MultiplyOperator());
        map.put("/", new DivideOperator());

        return map;
    }
}
