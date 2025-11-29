import java.util.ArrayList;
import java.util.Scanner;

public class Subsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
        Subsets ob = new Subsets(); 
        System.out.println("The subsets are: ");
        ob.subset("", s); 
        System.out.println((ob.subsetAl("", s)));
        sc.close();
    }

    public void subset(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subset(p + ch, up.substring(1)); 
        subset(p, up.substring(1)); 
    }
    
    public ArrayList<String> subsetAl(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subsetAl(p + ch, up.substring(1));
        ArrayList<String> right = subsetAl(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
