class Solution {
    public int[] maxSlidingWindow(int[] nums, int k){
        int length = nums.length - k + 1;
        int[] result = new int[length];
        for(int i = 0; i<length; i++){
            int[] range = Arrays.copyOfRange(nums, i, i+k);
            result[i] = Arrays.stream(range).max().getAsInt();
        }
        return result;
    }
}
