package testOrm;

import javax.naming.spi.ObjectFactoryBuilder;

/*
底层链表
增删效率高查询效率低 定义节点对象
 */
public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    //添加方法
    public void add(Object o) {
        Node node = new Node(o);
        if (first == null) {
            first = node;
            last = node;

        } else {
            node.prive = last;
            node.next = null;
            last.next = node;
            last = node;
        }
        size++;
    }

    //删除
    public void remove(int index) {
        Node temp = getNode(index);
        Node up = temp.prive;//他的上一个节点
        Node down = temp.next;//他的下一个节点
        up.next = down;
        down.prive = up;

        if (index == 0) {
            first = down;
        }
        if (index == size - 1) {
            down = up;
        }
        size--;
    }

    public Node getNode(int index) {
        Node temp = null;
        if (index <= (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > (size >> 1); i--) {
                temp = temp.prive;
            }
        }
        return temp;
    }

    //增加插入节点
    public void add(int index, Object o) {
        Node node = new Node(o);
        Node temp = getNode(index);
        if (temp != null) {

        }
    }

    //get方法
    public Object get(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引不合法");
        }
        Node temp = getNode(index);

        return temp.element;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("[");

        //遍历链表中的数据信息
        Node temp = first;
        while (temp != null) {
            stringBuilder.append(temp.element + ",");
            temp = temp.next;
        }

        //stringBuilder.append("]");
        stringBuilder.setCharAt(stringBuilder.length() - 1, ']');
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("a2");
        linkedList.add("a3");
        linkedList.add("a4");
        linkedList.add("a5");
        linkedList.add("a6");
        linkedList.remove(1);
        System.out.println(linkedList);
        Object o = linkedList.get(2);
        Object o1 = linkedList.get(4);
        System.out.println(o + "asa" + o1);
    }

}
