class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stone: stones){
            pq.offer(-stone);
        }

        while(pq.size() > 1){
            Integer first = pq.poll();
            Integer second = pq.poll();
            if(second > first){
                pq.offer(first - second);
            }
        }
        pq.offer(0);
        return Math.abs(pq.peek());
    }
}
