import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        Permutations ob = new Permutations();
        int[] arr = { 1, 2, 3 };
        String s = "abc";
        System.out.println(ob.permutations1(new ArrayList<>(), arr));
        ob.permutations2("", s);
    }
    public ArrayList<ArrayList<Integer>> permutations1(ArrayList<Integer> p, int[] up){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(up.length == 0){
            result.add(new ArrayList<>(p));
            return result;
        }

        int value = up[0];
        int[] remainingup = Arrays.copyOfRange(up, 1, up.length);

        for(int i = 0; i <= p.size(); i++){
            ArrayList<Integer> newp = new ArrayList<>(p);
            newp.add(i, value);
            result.addAll(permutations1(newp, remainingup));
        }

        return result;
    }

    public void permutations2(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        for(int i = 0; i <= p.length(); i++){
            String newp = p.substring(0, i) + up.charAt(0) + p.substring(i, p.length());
            permutations2(newp, up.substring(1));
        }
    }
}
