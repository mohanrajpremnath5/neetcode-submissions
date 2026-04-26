class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: charArray){
            if(isAlphaNumeric(c)){
                sb.append(c);
            }
        }
        if(sb.toString().toLowerCase().equals(sb.reverse().toString().toLowerCase())){
            return true;
        }
        return false;
    }

    private boolean isAlphaNumeric(char c){
        if(c >= 'a' && c <= 'z' ||
           c >= 'A' && c <= 'Z' ||
           c >= '0' && c <= '9'){
            return true;
           }
        return false;
    }
}
