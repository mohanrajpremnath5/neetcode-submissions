class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        int index = 0;
        for(int i=0; i<strs.length; i++){
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String str = new String(word);
            result.putIfAbsent(str, new ArrayList<>());
            result.get(str).add(strs[i]);
        }
        return new ArrayList<>(result.values());
    }
}
