class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        StringBuilder [] st = new StringBuilder [numRows];
        for (int i = 0 ; i < numRows; i++){
            st[i] = new StringBuilder();
        }
        boolean prev = false;
        int index =0;
        for (char c : s.toCharArray()){
             st[index].append(c);
            if (index == 0 || index == numRows - 1) prev = !prev;
            index += prev ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < numRows; i++){
            result.append(st[i].toString());
        }
        return result.toString();
    }
}
