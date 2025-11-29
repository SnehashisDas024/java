public class RevPref {
    public static void main(String[] args) {
        RevPref sol = new RevPref();
        String word = "abcdefd";
        char ch = 'd';
        String result = sol.reversePrefix(word, ch);
        System.out.println(result); // Output: dcbaefd
    }

    public String reversePrefix(String word, char ch){
        int idx = word.indexOf(ch);
        if (idx == -1)
            return word;
        else{
            StringBuilder sb = new StringBuilder(word.substring(0,idx+1));
            sb.reverse();
            sb.append(word.substring(idx+1));
            return sb.toString();
        }
    }
}
