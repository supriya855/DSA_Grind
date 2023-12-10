//Do it again
class Solution {
    public Node connect(Node root) {
        Node prev=null;
        Node head=null;
        Node curr=root;
        while(curr!=null){//Whole Tree
            while(curr!=null){// Every Level
                if(curr.left!=null)
                {
                    if(prev!=null)
                    {
                        prev.next=curr.left;
                    }
                    else{
                        head=curr.left;
                    }
                    prev=curr.left;
                }
                 if(curr.right!=null)
                {
                    if(prev!=null)
                    {
                        prev.next=curr.right;
                    }
                    else{
                        head=curr.right;
                    }
                    prev=curr.right;
                }
                curr=curr.next;
            }
            //after completion level setting fresh 
            curr=head;//pointing to next level starting
            head=null;
            prev=null;

        }
        return root;
    }
}
