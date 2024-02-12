INSERT INETRVAL
class Solution{
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int s=newInterval[0],e=newInterval[1],i=0;
        while(i<intervals.length&&intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
          while(i<intervals.length&&intervals[i][0]<=newInterval[1]){
           s=Math.min(intervals[i][0],s);
           e=Math.max(intervals[i][1],e);
           i++;
        }
        res.add(new int[]{s,e});
        while(i<intervals.length){
            res.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        return res.toArray(new int[res.size()][2]);

    }
}
************************************************************************************

MERGE NTERVAL


class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();
        int[] newInterval=intervals[0];
        res.add(newInterval);
        for(int[] interval : intervals){
            if(interval[0]<=newInterval[1]){//compare prev 1st index to the next interval index
                newInterval[1] =Math.max(interval[1],newInterval[1]);
            

            }
            else{
                newInterval=interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
