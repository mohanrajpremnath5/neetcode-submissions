class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] numVisited = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        dfs(nums, numVisited, result, permutation);
        return result;
    }

    private void dfs(int[] nums, boolean[] numVisited, 
        List<List<Integer>> result, List<Integer> permutation){
        if(permutation.size() == nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!numVisited[i]){
                permutation.add(nums[i]);
                numVisited[i] = true;
                dfs(nums, numVisited, result, permutation);
                permutation.remove(permutation.size() - 1);
                numVisited[i] = false;
            }
        }
    }
}
