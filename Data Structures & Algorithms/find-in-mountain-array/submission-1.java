/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findPeek(MountainArray arr){
        int low = 1, high = arr.length()-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            int x = arr.get(mid);
            if(x<arr.get(mid-1)){
                high=mid-1;
            }
            else if(x<arr.get(mid+1)){
                low=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peek = findPeek(mountainArr);
        int low = 0,high = peek;
        while(low<=high){
            int mid = low + (high-low)/2;
            int x = mountainArr.get(mid);
            if(x==target){
                return mid;
            }
            else if(x>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        low = peek+1;
        high = mountainArr.length()-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int x = mountainArr.get(mid);
            if(x==target){
                return mid;
            }
            else if(x>target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;

    }
}