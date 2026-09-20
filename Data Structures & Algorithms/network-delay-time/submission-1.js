class Solution {
    /**
     * @param {number[][]} times
     * @param {number} n
     * @param {number} k
     * @return {number}
     */
    networkDelayTime(times, n, k) {
    const map = new Map();

for (const [source, target, weight] of times) {
  map.set(source, map.get(source) ?? []);
  map.get(source).push([target, weight]);
}
const queue=[];
const dist= new Array(n + 1).fill(Infinity);
dist[k]=0;
queue.push(k);
while(queue.length>0){
    const node = queue.shift();
    for(const [adjnode,time] of map.get(node)??[]){
        if(dist[adjnode]>dist[node]+time){
        dist[adjnode]=dist[node]+time;
        queue.push(adjnode);
        }
    }
}
const ans = Math.max(...dist.slice(1));
 return ans==Infinity ?-1:ans;
    }
}
