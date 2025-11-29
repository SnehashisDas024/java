public class SinglyLinkedList {

    public Node head;
    public Node tail;

    private int size;

    public SinglyLinkedList(){
        this.size = 0;
    }

    public void  insertAtFirst(int val){
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;

        if (tail == null){
            tail = head;
        }

        size += 1;
    }

    public void insertAtEnd(int val){
        if (tail == null){
            insertAtFirst(val);
            return;
        }
        Node newnode = new Node(val, null);
        // newnode.next = null;
        tail.next = newnode;
        tail = newnode;
        size += 1;
    }

    public void insert(int val, int position) {
        if (position == 1) {
            insertAtFirst(val);
            return;
        }
        if (position == size) {
            insertAtEnd(val);
            return;
        }
        Node temp = head;
        int posc = 1;
        while (posc != position - 1){
            temp = temp.next;
            posc++;
        }
        Node newnode = new Node(val);
        newnode.next = temp.next;
        temp.next = newnode;
        size += 1;
    }

    public void recursiveInsert(int val, int position, Node temp) {
        if (position - 1 == 1) {
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            return;
        }
        recursiveInsert(val, position - 1, temp.next);
    }

    public int deleteFirst() {
        if (head == null)
            return -9999;
        int val = head.value;
        head = head.next;

        if (head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if (tail == null)
            return -9999;
        int val = tail.value;
        Node temp = head;
        for (int i = 1; i < size - 1; i++) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
        return val;
    }

    public int delete(int position) {
        if (position == 1) {
            return deleteFirst();
        }
        if (position == size - 1) {
            return deleteLast();
        }

        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        int val = (temp.next).value;
        temp.next = (temp.next).next;
        size--;
        return val;
    }

    // public int delete(int position) {
    //     if (position < 1 || position > size) {
    //         throw new IndexOutOfBoundsException("Position out of range: " + position);
    //     }

    //     if (position == 1) {
    //         return deleteFirst();
    //     }

    //     if (position == size) {
    //         return deleteLast();
    //     }

    //     // walk to node BEFORE the one to delete
    //     Node prev = head;
    //     for (int i = 1; i < position - 1; i++) {
    //         prev = prev.next;
    //     }

    //     // actually remove it from the list
    //     int val = prev.next.value;
    //     prev.next = prev.next.next; // <-- this updates the list link
    //     size--;

    //     // if you removed the second-last element, tail might change
    //     if (prev.next == null) {
    //         tail = prev;
    //     }

    //     return val;
    // }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    
    private class Node{
        private int value;
        private Node next;

        public Node(int val){
            this.value = val;
        }

        public Node(int val, Node nextNode){
            this.value = val;
            this.next = nextNode;
        }
    }
}


/**
 * Alright, here’s a **ruthless review** of your `LL1` implementation. I’ll go
 * section by section, rating quality (1–10), and pointing out **every flaw** in
 * correctness, design, readability, and maintainability.
 * 
 * ---
 * 
 * ### **Class: `LL1`**
 * 
 * **Rating: 5/10**
 * Problems:
 * 
 * The class name is meaningless (`LL1`). It should be descriptive
 * (`SinglyLinkedList`).
 * Package naming (`linked_lists.LLPrac`) is non-standard. Java package names
 * should be lowercase and typically singular (`linkedlist` or
 * `linkedlist.practice`).
 * No `toString()` override. Instead, a custom `display()` with printing side
 * effects is used — poor design for reusable code.
 * No unit tests or validation. This will silently fail in multiple cases (see
 * below).
 * 
 * ---
 * 
 * ### **Fields**
 * 
 * ```java
 * private Node head;
 * private Node tail;
 * private int size;
 * ```
 * 
 * **Rating: 8/10**
 * Pretty standard, but:
 * 
 * `size` should always be consistent with operations — some methods don’t
 * handle it correctly.
 * Fields are package-private accessible inside the inner class, which is fine,
 * but clarity could be improved with explicit getters for `head`, `tail`, and
 * `size`.
 * 
 * ---
 * 
 * ### **Constructor**
 * 
 * ```java
 * public LL1() {
 * this.size = 0;
 * }
 * ```
 * 
 * **Rating: 9/10**
 * Simple, correct. No issues.
 * Redundant initialization: `size` is already `0` by default in Java.
 * 
 * ---
 * 
 * ### **Insert Methods**
 * 
 * #### `insertAtFirst(int val)`
 * 
 * **Rating: 8/10**
 * Correct for head/tail initialization.
 * Problem: Naming convention should be `insertFirst`.
 * No null-check issues here.
 * 
 * #### `insertAtEnd(int val)`
 * 
 * **Rating: 7/10**
 * Works, but:
 * 
 * Redundant `newnode.next = null;` commented out — shows confusion. It’s always
 * `null` by constructor.
 * Relies on `insertAtFirst()` when empty, but then increments size again —
 * potential bug avoided only because `insertAtFirst` handles size correctly.
 * Still messy.
 * 
 * #### `insert(int val, int position)`
 * 
 * **Rating: 4/10**
 * Major flaws:
 * 
 * Uses **1-based indexing** for `position` — not Java convention. Should be
 * 0-based like arrays.
 * Boundary check missing. Out-of-bounds positions will throw
 * `NullPointerException` silently instead of a clear error.
 * The condition:
 * 
 * ```java
 * if (position == size) {
 * insertAtEnd(val);
 * return;
 * }
 * ```
 * 
 * is wrong — inserting at `size` means appending, but your logic effectively
 * skips the real last index (should be `size + 1` if using 1-based).
 * Code duplication: Could unify with `insertAtFirst` and `insertAtEnd`.
 * 
 * ---
 * 
 * ### **Delete Methods**
 * 
 * #### `deleteFirst()`
 * 
 * **Rating: 7/10**
 * Works but:
 * 
 * Returning `-9999` is **terrible error handling**. This sentinel will collide
 * with legitimate data. Should throw `NoSuchElementException`.
 * `size--` is correct.
 * Properly resets `tail = null` when last node is removed (good).
 * 
 * #### `deleteLast()`
 * 
 * **Rating: 3/10**
 * Flaws:
 * 
 * Doesn’t handle `size == 1` case. It will leave `head` non-null and `tail`
 * incorrect.
 * Does **not update `tail`** after deletion. After removing the last element,
 * `tail` points to a deleted node.
 * O(n) traversal to find penultimate node — expected in singly-linked, but you
 * should handle size-1 case separately.
 * Sentinel return (`-9999`) again.
 * 
 * #### `delete(int position)`
 * 
 * **Rating: 2/10**
 * Completely broken:
 * 
 * `if (position == size - 1) return deleteLast();`
 * 
 * Wrong: Should be `position == size`, since you’re using 1-based indexing.
 * Same silent `NullPointerException` risks due to no bounds checks.
 * Doesn’t update `tail` if deleting the last element.
 * Redundant with the commented-out version, which was **much better**.
 * 
 * ---
 * 
 * ### **Commented-Out Delete Implementation**
 * 
 * **Rating: 9/10**
 * Far superior. Handles:
 * 
 * Index bounds properly.
 * Updates tail correctly.
 * Uses meaningful exception instead of sentinel.
 * Should replace the active one.
 * 
 * ---
 * 
 * ### **Display**
 * 
 * ```java
 * public void display() {
 * Node temp = head;
 * while(temp != null){
 * System.out.print(temp.value + "->");
 * temp = temp.next;
 * }
 * System.out.println("END");
 * }
 * ```
 * 
 * **Rating: 6/10**
 * Usable but:
 * 
 * Hardcoded console output. Should use `toString()` and return a string instead
 * of printing.
 * “END” marker is arbitrary — maybe fine for debugging, but not professional.
 * 
 * ---
 * 
 * ### **Inner Class: Node**
 * 
 * **Rating: 7/10**
 * Decent, but:
 * 
 * Should be `static class Node` since it doesn’t need to reference outer class.
 * `value` and `next` don’t need to be `private` unless you add getters/setters.
 * Current encapsulation is inconsistent.
 * 
 * ---
 * 
 * ### **Overall Issues**
 * 
 * Indexing is inconsistent and confusing (1-based instead of 0-based).
 * Deletion methods are **buggy** and inconsistent with size/tail maintenance.
 * Error handling is poor (magic numbers instead of exceptions).
 * Naming conventions don’t follow Java standards.
 * Code duplication (insert/delete cases).
 * No `toString()` override.
 * No defensive programming (null checks, bounds checks).
 * Testing/debugging appears ad-hoc.
 * 
 * ---
 * 
 * ### **Final Overall Rating: 4/10**
 * 
 * This implementation works only for simple happy-path cases but breaks under
 * edge conditions. It’s not production-quality, not even interview-quality yet.
 * 
 * ---
 * 
 * ### **Actionable Improvements**
 * 
 * 1. Rename class → `SinglyLinkedList`.
 * 2. Fix **insert/delete** to use 0-based indices and proper bounds checking.
 * 3. Replace sentinel `-9999` with exceptions.
 * 4. Fix `deleteLast()` to correctly handle size=1 and update `tail`.
 * 5. Always update `tail` when necessary in deletions.
 * 6. Replace `display()` with a proper `toString()`.
 * 7. Make `Node` a `static` inner class.
 * 8. Write JUnit tests for: empty insert/delete, middle insert/delete,
 * single-element edge cases, large list.
 * 
 * ---
 * 
 * Want me to **rewrite this into a clean, production-quality `SinglyLinkedList`
 * implementation** with fixes applied, or do you prefer me to mark changes
 * directly into your existing code?
 * 
 */