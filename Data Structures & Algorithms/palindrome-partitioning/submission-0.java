class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> subset = new ArrayList<>();
        dfs(s, result, subset, 0);
        return result;
    }

    private void dfs(String s, List<List<String>> result,
        List<String> subset, int i){
        if(i == s.length()){
            result.add(new ArrayList<>(subset));
            return;
        }
        for(int j=i; j<s.length(); j++){
            if(isPalindrome(s, i, j)){
                subset.add(s.substring(i, j+1));
                dfs(s, result, subset, j+1);
                subset.remove(subset.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
