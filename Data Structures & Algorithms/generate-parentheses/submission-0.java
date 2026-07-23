class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder paranthesis = new StringBuilder();
        dfs(result, paranthesis, n, 0, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder paranthesis, 
                    int n, int openP, int closeP){
        if(openP == closeP && openP == n){
            result.add(paranthesis.toString());
            return;
        }
        if(openP < n){
            paranthesis.append("(");
            dfs(result, paranthesis, n, openP + 1, closeP);
            paranthesis.deleteCharAt(paranthesis.length() - 1);
        }
        if(closeP < openP){
            paranthesis.append(")");
            dfs(result, paranthesis, n, openP, closeP + 1);
            paranthesis.deleteCharAt(paranthesis.length() - 1);
        }
    }
}
