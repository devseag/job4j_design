package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {

    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        ForwardLinked.Node<T> temp = head;
        if (temp == null) {
            head = new ForwardLinked.Node<>(value, null);
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ForwardLinked.Node<>(value, null);
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        ForwardLinked.Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
//            T temp = head.item;
//            Node<T> p = head.next;
//            head.item = null;
//            head.next = null;
//            head = p;
//            T temp = head.item;
//            head.item = null;
//            head = head.next;
            Node<T> newNode = head;
            head = head.next;
            newNode.next = null;

            modCount--;
            size--;
            return newNode.item;
        }
    }


    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            final int expectedModCount = modCount;
            ForwardLinked.Node<T> node = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Concurrent Modification");
                }
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No Such Element");
                }
                T next = node.item;
                node = node.next;
                return next;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private ForwardLinked.Node<T> next;

        Node(T element, ForwardLinked.Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}