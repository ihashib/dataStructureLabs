public class LinkedList{
    public Node head;


    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public LinkedList(Object [] a){
        for(int i=a.length-1;i>=0;i--) head=new Node(a[i],head);
    }

    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public LinkedList(Node h){
        head=h;
    }

    /* Counts the number of Nodes in the list */
    public int countNode(){
        int count=0;
        for(Node h=head;h!=null;h=h.next) count++;
        return count;
    }

    /* prints the elements in the list */
    public void printList(){
        for(Node h=head;h!=null;h=h.next) System.out.print(h.element+" ");
        System.out.println();
    }

    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        int count=-1, t=0;
        Node h=head;
        for(;h!=null;h=h.next) {
            count++;
            if (count == idx){
                t=1;
                break;
            }
        }
        if(t==1) return h;
        else return null;
    }


    // returns the element of the Node at the given index. For invalid idx return null.
    public Object get(int idx){
        int count=-1, t=0;
        Node h=head;
        for(;h!=null;h=h.next)  {
            count++;
            if (count == idx){
                t=1;
                break;
            }
        }
        if(t==1) return h.element;
        else return null;
    }



    /* updates the element of the Node at the given index.
     * Returns the old element that was replaced. For invalid index return null.
     * parameter: index, new element
     */
    public Object set(int idx, Object elem){
        int count=0, t=0;
        Node h=head;
        for(;h!=null;h=h.next) {
            count++;
            if (count == idx){
                t=1;
                break;
            }
        }
        if(t==1) {
            Object oldElem = h.element;
            h.element = elem;
            return oldElem;
        }
        else return null;
    }


    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        int count=0;
        for(Node h=head;h.element!=elem;h=h.next) count++;
        if(count==0) return -1;
        else return count;
    }

    // returns true if the element exists in the List, return false otherwise.
    public boolean contains(Object elem){
        int t=0;
        for(Node h=head;h!=null;h=h.next){
            if(h.element==elem){
                t=1;
                break;
            }
        }
        if(t==0) return false;
        else return true;
    }

    // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    public Node copyList(){
        Node h=head;
        Node h1=head;
        for(;h!=null;h=h.next) h.element=h1.element;
        return h;
    }

    // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
    public Node reverseList(){
        Node h=head;
        Node next;
        Node prev=null;
        while(h!=null){
            next=h.next;
            h.next=prev;
            prev=h;
            h=next;
        }
        return prev;
    }

    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx) {
        Node insert=new Node(elem,null);
        int count=0;
        Node h1=head;
        for(;h1!=null;h1=h1.next)  {
            count++;
        }
        if(idx>=0 && idx<=count){
            if(idx==0){
                insert.next=head;
                head=insert;
            }
            else if(idx==count){
                Node h=head;
                while(h.next!=null) h=h.next;
                h.next=insert;
            }
            else{
                Node h=head;
                for(int i=0;i<idx-1;i++){
                    h=h.next;
                }
                insert.next=h.next;
                h.next=insert;
            }
        }
    }


    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        int count=0;
        Object elem=null;
        Node h1=head;
        for(;h1!=null;h1=h1.next)  {
            count++;
        }
        if(index>=0 && index<=count) {
            if (index==0) {
                Node del=head;
                head=head.next;
                elem=del.element;
                del.next=null;
                del=null;
                count--;
            } else if (index==count) {
                Node h=head;
                while (h.next!=null) h=h.next;
                elem=h.element;
                h.next=null;
                h=null;
                count--;
            }
            else {
                Node h=head;
                for (int i=0;i<index-1;i++) {
                    h=h.next;
                }
                Node del=h.next;
                h.next=del.next;
                del.next=null;
                elem=del.element;
                del=null;
                count--;
            }
        }
        return elem;
    }

    // Rotates the list to the left by 1 position.
    public void rotateLeft(){
        Node old=head;
        head=head.next;
        Node h=head;
        while(h.next!=null) h=h.next;
        h.next=old;
        old.next=null;
    }

    // Rotates the list to the right by 1 position.
    public void rotateRight(){
        Node l=head;
        int count=0;
        for(Node h=head;h!=null;h=h.next) count++;
        for(int i=1; i<count-1;i++) l=l.next;
        Node t=l.next;
        t.next=head;
        head=t;
        l.next=null;
    }

}