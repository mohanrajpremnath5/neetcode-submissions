class Solution {
    List<List<String>> result = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> posD = new HashSet<>();
    Set<Integer> negD = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, '.');
        }
        backtrack(n, board, 0);
        return result;
    }

    private void backtrack(int n, char[][] board, int r){
        if(r == n){
            List<String> copy = new ArrayList<>();
            for(char[] row: board){
                copy.add(new String(row));
            }
            result.add(copy);
            return;
        }

        for(int c=0; c<n; c++){
            if(col.contains(c) || 
                posD.contains(r+c) ||
                negD.contains(r-c)){
                    continue;
                }

            col.add(c);
            posD.add(r+c);
            negD.add(r-c);
            board[r][c] = 'Q';

            backtrack(n, board, r+1);

            col.remove(c);
            posD.remove(r+c);
            negD.remove(r-c);
            board[r][c] = '.';
        }
    }
}
