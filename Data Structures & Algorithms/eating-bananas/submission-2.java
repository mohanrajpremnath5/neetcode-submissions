class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int result = r;
        while(l <= r){
            int k = l + (r-l)/2;
            long hours = 0;
            for(int i=0; i<piles.length; i++){
                hours += Math.ceil((double) piles[i] / k);
            }
            if(hours <= h){
                r = k - 1;
                result = Math.min(result, k);
            } else {
                l = k + 1;
            }
        }
        return result;
    }
}
