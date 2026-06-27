class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i),0) + 1);
        }
        int l=0;
        int expected = countT.size();
        int have = 0;
        int minWindow = Integer.MAX_VALUE;
        int[] result = {-1,-1};
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0)+1);
            if(countT.containsKey(c) && countT.get(c) == window.get(c)){
                have++;
            }
            while(have == expected){
                if((r-l+1) < minWindow){
                    minWindow = r-l+1;
                    result[0] = l;
                    result[1] = r;
                }
                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);
                if(countT.containsKey(left) && window.get(left) < countT.get(left)){
                    have--;
                }
                l++;
            }
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1]+1);
    }
}
