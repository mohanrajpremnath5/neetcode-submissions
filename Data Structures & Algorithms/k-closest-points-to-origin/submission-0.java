class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> minHeap = 
            new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        
        for(int[] point: points){
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }

        for(int i=0; i<k; i++){
            int[] value = minHeap.poll();
            result[i] = new int[]{value[1], value[2]};
        }
        return result;
    }
}