import java.util.Scanner;
public class FirstUpper {
    public char isUpperRecursion(String word, int index){
        if (index == word.length()){
            return '\0';
        }
        else{
            if(Character.isUpperCase(word.charAt(index))){
                return word.charAt(index);
            }
            else{
                return isUpperRecursion(word, index+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
        FirstUpper ob = new FirstUpper();
        char ch = ob.isUpperRecursion(s, 0);
        if (ch == '\0'){
            System.out.println("No upper case character present in the string");
        }
        else{
            System.out.println("The first upper case character is: "+ch);
        }
        sc.close();
    }
}
