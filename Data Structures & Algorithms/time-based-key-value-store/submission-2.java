class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> list = map.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = list.size() - 1;
        String result = "";
        while(l <= r){
            int m = l + (r-l)/2;
            Pair<String, Integer> pair = list.get(m);
            if(pair.getTimestamp() <= timestamp){
                result = pair.getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return result;
    }
}

class Pair<K,V>{
    K value;
    V timestamp;
    public Pair(K value, V timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
    public K getValue(){
        return this.value;
    }
    public V getTimestamp(){
        return this.timestamp;
    }
}
