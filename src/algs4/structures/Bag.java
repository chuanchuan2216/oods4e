package algs4.structures;

import support.Stdlib.StdIn;
import support.Stdlib.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int n;

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n=0;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public int size(){
        return n;
    }

    public void add(Item item){
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item=item;
        first.next=oldFirst;
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item>{
        private Node<Item> current;

        public LinkedIterator(Node<Item> first){
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
