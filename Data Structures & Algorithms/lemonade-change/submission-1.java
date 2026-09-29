class Solution {
    public boolean lemonadeChange(int[] bills) {
        //Arrays.sort(bills);
        HashMap<Integer,Integer> change = new HashMap<>();
        change.put(5,0);
         change.put(10,0);
          change.put(20,0);
          for(int bill:bills){
            if(bill==5){
                change.put(5,change.get(5)+1);
            }
            else if(bill==10){
                if(change.get(5)>0){
                    change.put(5,change.get(5)-1);
                    change.put(10,change.get(10)+1);
                }
                else{
                    return false;
                }
            }
            else{
                if(change.get(5)>0){
                        if(change.get(10)>0){
                            change.put(5,change.get(5)-1);
                            change.put(10,change.get(10)-1);
                            change.put(20,change.get(20)+1);
                        }
                        else if(change.get(5)>=3){
                            change.put(5,change.get(5)-3);
                            change.put(20,change.get(20)+1);
                        }
                        else{
                            return false;
                        }
                }
                else{
                    return false;
                }
            }
          }
          return true;
        
    }
}