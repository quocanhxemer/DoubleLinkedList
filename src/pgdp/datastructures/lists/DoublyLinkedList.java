package pgdp.datastructures.lists;

public class DoublyLinkedList {
    private DoublyLinkedListElement head;
    private DoublyLinkedListElement tail;
    private int size;

    public void append(int value) {
        if (head == null) {
            head = tail = new DoublyLinkedListElement(value, null, null);
        } else {
            tail = (tail.next = new DoublyLinkedListElement(value, null, tail));
        }
        size++;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return Integer.MIN_VALUE;
        }

        DoublyLinkedListElement currentElement = head;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        return currentElement.getInfo();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        DoublyLinkedListElement currentElement = head;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }

        if (size == 1) {
            head = tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            currentElement.prev.next = currentElement.next;
            currentElement.next.prev = currentElement.prev;
        }

        size--;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        DoublyLinkedListElement currentElement = head;
        while (currentElement != null) {
            str.append(currentElement.getInfo());
            currentElement = currentElement.next;
            if (currentElement != null) {
                str.append(",");
            }
        }

        return str.toString();
    }

    public void appendList(DoublyLinkedList nList) {
        if (size == 0) {
            head = nList.head;
            tail = nList.tail;
        } else if (nList.size() != 0) {
            tail.next = nList.head;
            nList.head.prev = tail;
            tail = nList.tail;
        }
        size += nList.size();
    }

    public boolean isEqual(DoublyLinkedList nList) {
        if (nList == null) {
            return false;
        }

        DoublyLinkedListElement element = head;
        DoublyLinkedListElement other = nList.head;

        while (element == other) {
            if (element == null) {
                return true;
            }
            element = element.next;
            other = other.next;
        }

        return false;
    }

    public int sum() {
        DoublyLinkedListElement currentElement = head;
        int sum = 0;
        while (currentElement != null) {
            sum += currentElement.getInfo();
            currentElement = currentElement.next;
        }

        return sum;
    }

    public DoublyLinkedList copy() {
        if (size == 0) {
            return new DoublyLinkedList();
        }

        DoublyLinkedList nList = new DoublyLinkedList();

        nList.tail = nList.head = new DoublyLinkedListElement(head.getInfo(), null, null);
        size++;
        DoublyLinkedListElement currentElement = head;
        while (currentElement != null) {
            nList.append(currentElement.getInfo());
            currentElement = currentElement.next;
        }

        return nList;
    }
}
