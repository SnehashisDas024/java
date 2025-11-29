public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFirst(3);
        list.insertAtFirst(5);
        list.insertAtFirst(7);
        list.insertAtFirst(2);
        list.insertAtEnd(15);
        list.insertAtEnd(18);
        list.insert(45, 3);
        // list.display();
        // list.insert(25, 1);
        // list.display();
        list.insert(14, 8);
        list.display();
        // System.out.println((list.deleteFirst() == -9999 ? "Empty List. Nothing to delete." : "Deleted value: "+list.deleteFirst()));
        // System.out.println((list.deleteLast() == -9999 ? "Empty List. Nothing to delete." : "Deleted value: "+list.deleteLast()));
        // System.out.println("Deleted value: " + list.delete(3));
        // System.out.println("Deleted value: " + list.delete(6));

        list.recursiveInsert(47, 3, list.head);

        list.display();
    }
}
