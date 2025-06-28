package org.example.calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    public static void main(String[] args){
        Calculator calculator = new Calculator();

        String[] tests = {
                "2 + 3 * 4",          // 14
                "(10 - 2) * 3 + 1",   // 25
                "3.5 * 2",            // 7.0
                "5 / 0",              // Fehler: Division durch Null
                "2 + (3 *",           // Ungültiger Ausdruck!
                "abc + 3"             // Ungültiger Ausdruck!
        };
        for(String expr : tests){
            String result = calculator.calculateSafe(expr);
            System.out.printf("Eingabe: %-15s Ergebnis: %s%n", expr, result);
        }
        }
    }
