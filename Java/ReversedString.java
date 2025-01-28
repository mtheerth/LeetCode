class ReversedString {
    public static String reverseWords(String s) {
        StringBuilder st = new StringBuilder();
        String[] str = s.split(" ");
        for (int i =str.length-1; i >= 0 ; i--){
            if (str[i].equals("")){
                continue;
            }
            st.append(str[i]);
            st.append(" ");
        }
       // output "blue is sky the"
       return st.toString().trim();
    }
    public static void main (String args[]){
      String s = "the sky is      blue";
      System.out.println(reverseWords(s));
    }
}
