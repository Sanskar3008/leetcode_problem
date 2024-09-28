class MyCircularDeque {
    int size;
    int capa;
    Node head;
    Node tail;
    

    public MyCircularDeque(int k) {
        this.size=k;
        this.head=null;
        this.tail=null;
    }
    
    public boolean insertFront(int value) {
        if(!isFull()){
            Node temp=new Node(value);
            if(capa==0)
            head=tail=temp;
            else{
            temp.next=head;
            head=temp;
            }
            capa++;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if(!isFull()){
            Node temp=new Node(value);
            if(head==null)tail=head=temp;
            else{
            tail.next=temp;
            tail=temp;
            tail.next=null;
            }
            capa++;
            
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(!isEmpty()){
            head=head.next;
            capa--;
            return true;
         }
        return false;
    }
    
    public boolean deleteLast() {
        if(!isEmpty()){
            Node curr=head;
            for(int i=0;i<capa-2;i++){
                curr=curr.next;
            }
            curr.next=null;
            tail=curr;
            capa--;
            if(capa==0)
            head=tail=null;
            return true;
        }
        return false;
        
    }
    
    public int getFront() {
        if(!isEmpty())
        return head.data;
        return -1;
    }
    
    public int getRear() {
        if(!isEmpty())
        return tail.data;
        return -1;
    }
    
    public boolean isEmpty() {
        return capa==0;
    }
    
    public boolean isFull() {
        return capa==size;
    }
}
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;

    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */