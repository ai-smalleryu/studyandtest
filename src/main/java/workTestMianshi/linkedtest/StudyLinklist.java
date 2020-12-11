package workTestMianshi.linkedtest;
import java.util.LinkedList;
public class StudyLinklist<E> {
        LinkedList<E> stack = new LinkedList<>();
        public void addsta(E e){
            stack.add(e);
        }
        public E pop(){//取出元素
            return stack.remove(stack.size()-1);
        }
        public E peek(){
            return  stack.get(stack.size()-1);
        }
}

