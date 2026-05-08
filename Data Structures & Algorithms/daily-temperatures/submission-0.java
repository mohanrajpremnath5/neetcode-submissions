class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<temperatures.length; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]){
                int[] temp = stack.pop();
                result[temp[1]] = i - temp[1];
            }
            stack.push(new int[] {t, i});
        }
        return result;
    }
}
