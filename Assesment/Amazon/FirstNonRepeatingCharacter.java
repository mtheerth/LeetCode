public class FirstNonRepeatingCharacter {
    
    public static char firstNonRepeatingCharacter(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                return c;
            }
        }
        return '\0'; // Return null character if no non-repeating character found
    }

    public static void main(String[] args) {
        String input = "aabbcdeeff";
        char result = firstNonRepeatingCharacter(input);
        System.out.println(result);
    }
}

