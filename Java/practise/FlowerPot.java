class FlowerPot {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n ==0) return true;
        for (int i=0; i < flowerbed.length; i++){
           int prev = (i==0 ? flowerbed[i] : flowerbed[i-1]);
           int next = (i == flowerbed.length -1 ? flowerbed[i] : flowerbed[i+1]);
            if (prev == 0  && flowerbed[i] ==0  && next ==0 ){
                n--;
                flowerbed[i] = 1;
            }
        }
        if (n<=0) {
            return true;
        } else {
           return false;
        }
    }
}
