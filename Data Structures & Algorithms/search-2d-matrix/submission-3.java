class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COL = matrix[0].length;
        int top = 0;
        int bot = ROWS - 1;
        int m = 0;
        while(top <= bot){
            m = top + (bot-top)/2;
            if(target < matrix[m][0]){
                bot = m - 1;
            } else if(target > matrix[m][COL - 1]){
                top = m + 1;
            } else {
                break;
            }
        }

        if(top > bot){
            return false;
        }

        int l = 0;
        int r = matrix[m].length;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(target < matrix[m][mid]){
                r = mid - 1;
            } else if(target > matrix[m][mid]){
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}