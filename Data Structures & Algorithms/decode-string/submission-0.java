class Solution {
    public String decodeString(String s) {

        Stack<String> stk = new Stack<>();
        int i = 0;
        String res = "";

        while (i < s.length()) {

            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {

                String num = "";

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num += s.charAt(i);
                    i++;
                }

                stk.push(num);
            }

            
            else if (curr == '[') {
                stk.push("[");
                i++;
            }

            
            else if (Character.isLetter(curr)) {

                String alpha = "";

                while (i < s.length() && Character.isLetter(s.charAt(i))) {
                    alpha += s.charAt(i);
                    i++;
                }

                stk.push(alpha);
            }

            // ']'
            else {

                
                String alpha = "";
                while (!stk.peek().equals("[")) {
                    alpha = stk.pop() + alpha;
                }

                
                stk.pop();

                
                int times = Integer.parseInt(stk.pop());

                String decoded = "";

                for (int j = 0; j < times; j++) {
                    decoded += alpha;
                }

                
                stk.push(decoded);

                i++;
            }
        }

        // Build final result
        while (!stk.isEmpty()) {
            res = stk.pop() + res;
        }

        return res;
    }
}