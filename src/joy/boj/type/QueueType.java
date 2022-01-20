package joy.boj.type;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueType {
    public void type() {
        Queue<Integer> que1 = new LinkedList<>();
        Deque<Integer> que2 = new LinkedList<>();
        PriorityQueue<Integer> que3 = new PriorityQueue<>();

        que2.add(3);
        que2.add(5);
        que2.add(0);
        que2.add(7);
        que2.add(10);
        que2.add(2);
        que2.add(-1);
        que2.add(8);
        que2.add(6);
        que2.add(9);
        System.out.println("default : " + que2);

        System.out.println("pop front : " + que2.pop());         // 삭제 o, exception
        System.out.println("pop front : " + que2.remove());      // 삭제 o, exception
        System.out.println("pop front : " + que2.removeFirst()); // 삭제 o, exception
        System.out.println("pop front : " + que2.getFirst());    // 삭제 x, exception

        System.out.println("pop front : " + que2.poll());        // 삭제 o, null
        System.out.println("pop front : " + que2.pollFirst());   // 삭제 o, null
        System.out.println("pop front : " + que2.peek());        // 삭제 x, null
        System.out.println("pop front : " + que2.peekFirst());   // 삭제 x, null

        System.out.println("pop back  : " + que2.removeLast()); // 삭제 o, exception
        System.out.println("pop back  : " + que2.getLast());    // 삭제 x, exception

        System.out.println("pop back  : " + que2.pollLast());   // 삭제 o, null
        System.out.println("pop back  : " + que2.peekLast());   // 삭제 x, null

        que2.push(17);       //
        que2.addFirst(12);   // 용량제한 exception
        que2.offerFirst(15); // 성공 true, 용량제한 false

        que2.add(11);           // 용량제한 exception
        que2.addLast(13);   // 용량제한 exception
        que2.offer(14);     // 성공 true, 용량제한 false
        que2.offerLast(16); // 성공 true, 용량제한 false

        System.out.println(que2);
    }
}
