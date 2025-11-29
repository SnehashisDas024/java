public class String_ {
    public String withoutA(String s) {
        if (s.isEmpty()) {
            return "";
        }
        if (s.charAt(0) == 'A' || s.charAt(0) == 'a') {
            return "" + withoutA(s.substring(1));
        }
        return s.charAt(0) + withoutA(s.substring(1));
    }

    public static void main(String[] args) {
        String s = "baccad";
        System.out.println(s);
        // StringBuilder str = new StringBuilder(s);
        String_ ob = new String_();
        System.out.println(ob.withoutA(s));
    }
}
