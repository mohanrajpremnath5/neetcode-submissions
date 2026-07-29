class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children.get(c) == null){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode root, int j){
        TrieNode curr = root;
        for(int i=j; i<word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode node: curr.children.values()){
                    if(node != null && dfs(word, node, i+1)){
                        return true;
                    }
                }
                return false;
            } else {
                if(curr.children.containsKey(c)){
                    curr = curr.children.get(c);
                } else {
                    return false;
                }
            }
        }
        return curr.isEndOfWord;
    }
}
