class Solution { 
    HashMap<Character,Integer> map ;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(order.charAt(i),i);
        }

    Comparator<String> compare = (w1,w2)->{
        for(int i=0;i<Math.min(w1.length(),w2.length());i++){
            if(map.get(w1.charAt(i)) != map.get(w2.charAt(i))){
                return map.get(w1.charAt(i))-map.get(w2.charAt(i));
            }
        }
        return w1.length()-w2.length();
    };

    String[] swords = words.clone();

    Arrays.sort(swords, compare);
    return Arrays.equals(words, swords);
        
    }
}