class Solution {
    private Set<Integer> getConnectedIndex(HashMap<String, List<Integer>> edge, String s) {
        Set<Integer> ret = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            String pattern = s.substring(0, i) + '*' + s.substring(i + 1);
            if(edge.get(pattern) != null) {
                ret.addAll(edge.get(pattern));
            }
        }
        return ret;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // when we will do any bfs/dfs or any other shortest distance algorithm
        // we have to check - if there is any edge between two words
        // for that:
        // M1: O(n * n)
        // M2: Replacing one character in each string and forming one hashmap to get the edges
        // it will consume space - O(n * m)
        HashMap<String, List<Integer>> edge = new HashMap<>();
        for(int j = 0; j < wordList.size(); j++) {
            String s = wordList.get(j);
            for(int i = 0; i < s.length(); i++) {
                String pattern = s.substring(0, i) + '*' + s.substring(i + 1);
                edge.computeIfAbsent(pattern, k -> new ArrayList<>()).add(j);
            }
        }
        // now, using bfs
        List<Boolean> vis = new ArrayList<>(wordList.size());
        for(int i = 0; i < wordList.size(); i++) {
            vis.add(Boolean.FALSE);
        }
        // inserting base integers
        Set<Integer> base = getConnectedIndex(edge, beginWord);
        Queue<Integer> q = new ArrayDeque<>(base);
        for(Integer b: base) {
            vis.set(b, Boolean.TRUE);
        }
        int step = 1;
        while(!q.isEmpty()) {
            Integer count = q.size();
            step++;
            for(int i = 0; i < count; i++) {
                Integer idx = q.poll();
                if(wordList.get(idx).equals(endWord)) {
                    return step;
                }
                Set<Integer> connected = getConnectedIndex(edge, wordList.get(idx));
                for(Integer c: connected) {
                    if(!vis.get(c)) {
                        vis.set(c, Boolean.TRUE);
                        q.add(c);
                    }
                }
            }
        }
        return 0;
    }
}