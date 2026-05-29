class Solution {
    List<List<String>> ret;
    Boolean isSafe(List<Integer> curr, int row, int col, int n){
        // checking previous columns
        if(curr.isEmpty())
            return true;
        for(int c: curr){
            if(c == col)
                return false;
        }
        // checking upper left diagnol
        for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--){
            if(curr.get(r) == c)
                return false;
        }
        // checking upper right diagnol
        for(int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++){
            if(curr.get(r) == c)
                return false;
        }
        return true;
    }
    private void backtrack(List<Integer> curr, int row, int n) {
        // base case
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(Integer r: curr) {
                String tempStr = "";
                for(int i = 0; i < n; i++) {
                    if(i == r) {
                        tempStr += "Q";
                    }
                    else {
                        tempStr += ".";
                    }
                }
                temp.add(tempStr);
            }
            ret.add(temp);
        }
        // calling recursion
        for(int c = 0; c < n; c++) {
            if(isSafe(curr, row, c, n)) {
                curr.set(row, c);
                backtrack(curr, row + 1, n);
                curr.set(row, -1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        ret = new ArrayList<>();
        // N-Queens problem
        // Each row will contain exactly 1 Queen
        // So, iterate each row one by one
        List<Integer> curr = new ArrayList<>(Collections.nCopies(n, -1));
        backtrack(curr, 0, n);
        return ret;
    }
}
