class Solution {
    Map<Integer, String> keyMap;
    List<String> ret;
    private void backtrack(String digits, String curr, int i) {
        // base case
        if(i == digits.length()) {
            if(curr != "")
                ret.add(curr);
            return;
        }
        // calling recursion
        String letters = keyMap.get(digits.charAt(i) - '0');
        for(int j = 0; j < letters.length(); j++) {
            backtrack(digits, curr + letters.charAt(j), i + 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        // generating map
        keyMap = new HashMap<>();
        keyMap.put(1, "");
        keyMap.put(2, "abc");
        keyMap.put(3, "def");
        keyMap.put(4, "ghi");
        keyMap.put(5, "jkl");
        keyMap.put(6, "mno");
        keyMap.put(7, "pqrs");
        keyMap.put(8, "tuv");
        keyMap.put(9, "wxyz");
        // using backtracking
        ret = new ArrayList<>();
        backtrack(digits, "", 0);
        return ret;
    }
}