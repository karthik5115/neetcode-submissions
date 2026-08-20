public class Solution {
    private Set<String> wordSet;
    private Map<Integer, List<String>> cache;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        cache = new HashMap<>();
        return backtrack(s, 0);
    }

    private List<String> backtrack(String s, int i) {
        if (i == s.length())
            return Arrays.asList("");
        if (cache.containsKey(i))
            return cache.get(i);

        List<String> res = new ArrayList<>();
        for (int j = i; j < s.length(); j++) {
            String w = s.substring(i, j + 1);
            if (!wordSet.contains(w))
                continue;
            List<String> strings = backtrack(s, j + 1);
            for (String substr : strings) {
                String sentence = w;
                if (!substr.isEmpty())
                    sentence += " " + substr;
                res.add(sentence);
            }
        }
        cache.put(i, res);
        return res;
    }
}