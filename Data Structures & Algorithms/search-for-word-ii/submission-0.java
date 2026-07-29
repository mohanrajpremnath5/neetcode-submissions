class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWordExist;

    public TrieNode(){
        children = new HashMap<>();
        isWordExist = false;
    }

    public void addWord(String word){
        TrieNode cur = this;
        for(char c: word.toCharArray()){
            if(cur.children.get(c) == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWordExist = true;
    }
}


class Solution {

    int ROWS;
    int COLS;
    Set<String> result;
    Set<Pair<Integer, Integer>> visited;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        result = new HashSet<>();
        visited = new HashSet<>();

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                dfs(r, c, board, "", root);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(int r, int c, char[][] board, String word, TrieNode root){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS 
            || visited.contains(new Pair<>(r,c))
            || !root.children.containsKey(board[r][c])){
                return;
        }
        
        visited.add(new Pair<>(r,c));
        root = root.children.get(board[r][c]);
        word += board[r][c];
        if(root.isWordExist){
            result.add(word);
        }

        dfs(r+1, c, board, word, root);
        dfs(r-1, c, board, word, root);
        dfs(r, c+1, board, word, root);
        dfs(r, c-1, board, word, root);

        visited.remove(new Pair<>(r,c));
    }
}
