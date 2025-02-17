// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
   
    public static void main(String[] args){
        Queue q = new Queue();
         q.add(1);
         q.add(2);
         q.add(3);
         q.add(4);
        // q.remove();
         int size = q.size();
        for(int i=0;i<size;i++){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
class Queue {
     Node front = null;
     Node rear = null;
    int size = 0;
    public void add(int val){
       System.out.println("is it going"+val);
        if(size ==0){
             rear = new Node(val);
            front = rear;
        }else{
            rear.next = new Node(val);
            rear = rear.next;
        }
        size++;
    }
    public void remove(){
        if(front == null) return;
        front = front.next;
        size--;
    }
    public int peek(){
        return front.data;
    }
    public int size(){
       // System.out.println(rear);
        return size;
    }
}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
    public Node(int data, Node next){
        this.data = data;
        this.next  = next;
    }
}

   
