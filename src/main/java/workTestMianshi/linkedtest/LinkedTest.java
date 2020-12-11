package workTestMianshi.linkedtest;

import org.apache.ibatis.javassist.expr.NewArray;

import java.util.ArrayList;

public class LinkedTest<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public void linkedTest(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(e, f);
        first = newNode;
        if (f == null) {
            last = first;
        } else {

        }
        size++;
    }

    public void toStringList() {
        Node<E> f = first;
        while (f != null) {
            System.out.println(f.element);
            f = f.next;
        }
    }

    public boolean countainsT(E e) {
        if (size == 0) {
            return false;
        }
        for (Node<E> l = first; l != null; l = l.next) {
            if (e.equals(l.element))
                return true;
        }
        return false;
    }

    public E removeE(int index) {
        Node<E> it=first;
        if (index < 0 || index >= size|| it==null) {
            return null;
        }


        return it.element;
    }

    private int add(E e) {
        int index = 0;
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return index;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

   /*
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
    }*/

}
