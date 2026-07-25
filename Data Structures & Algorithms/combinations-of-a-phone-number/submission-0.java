class Solution {

    String[] digitsStr = new String[]{"", "","abc",
            "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        String currStr = "";
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        backtrack(0, digits, currStr);
        return result;
    }

    private void backtrack(int i, String digits, String currStr){
        if(i == digits.length()){
            result.add(currStr);
            return;
        }

        String arrString = digitsStr[digits.charAt(i) - '0'];
        for(char c: arrString.toCharArray()){
            backtrack(i+1, digits, currStr+c);
        }
    }
}
