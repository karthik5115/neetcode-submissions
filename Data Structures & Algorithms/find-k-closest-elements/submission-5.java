class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = k-1;
        for(int i=k;i<arr.length;i++){
            
            if( (high+1)< arr.length && Math.abs(arr[low]-x)>Math.abs(arr[high+1]-x)){
                low++;
                high++;
            }
            else if((high+1)< arr.length && arr[low]==arr[high+1]){
                low++;
                high++;
            }
            else{
                break;
            }
        }
        
        List<Integer> ar = new ArrayList<>();
        while(low<=high){
            ar.add(arr[low++]);
        }
        return ar;
        
    }
}