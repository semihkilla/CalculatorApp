package org.example.util;

import java.util.Arrays;
import java.util.List;

public class InputValidatorTest {
    public static void main(String[] args) {
        List<String> operatorSymbols = Arrays.asList("+", "-", "*", "/");

        // Beispiele
        List<String> expr1 = Arrays.asList("(", "2", "+", "3", ")", "*", "5"); // gültig
        List<String> expr2 = Arrays.asList("2", "+", "+", "3");                // ungültig
        List<String> expr3 = Arrays.asList("5", ".", ".", "1", "+", "2");      // ungültig (falsches Zahlenformat)
        List<String> expr4 = Arrays.asList("(", "2", "+", "3", "*", "5");      // ungültig (Klammer fehlt)
        List<String> expr5 = Arrays.asList("2", "+", "3", "*", "(", "5", "-","1", ")", ")"); // ungültig (zuviele Klammern)
        List<String> expr6 = Arrays.asList("+", "2", "*", "3");     // falsch (Start mit Operator)
        List<String> expr7 = Arrays.asList("2", "*", "3", "-");     // falsch (Ende mit Operator)
        List<String> expr8 = Arrays.asList("3.14", "+", "2.7");     // korrekt (Dezimalzahlen)

        System.out.println(InputValidator.isValidExpression(expr1, operatorSymbols)); // true
        System.out.println(InputValidator.isValidExpression(expr2, operatorSymbols)); // false
        System.out.println(InputValidator.isValidExpression(expr3, operatorSymbols)); // false
        System.out.println(InputValidator.isValidExpression(expr4, operatorSymbols)); // false
        System.out.println(InputValidator.isValidExpression(expr5, operatorSymbols)); // false
        System.out.println(InputValidator.isValidExpression(expr6, operatorSymbols)); // false
        System.out.println(InputValidator.isValidExpression(expr7, operatorSymbols)); // false
        System.out.println(InputValidator.isValidExpression(expr8, operatorSymbols)); // true

    }
}
