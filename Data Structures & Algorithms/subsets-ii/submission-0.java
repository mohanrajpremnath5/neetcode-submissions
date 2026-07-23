class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, result, subset, 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result,
                        List<Integer> subset, int index){
        if(index == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums, result, subset, index + 1);
        subset.remove(subset.size() - 1);
        while(index + 1 < nums.length && 
                nums[index] == nums[index+1]){
            index++;
        }
        dfs(nums, result, subset, index + 1);
    }
}
