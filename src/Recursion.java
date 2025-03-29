public class Recursion {

    //write a recursive function to calculate the factorial of a number
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void fun(int x) {
        if (x > 0) {
            System.out.print(x + " ");
            fun(x - 1);
        }
    }

    public static int sumOfNaturalNumbers(int n) {
        if(n==0){
            return 0;
        }else {
            return n + sumOfNaturalNumbers(n-1);
        }
    }
}
