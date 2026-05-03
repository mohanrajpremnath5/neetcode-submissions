class Solution {
    public int[] maxSlidingWindow(int[] nums, int k){
        int length = nums.length - k + 1;
        int[] result = new int[length];
        for(int i = 0; i<length; i++){
            int[] range = Arrays.copyOfRange(nums, i, i+k);
            // int max = Integer.MIN_VALUE;
            int max = Arrays.stream(range).max().getAsInt();
            // for(int j=0; j<range.length; j++){
            //     if(range[j] > max){
            //         max = range[j];
            //     }
            // }
            result[i] = max;
        }
        return result;
    }
}
