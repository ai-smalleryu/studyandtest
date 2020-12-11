package testOrm;

public class Node {
    Node prive;//上一个节点
    Node next;//下一个节点
    Object element;//数据信息

    public Node(Node prive, Node next, Object element) {
        this.prive = prive;
        this.next = next;
        this.element = element;
    }
    public Node(Object element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Node{" +
                "prive=" + prive +
                ", next=" + next +
                ", element=" + element +
                '}';
    }

    public Node getPrive() {
        return prive;
    }

    public void setPrive(Node prive) {
        this.prive = prive;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node() {
    }
}
