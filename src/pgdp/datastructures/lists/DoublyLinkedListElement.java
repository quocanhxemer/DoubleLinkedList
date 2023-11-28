package pgdp.datastructures.lists;

public class DoublyLinkedListElement {
    private int info;
    public DoublyLinkedListElement next;
    public DoublyLinkedListElement prev;

    public DoublyLinkedListElement(int info) {
        this.info = info;
    }

    public DoublyLinkedListElement(int info, DoublyLinkedListElement next, DoublyLinkedListElement prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public int getInfo() {
        return info;
    }
}
