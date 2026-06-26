class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        Arrays.sort(s1Char);
        int range = s1.length();
        for(int i=0; i<=s2.length() - range; i++){
            char temp[] = Arrays.copyOfRange(s2Char, i, i+range);
            Arrays.sort(temp);
            if(Arrays.equals(s1Char, temp)){
                return true;
            }
        }
        return false;
    }
}
