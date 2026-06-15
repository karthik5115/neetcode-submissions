class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            arr.add(node);
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if (arr.size() == numCourses){
            int[] arr1 = new int[arr.size()];
            for (int i = arr.size()-1;i>=0; i--) {
                arr1[i] = arr.get(i);
                }
                return arr1;
        }
        return new int[0];
    }
}
