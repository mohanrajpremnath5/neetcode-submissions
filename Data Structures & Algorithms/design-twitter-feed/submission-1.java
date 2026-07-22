class Twitter {

    int count;
    Map<Integer, List<int[]>> tweetMap;
    Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = 
            new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(Integer followeeId: followMap.get(userId)){
            if(tweetMap.containsKey(followeeId)){
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while(!maxHeap.isEmpty() && result.size() < 10){
            int[] value = maxHeap.poll();
            result.add(value[1]);
            int index = value[3];
            if(index > 0){
                int[] tweet = tweetMap.get(value[2]).get(index - 1);
                maxHeap.offer(new int[]{tweet[0], tweet[1], value[2], index - 1});
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (k,v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}
