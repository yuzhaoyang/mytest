package leetcode;

import java.util.List;

public class LinkedList {

    LinkedListNode first;

    LinkedListNode last;

    public void add(Object obj) {

        LinkedListNode n = new LinkedListNode(obj);
        if (first == null) {
            n.next = null;
            n.previous = null;

            first = n;
            last = n;

        } else {

            n.next = null;
            n.previous = last;

            last.next = n;
            last = n;

        }

    }


    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);



    }

}
