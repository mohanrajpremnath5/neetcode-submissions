class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r){
            int area = (r-l) * Math.min(heights[l], heights[r]);
            if(heights[l] < heights[r]){
                l += 1;
            } else {
                r -= 1;
            }
            result = Math.max(result, area);
        }
        return result;
    }
}
