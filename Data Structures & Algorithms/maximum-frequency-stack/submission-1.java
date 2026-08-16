class FreqStack {

    // val -> frequency
    HashMap<Integer, Integer> freq;

    // frequency -> stack of values
    HashMap<Integer, Stack<Integer>> group;

    // Maximum frequency currently present
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {

        // Increase frequency
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        // Update maximum frequency
        maxFreq = Math.max(maxFreq, f);

        // Get stack for this frequency
        group.putIfAbsent(f, new Stack<>());

        // Push value into its frequency stack
        group.get(f).push(val);
    }

    public int pop() {

        // Get the stack containing values with max frequency
        Stack<Integer> stk = group.get(maxFreq);

        // Most recently pushed value with max frequency
        int val = stk.pop();

        // Decrease its frequency
        freq.put(val, freq.get(val) - 1);

        // If no values remain at this frequency
        if (stk.isEmpty()) {
            group.remove(maxFreq);
            maxFreq--;
        }

        return val;
    }
}