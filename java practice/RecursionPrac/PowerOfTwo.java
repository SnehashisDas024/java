public class PowerOfTwo {
    public static void main(String[] args) {
        int[] testCases = { 1, 2, 3, 8, 16, 31, 64, 100 };

        for (int n : testCases) {
            boolean result = isPowerOfTwo(n);
            System.out.println(n + " → " + result);
        }
    }
    public static boolean isPowerOfTwo(int n){
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if(n%2 != 0){
            return false;
        } else{
            return isPowerOfTwo(n / 2);
        }
    }
}
