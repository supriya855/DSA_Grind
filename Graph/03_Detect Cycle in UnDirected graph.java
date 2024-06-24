1. BFS => Queue<Pair> in the pair it contains parent and child
2. so whenever there is a cycle parent != current adj node then we can there is a cycle
for(int itr : adj.get(node)){
  if(!vis){
    push to queue
  }
  else if 
check parent ! itr then return true => this means its alredy visited by someone
}
