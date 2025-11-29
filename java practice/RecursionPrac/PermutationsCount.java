public class PermutationsCount {
    public static void main(String[] args) {
        PermutationsCount ob = new PermutationsCount();
        System.out.println("\nThe number of permutations is: " + ob.permutationCount("", "abc"));
    }
    
    public int permutationCount(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return 1;
        }
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String newp = p.substring(0, i) + up.charAt(0) + p.substring(i, p.length());
            count += permutationCount(newp, up.substring(1));
        }

        return count;
    }
}
