class Solution {
    /**
     * @param {string[][]} tickets
     * @return {string[]}
     */
    findItinerary(tickets) {
        const adjMap = new Map();

        // 1. Build adjacency list sorting destinations alphabetically
        for (const [src, dst] of tickets) {
            if (!adjMap.has(src)) {
                adjMap.set(src, new PriorityQueue( (a, b) => a.localeCompare(b) ));
            }
            adjMap.get(src).enqueue(dst);
        }

        const res = [];

        // 2. Continuous Hierholzer Graph DFS Post-order traversal
        function rec(src) {
            const pq = adjMap.get(src);
            
            // While this airport still has valid outbound flights available
            while (pq && pq.size() > 0) {
                const nextDst = pq.dequeue(); // Pull out the next alphabetical airport
                rec(nextDst); // Recurse down
            }
            
            // Add to result only when we hit a terminal dead-end
            res.push(src);
        }

        // Start path traversal at JFK
        rec("JFK");

        // 3. Reverse the post-order collection to get the chronological itinerary path
        return res.reverse();
    }
}
