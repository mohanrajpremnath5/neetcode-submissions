class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, result, combinations, target, 0);
        return result;
    }

    private void dfs(int[] candidates, int i, List<List<Integer>> result, 
                        List<Integer> combinations, int target, int total) {
        if(total == target){
            result.add(new ArrayList<>(combinations));
            return;
        }
        if(total > target || i >= candidates.length){
            return;
        }
        combinations.add(candidates[i]);
        dfs(candidates, i+1, result, combinations, target, total + candidates[i]);
        combinations.remove(combinations.size() - 1);
        while(i+1 < candidates.length && 
                candidates[i] == candidates[i+1]){
            i++;
        }
        dfs(candidates, i+1, result, combinations, target, total);
    }
}
