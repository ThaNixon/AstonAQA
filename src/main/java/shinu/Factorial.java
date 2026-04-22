package shinu;

public class Factorial {
    public static int getFactorial(int n){
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
