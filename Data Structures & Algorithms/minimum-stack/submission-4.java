class MinStack {
    Stack<Long> stk;
    long min_value;

    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int val) {
        if (stk.isEmpty()) {
            stk.push((long) val);
            min_value = val;
        } else if (val < min_value) {
            stk.push(2L * val - min_value); // encode
            min_value = val;
        } else {
            stk.push((long) val);
        }
    }

    public void pop() {
        long x = stk.pop();
        if (x < min_value) {
            min_value = 2 * min_value - x; // restore old min
        }
    }

    public int top() {
        long x = stk.peek();
        if (x < min_value) {
            return (int) min_value;
        }
        return (int) x;
    }

    public int getMin() {
        return (int) min_value;
    }
}
