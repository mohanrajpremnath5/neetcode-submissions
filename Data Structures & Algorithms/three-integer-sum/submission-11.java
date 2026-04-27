class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums[0] > 0){
            return result;
        }
        for(int i=0; i<nums.length; i++){
            int l = i + 1;
            int r = nums.length - 1;
            while(l <= r){
                if(l == r && l != nums.length - 1){
                    l++;
                    if(l == nums.length - 1){
                        l = r + 1;
                        continue;
                    }
                    r = nums.length - 1;
                }
                boolean threeSum = nums[i] + nums[l] + nums[r] == 0;
                List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                if(threeSum && !result.contains(list)){
                    result.add(list);
                }
                r--;
            }
        }
        return result;
    }
}
