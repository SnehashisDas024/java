import java.util.Scanner;

public class KokoEatingBananas {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] piles = new int[n];
    //     System.out.println("Enter the piles: ");
    //     for (int i = 0; i < n; i++) {
    //         piles[i] = sc.nextInt();





    //     }
    //     System.out.println("Enter the hours: ");
    //     int h = sc.nextInt();

    //     KokoEatingBananas sol = new KokoEatingBananas();
    //     int result = sol.minEatingSpeed(piles, h);
    //     System.out.println(result);
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of piles: ");
        int n = sc.nextInt();

        int[] piles = new int[n];
        System.out.println("Enter the piles: ");
        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        System.out.print("Enter the hours: ");
        int h = sc.nextInt();

        KokoEatingBananas sol = new KokoEatingBananas();
        int result = sol.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
        sc.close();
    }

    public int minEatingSpeed(int[] piles, int hrs) {
        int h = piles[0];
        for (int i = 1; i < piles.length; i++){
            h = Math.max(h, piles[i]);
        }
        int l = 1;
        int result = 0;
        while (l <= h){
            int mid = l + (h - l) / 2;
            int sum = 0;
            for (int i = 0; i < piles.length; i++){
                sum += (int) Math.ceil((double)piles[i] / mid);
            }
            if (sum <= hrs && sum > 0){
                result = mid;
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return result;
        
    }
}
