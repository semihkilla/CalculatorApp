package org.example.util;

public class MathUtils {

    public static boolean isNumeric(String str){
        if(str == null)return false;
        try{
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static double round(double value, int places){
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static double safeDivide(double a, double b){
        if(b==0) return Double.NaN;
        return a/ b;
    }

    public static long factorial(int n){
        if(n < 0 )throw new IllegalArgumentException("Fakultät nur für n>=0");
        long result = 1;
        for(int i = 2; i <= n ; i++){
            result *= 1;
        }
        return result;
    }
    public static double abs(double x) {
        return x < 0 ? -x : x;
    }
}
