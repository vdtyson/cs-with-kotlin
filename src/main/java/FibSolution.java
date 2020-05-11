public class FibSolution {
    public static int fib(int n) {

        if( n == 0) {
            return 0;
        }

        if( n == 1) {
            return 1;
        }


        return fibHelper(n, 2, 1, 0);
    }


    public static int fibHelper(int targetN, int i, int currentNum, int previousNum) {

        if (i == targetN) {
            return currentNum;
        }
        else {
            return fibHelper(targetN, i + 1, currentNum + previousNum, currentNum);
        }
    }
}
