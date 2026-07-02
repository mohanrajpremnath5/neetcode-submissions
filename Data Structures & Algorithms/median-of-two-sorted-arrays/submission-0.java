class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if(B.length < A.length){
            int[] temp = A;
            A = B;
            B = temp;
        }
        int l = 0;
        int r = A.length;
        int total = A.length + B.length;
        int half = (total + 1) / 2;
        while(l<=r){
            int midA = l + (r-l)/2;
            int midB = half - midA;

            int ALeft = midA > 0 ? A[midA-1] : Integer.MIN_VALUE;
            int ARight = midA < A.length ? A[midA] : Integer.MAX_VALUE;
            int BLeft = midB > 0 ? B[midB-1] : Integer.MIN_VALUE;
            int BRight = midB < B.length ? B[midB] : Integer.MAX_VALUE;

            if(ALeft <= BRight && BLeft <= ARight){
                if(total % 2 != 0){
                    return Math.max(ALeft, BLeft);
                } else {
                    return (double)(Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2;
                }
            } else if(ALeft > BRight){
                r = midA - 1;
            } else {
                l = midA + 1;
            }
        }
        return -1;
    }
}
