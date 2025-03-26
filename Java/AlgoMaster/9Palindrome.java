class Solution {
    public boolean isPalindrome(int x) {
        int  y = 0 ;
        if (x <0 || (x%10 == 0 && x!=0)) return false;
        while (y < x){
        y = y *10 + x%10;
        x = x/10;
        }
        return x ==y || x == y/10;
    }
}
