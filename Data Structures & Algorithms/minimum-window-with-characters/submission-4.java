class Solution {
    public String minWindow(String s, String t) {
        if(t == null || t.length() == 0){
            return "";
        }
        int l = 0;
        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i),0)+1);
        }
        int need = countT.size();
        int have = 0;
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1,-1};
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0)+1);

            if(countT.containsKey(c) && countT.get(c) == window.get(c)){
                have++;
            }
            while(have == need){
                if((r-l)+1 < resLen){
                    resLen = (r-l)+1;
                    res[0] = l;
                    res[1] = r;
                }
                char left = s.charAt(l);
                window.put(left, window.get(left)-1);
                if(countT.containsKey(left) && window.get(left) < countT.get(left)){
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
