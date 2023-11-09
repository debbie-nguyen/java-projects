package edu.sdccd.cisc191;

public class SinglyLinkedList<T> {
    public class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }


    /**
     * recursively finds k-th node, deletes, and returns new head
     *
     * @param head the node to start at
     * @param k    the kth element to remove (first element at 0)
     * @return the new head node with the kth element removed
     */
    public Node remove(Node head, int k) {
        Node previous = head;
        for (int i = 1; i < k; i++) {
            previous = previous.next;
        }
        Node current = previous.next;
        previous.next = current.next;
        return head;
    }

    /**
     * inserts node at the beginning of the list
     *
     * @param head     the node to start at
     * @param new_data data to insert into the list
     * @return the new head node containing new_data followed with the rest of the linked list
     */
    public Node push(Node head, T new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    /**
     * recursively prints list starting from head
     *
     * @param head the node to start at
     * @return a space separated string containing the data of each node starting from the head to the tail, end with a trailing space
     */
    public String toString(Node head) {

        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
