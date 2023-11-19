 class TriplePair{
     TreeNode node;
     int ver;
     int lev;
     public TriplePair(TreeNode _node,int _ver, int _lev){
         node=_node;
         ver=_ver;
         lev=_lev;
     }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<TriplePair> q = new LinkedList<TriplePair>();
        q.add(new TriplePair(root,0,0));
        while(!q.isEmpty()){
            TriplePair pair = q.remove();
            TreeNode node = pair.node;
            int x= pair.ver;
            int y= pair.lev;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left!=null){
                q.add(new TriplePair(node.left,x-1,y+1));
            }
             if(node.right!=null){
                q.add(new TriplePair(node.right,x+1,y+1));
            }
        }
        // System.out.println(map);
            List<List<Integer>> list = new ArrayList<>();
            for(TreeMap<Integer,PriorityQueue<Integer>> val :map.values()){
                //System.out.println(map.values());
                List<Integer> l = new ArrayList<>();
                for(PriorityQueue<Integer> nodes:val.values()){
                    while(!nodes.isEmpty()){
                        l.add(nodes.remove());
                    }
                }
                list.add(l);
            }

         return list;      
        
    }
}
