class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> bracket = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        bracket.put(')','(');
        bracket.put('}','{');
        bracket.put(']','[');
        
        for(int i=0; i<s.length(); i++){
            if(bracket.containsKey(s.charAt(i))){
                if(!stack.isEmpty() && stack.peek() == bracket.get(s.charAt(i))){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
