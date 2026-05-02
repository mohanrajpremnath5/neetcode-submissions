class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] source = s1.toCharArray();
        char[] dest = s2.toCharArray();
        Arrays.sort(source);
        int k = s1.length();
        for(int i=0; i<=s2.length() - k; i++){
            if(i + k > s2.length()){
                break;
            }
            char[] temp = Arrays.copyOfRange(dest, i, i + k);
            Arrays.sort(temp);
            boolean result = Arrays.equals(source,temp);
            if(result){
                return true;
            }
        }
        return false;
    }
}