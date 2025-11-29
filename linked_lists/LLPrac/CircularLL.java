public class CircularLL {

    Node head;
    Node tail;

    public void insertFirst(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != head);
        }
        
        System.out.println("HEAD");
    }

    public class Node {
        int value;
        Node next;

        public Node() {}

        public Node(int val) {
            this.value = val;
        }

        public Node(int val, Node nextNode) {
            this.value = val;
            this.next = nextNode;
        }
    }
}
