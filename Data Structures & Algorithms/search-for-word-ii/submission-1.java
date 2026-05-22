/*
 * There are multiple solutions to this problem:
 * 1. For each word - use DFS/BFS to check if word exists - TC: O(words.size() * board.length * board.length)
 * 2. Using Trie + DFS - Traverse all paths using DFS and use Trie to check whether to continue or not - TC: O(words.length * word.length)
 */
class TrieNode {
    TrieNode[] children;
    int count;
    /*
     * Index use is same to represent the end of word
     */
    int index;
    TrieNode() {
        children = new TrieNode[26];
        count = 0;
        index = -1;
    }
}
class Solution {
    List<String> ret;
    public int dfs(TrieNode trieNode, char[][] board, String[] words, int r, int c, int m, int n) {
        // Need to prune the paths in Trie if found any word
        if(board[r][c] == '*') {
            return 0;
        }
        if(trieNode.count <= 0) {
            return 0;
        }
        int count = 0;
        if(trieNode.index != -1) {
            count++;
            ret.add(words[trieNode.index]);
            trieNode.index = -1;
        }
        // traversing all paths
        char temp = board[r][c];
        board[r][c] = '*';
        if(r > 0 && board[r - 1][c] != '*' && trieNode.children[board[r - 1][c] - 'a'] != null && trieNode.children[board[r - 1][c] - 'a'].count > 0) {
            count += dfs(trieNode.children[board[r - 1][c] - 'a'], board, words, r - 1, c, m, n);
        }
        if(c > 0 && board[r][c - 1] != '*' && trieNode.children[board[r][c - 1] - 'a'] != null && trieNode.children[board[r][c - 1] - 'a'].count > 0) {
            count += dfs(trieNode.children[board[r][c - 1] - 'a'], board, words, r, c - 1, m, n);
        }
        if(r < m - 1 && board[r + 1][c] != '*' && trieNode.children[board[r + 1][c] - 'a'] != null && trieNode.children[board[r + 1][c] - 'a'].count > 0) {
            count += dfs(trieNode.children[board[r + 1][c] - 'a'], board, words, r + 1, c, m, n);
        }
        if(c < n - 1 && board[r][c + 1] != '*' && trieNode.children[board[r][c + 1] - 'a'] != null && trieNode.children[board[r][c + 1] - 'a'].count > 0) {
            count += dfs(trieNode.children[board[r][c + 1] - 'a'], board, words, r, c + 1, m, n);
        }
        board[r][c] = temp;
        trieNode.count -= count;
        return count;
    }
    public List<String> findWords(char[][] board, String[] words) {
        // Constructing Trie
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            TrieNode curr = root;
            curr.count++;
            for(char c: s.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
                curr.count++;
            }
            curr.index = i;
        }
        // Now, traversing each path using DFS
        ret = new ArrayList<String>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(root.children[board[i][j] - 'a'] != null) {
                    root.count -= dfs(root.children[board[i][j] - 'a'], board, words, i, j, board.length, board[0].length);
                }
            }
        }
        return ret;
    }
}