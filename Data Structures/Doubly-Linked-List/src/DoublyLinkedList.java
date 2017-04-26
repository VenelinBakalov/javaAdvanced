import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by Venelin on 25.4.2017 г..
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int count;

    public void addFirst(T element) {
        ListNode<T> newHead = new ListNode<>(element);
        if (this.count == 0) {
            this.head = this.tail = newHead;
        } else {
            newHead.setNextNode(this.head);
            this.head.setPrevNode(newHead);
            this.head = newHead;
        }
        this.count++;
//        return newHead;
    }

    public void addLast(T element) {
        ListNode<T> newTail = new ListNode<>(element);
        if (this.count == 0) {
            this.head = this.tail = newTail;
        } else {
            newTail.setPrevNode(this.tail);
            this.tail.setNextNode(newTail);
            this.tail = newTail;
        }
        this.count++;
//        return newTail;
    }

    public T removeFirst() {
        if (this.count == 0) {
            throw new IllegalStateException("List empty");
        }

        T firstElement = this.head.getValue();
        this.head = this.head.getNextNode();
        if (this.head != null) {
            this.head.setPrevNode(null);
        } else {
            this.tail = null;
        }

        this.count--;
        return firstElement;
    }

    public T removeLast() {
        if (this.count == 0) {
            throw new IllegalStateException("List empty");
        }

        T lastElement = this.tail.getValue();
        this.tail = this.tail.getPrevNode();
        if (this.tail != null) {
            this.tail.setNextNode(null);
        } else {
            this.head = null;
        }

        this.count--;
        return lastElement;
    }

    public void addBefore(T element, ListNode<T> nextNode) {
        ListNode<T> newNode = new ListNode<>(element);
        ListNode<T> prevNode = nextNode.getPrevNode();

        prevNode.setNextNode(newNode);
        newNode.setPrevNode(prevNode);

        newNode.setNextNode(nextNode);
        nextNode.setPrevNode(newNode);
    }

    public void addAfter(T element, ListNode<T> prevNode) {
        ListNode<T> newNode = new ListNode<>(element);
        ListNode<T> nextNode = prevNode.getNextNode();

        prevNode.setNextNode(newNode);
        newNode.setPrevNode(prevNode);

        newNode.setNextNode(nextNode);
        nextNode.setPrevNode(newNode);
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        if (this.count == 0) {
            throw new IllegalStateException("List empty");
        }
        Class<?> elementsClass = this.head.getValue().getClass();
        T[] elementsArray = (T[]) Array.newInstance(elementsClass, this.count);
        int index = 0;
        ListNode<T> currentNode = this.head;

        while (currentNode != null) {
            elementsArray[index++] = currentNode.getValue();
            currentNode = currentNode.getNextNode();
        }

        return elementsArray;
    }

    public boolean contains(T element) {
        for (T listElement : this) {
            if (listElement.equals(element)) return true;
        }

        return false;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        ListNode<T> currentNode = this.head;

        while (currentNode != null) {
            action.accept(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    private final class DoublyLinkedListIterator implements Iterator<T> {

        private ListNode<T> currentNode;

        private DoublyLinkedListIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode != null && this.currentNode.getNextNode() != null;

        }

        @Override
        public T next() {
            T element = this.currentNode.getValue();
            this.currentNode = this.currentNode.getNextNode();
            return element;
        }
    }

    private class ListNode<T> {

        private T value;
        private ListNode<T> nextNode;
        private ListNode<T> prevNode;

        public ListNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public ListNode<T> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(ListNode<T> nextNode) {
            this.nextNode = nextNode;
        }

        public ListNode<T> getPrevNode() {
            return this.prevNode;
        }

        public void setPrevNode(ListNode<T> prevNode) {
            this.prevNode = prevNode;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.forEach(System.out::println);
        System.out.println("--------------------");

        list.addLast(5);
        list.addFirst(3);
        list.addFirst(2);
        list.addLast(10);
        System.out.println("Count = " + list.count);
        System.out.println("--------------------");

        System.out.println("Contains 5: " + list.contains(5));
        System.out.println("--------------------");

        list.forEach(System.out::println);
        System.out.println("--------------------");

        Integer[] integers = list.toArray();
        System.out.println(integers[0]);

        System.out.println("--------------------");


        list.removeFirst();
        list.removeLast();
        list.removeFirst();

        list.forEach(System.out::println);
        System.out.println("--------------------");

        list.removeLast();

        System.out.println("Contains 5: " + list.contains(5));

        list.forEach(System.out::println);
        System.out.println("--------------------");
    }
}
