class Solution {
    public int largestRectangleArea(int[] heights) {
        // heights=[2, 1, 5, 6, 2, 3]
        int maxResult = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] temp = stack.pop();
                int height = temp[1];
                int index = temp[0];
                maxResult = Math.max(maxResult, height * (i-index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for(int[] pair: stack){
            maxResult = Math.max(maxResult, pair[1] * (heights.length - pair[0]));
        }
        return maxResult;
    }
}
