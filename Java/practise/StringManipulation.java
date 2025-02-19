package my.test;

public class StringManipulation {
	public static void main(String... args) {
		String input = "3[a]2[bc]";
		StringBuilder output = new StringBuilder();;    // "aaabcbc"
		int count =0 ;
		StringBuilder sf = null;
		int open =0 ;
		int close = 0;
		for (Character c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				count = c - '0';
			}
			if (c == '[') {
				open++;
				sf = new StringBuilder();
			} 
			if (Character.isAlphabetic(c) && open >0) {
				sf.append(c);
			}
			if (c == ']') {
				if (open > 0) {
					open --; //balance
				} else {
					close++;
				}				
			}
			if ( count > 0 && open ==0 && close == 0 && sf != null && !sf.isEmpty()) {
				for (int i =0 ; i< count ; i++) {
					output.append(sf.toString());
				}
				sf =null;
			}
		}
		System.out.println(output.toString());
	}

}

