class Solution {
    /**
     * @param {number[][]} points
     * @return {number}
     */
    minCostConnectPoints(points) {
        const n = points.length;
        if (n <= 1) return 0;

        // 1. Initialize the Min Priority Queue
        // In modern LeetCode (v6+), pass the extraction rule directly into the constructor
        const minPQ = new MinPriorityQueue((a) => a.cost);
        
        // Track which points have already been connected to our MST
        const visited = new Array(n).fill(false);
        
        let totalCost = 0;
        let edgesConnected = 0;

        // Start at point 0 with a connection cost of 0
        minPQ.enqueue({ node: 0, cost: 0 });

        while (!minPQ.isEmpty() && edgesConnected < n) {
            // Unpack using LeetCode's v6 format: .dequeue().element
            const { node, cost } = minPQ.dequeue();

            // If this node is already part of the MST, skip it
            if (visited[node]) continue;

            // Connect the point
            visited[node] = true;
            totalCost += cost;
            edgesConnected++;

            // Look at all remaining unvisited nodes and calculate Manhattan distance
            for (let nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    const dist = Math.abs(points[node][0] - points[nextNode][0]) + 
                                 Math.abs(points[node][1] - points[nextNode][1]);
                    
                    // Add this potential connection path to the priority queue
                    minPQ.enqueue({ node: nextNode, cost: dist });
                }
            }
        }

        return totalCost;
    }
}
