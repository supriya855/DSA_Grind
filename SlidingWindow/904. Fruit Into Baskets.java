class Solution {
    public int totalFruit(int[] fruits) {
       int i=0,j=0,max=0;
       HashMap<Integer,Integer> map = new HashMap<>();
       while(j<fruits.length){
           map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
           if(map.size()<2){
                max=Math.max(j-i+1,max);
               j++;
           }
           else if(map.size()==2) {
               max=Math.max(j-i+1,max);
               j++;
           }
           else if(map.size()>2){
               
               while(map.size()>2){
                   map.put(fruits[i],map.get(fruits[i])-1);
                   if(map.get(fruits[i])==0) map.remove(fruits[i]);
                   i++;
               }
                j++;
           }

       }
       return max;
    }
}

// // 2 basktes each basket can hold only single type of fruit
// // [1-2]
// // [2-1]
// class Solution {
//     public int totalFruit(int[] fruits) {
//        int i = 0, j = 0, max = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        while (j < fruits.length) {
//            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
//            if (map.size() <= 2) {
//                max = Math.max(j - i + 1, max);
//                j++;
//            } else {
//                while (map.size() > 2) {
//                    map.put(fruits[i], map.get(fruits[i]) - 1);
//                    if (map.get(fruits[i]) == 0) map.remove(fruits[i]);
//                    i++;
//                }
//                j++;
//            }
//        }
//        return max;
//     }
// }
