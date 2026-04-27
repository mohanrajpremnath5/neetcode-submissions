class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        for(int i=0; i<heights.length; i++){
            int l = i;
            int r = heights.length - 1;
            while(l < r){
                int height = Math.min(heights[i], heights[r]);
                int width = r - i;
                int volume = height * width;
                result = Math.max(volume, result);
                r--;
            }
        }
        return result;
    }
}
