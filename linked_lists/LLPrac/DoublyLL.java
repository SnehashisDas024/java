public class DoublyLL {

    Node head;
    Node tail;

    public void insertAtFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        // tail = head;
        if (tail == null)   tail = newNode;
        head = newNode;
    }

    public void insertAtLast(int val) {
        if(head == null) {
            insertAtFirst(val);
            return;
        }
        Node newNode = new Node(val);
        // Node tail = head;
        // tail = head;
        // while (tail.next != null) {
        //     tail = tail.next;
        // }
        // newNode.next = null;
        newNode.prev = tail;
        // if(tail != null) {
        //     tail.next = newNode;
        // }
        tail.next = newNode;
        tail = newNode;
    }

    public void display() {
        Node node = head;
        System.out.println("Normal Display: ");
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("END");

        // Node tail = head;
        // // tail = head;
        // while (tail.next != null) {
        //     tail = tail.next;
        // }

        System.out.println("Reverse Display: ");
        node = tail;
        while (node != null) { 
            System.out.print(node.value + " -> ");
            node = node.prev;
        }
        System.out.println("START");
    }

    public class Node {
        int value;
        Node next;
        Node prev;

        public Node() {}

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        
    }
}