package queue;

import java.util.LinkedList;

/**
 * REMARK
 *  链表实现队列，通过linkedlist的get/set first/last实现队列的元素进出
 *
 * @author: mmb
 * @date: 19-11-10
 */
public class TestQueue<T> {

    private LinkedList<T> deque = new LinkedList<T>();

    public void addFirst(T e){
        deque.addFirst(e);
    }

    public void addLast(T e){
        deque.addLast(e);
    }

    public T getFirst(){
        return deque.getFirst();
    }

    public T getLast(){
        return deque.getLast();
    }

    public T removeFirst(){
        return deque.removeFirst();
    }

    public T removeLast(){
        return deque.removeLast();
    }

    public int size(){
        return deque.size();
    }

    @Override
    public String toString() {
        return "TestQueue{" +
                "deque=" + deque +
                '}';
    }

    public static void main(String[] args) {
        TestQueue<Integer> testQueue = new TestQueue<Integer>();
        fillTest(testQueue);
        System.out.println(testQueue);

        while (testQueue.size() != 0){
            System.out.print(testQueue.removeFirst() + " , ");
        }
        System.out.println();

        fillTest(testQueue);
        while (testQueue.size() != 0){
            System.out.print(testQueue.removeLast() + " , ");
        }
    }

    private static void fillTest(TestQueue<Integer> testQueue) {
        for (int i = 20; i < 27; i++){
            testQueue.addFirst(i);
        }

        for (int i = 50; i < 55; i++){
            testQueue.addLast(i);
        }
    }
}
