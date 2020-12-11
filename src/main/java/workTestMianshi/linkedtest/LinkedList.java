package workTestMianshi.linkedtest;

public class LinkedList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public void print() {
        Node<E> f = first;
        while (f != null) {
            System.out.println(f.item);
            f = f.next;
        }
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        size++;
    }

    //这两个方法的第一句都是为了保存好现有的first和last，这两个变量绝不能丢失
    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }


    private static class Node<E> {
        E item;
        Node<E> next; //自引用结构

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
