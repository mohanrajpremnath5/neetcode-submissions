class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        dfs(nums, 0, combinations, result, 0, target);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> combinations,
                        List<List<Integer>> result, int total, int target){
        if(total == target){
            result.add(new ArrayList<>(combinations));
            return;
        }
        if(total > target || index >= nums.length){
            return;
        }
        combinations.add(nums[index]);
        dfs(nums, index, combinations, result, total + nums[index], target);
        combinations.remove(combinations.size() - 1);
        dfs(nums, index+1, combinations, result, total, target);
    }
}
