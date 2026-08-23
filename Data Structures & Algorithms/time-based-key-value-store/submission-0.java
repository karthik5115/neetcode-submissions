class TimeMap {
    HashMap<String,Map<Integer,String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Map<Integer,String> innerMap = map.getOrDefault(key,new TreeMap<>());
        innerMap.put(timestamp,value);
        map.put(key,innerMap);
    }
    
    public String get(String key, int timestamp) {
        Map<Integer,String> innerMap = map.getOrDefault(key,new TreeMap<>());
        List<Integer> timestamps = new ArrayList<>(innerMap.keySet());
        int low = 0,high = timestamps.size()-1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(timestamps.get(mid)==timestamp){
                return map.get(key).get(timestamps.get(mid));
            }
            else if(timestamps.get(mid)<timestamp){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high<0?"":map.get(key).get(timestamps.get(high));

        
    }
}
