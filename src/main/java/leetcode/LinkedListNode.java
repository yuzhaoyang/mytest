package leetcode;

public class LinkedListNode {

    Object obj;
    LinkedListNode previous;
    LinkedListNode next;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public LinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode previous) {
        this.previous = previous;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public LinkedListNode(Object obj){
        this.obj=obj;
    }

}
