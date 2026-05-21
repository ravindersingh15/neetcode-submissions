class TrieNode {
    TrieNode[] children;
    Boolean isEnd;
    TrieNode() {
        children = new TrieNode[26];
        /*
         * Represents whether a string ended at this node
         */
        isEnd = false;
    }
}
class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean searchHelper(String word, TrieNode curr) {
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '.') {
                // if(i == word.length() - 1) {
                //     return curr.isEnd;
                // }
                for(int j = 0; j < 26; j++) {
                    if(curr.children[j] != null && searchHelper(word.substring(i + 1, word.length()), curr.children[j])){
                        return true;
                    }
                }
                return false;
            }
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }

    public boolean search(String word) {
        return searchHelper(word, root);
    }
}
