// Two Jump

import java.util.Scanner;

// public class StairJump {
    // public int calcWays(int n){
    //     int[] a = new int[n+1];
    //     a[0] = 1;
    //     a[1] = 1;
    //     for (int i = 2; i<=n; i++){
    //         a[i] = a[i-1] + a[i-2];
    //     }
    //     return a[n];
    // }
    public class StairJump {
        public int calcWays(int n){
            int[] a = new int[n+1];
            a[0] = 1;
            a[1] = 1;
            a[2] = 2;
            for (int i = 3; i<=n; i++){
                a[i] = a[i-1] + a[i-2] + a[i-3];
            }
            return a[n];
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stairs:");
        int n = sc.nextInt();
        StairJump ob = new StairJump();
        int ans = ob.calcWays(n);
        System.out.println("The result is: " + ans);
        sc.close();
    }
}


// Function for three jump

//         public class StairJump {
//         public int calcWays(int n){
//         int[] a = new int[n+1];
//         a[0] = 1;
//         a[1] = 1;
//         a[2] = 2
//         for (int i = 3; i<=n; i++){
//         a[i] = a[i-1] + a[i-2] + a[i-3];
//         }
//         return a[n];
//         }