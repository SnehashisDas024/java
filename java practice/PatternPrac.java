public class PatternPrac {
    public static void main(String[] args) {
        PatternPrac ob = new PatternPrac();
        ob.Pattern2();
    }

    public void Pattern1(){
        int n = 5;
        for (int i = 1; i <= 2 * n; i++) {
            int col = i > n ? i - n : n - i + 1;
            int spaces = n - col;
            for (int k = 1; k <= spaces; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= col; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    public void Pattern2(){
        int n = 5;
        for(int i=1;i<=n;i++){
            int col = 2*i-1;
            int spaces = n - i;
            for (int k = 1; k <= spaces; k++) {
                System.out.print(" ");
            }
            for (int j=1;j<=col;j++){
                if (i != n)
                    System.out.print((j == 1) ? "*" : (j == col) ? "*" : " ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
