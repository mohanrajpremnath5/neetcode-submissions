class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for(int i=0; i<nums.length-k+1; i++){
            int[] arr = Arrays.copyOfRange(nums, i, i+k);
            result[i] = Arrays.stream(arr).max().getAsInt();
        }
        return result;
    }
}
