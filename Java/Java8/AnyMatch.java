class AnyMatch {
    public static void main(String[] args) {
       // Write a Java Streams API code snippet to check if a string contains the letter "i"
       String s = "India";
       System.out.println(s.chars().anyMatch(x -> x== 'i'));
       
    }
}
