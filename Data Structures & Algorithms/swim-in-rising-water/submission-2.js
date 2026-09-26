class Solution {
    /**
     * @param {number[][]} grid
     * @return {number}
     */
    swimInWater(grid) {
    const minpq = new MinPriorityQueue((a)=>a.val);
    let visited=Array.from({length:grid.length}, ()=>Array(grid.length).fill(0));
    minpq.enqueue({r:0,c:0,val:grid[0][0]});
    let maxx = 0;
    while(minpq.size()!==0){

        const {r,c,val} = minpq.dequeue();
        maxx = Math.max(maxx,val);
        if(r===grid.length-1 && c===grid.length-1){
            break;
        }
       
        let x = [1,-1];
        for(let i of x){
           if(r+i<grid.length && r+i>=0 && visited[r+i][c]===0){
                visited[r+i][c]=1;
                minpq.enqueue({r:r+i,c:c,val:grid[r+i][c]});
           }
           if(c+i<grid.length && c+i>=0 && visited[r][c+i]===0){
                visited[r][c+i]=1;
                minpq.enqueue({r:r,c:c+i,val:grid[r][c+i]});
           }
        }

    }
    return maxx;
}
}
