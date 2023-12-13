package lesson37;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueExample {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("red");
        queue.offer("yellow");
        queue.offer("green");
        queue.offer("blue");
        queue.offer(null);
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);


        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();

        System.out.println("----");
        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.offer(1);
        numbers.offerLast(10);
        numbers.offerFirst(2);
        numbers.offer(100);
        System.out.println(numbers);

        System.out.println("----");
        Stack<String> stack = new Stack<>();
        stack.push("audi");
        stack.push("bmw");
        stack.push("mercedes");
        stack.push("skoda");
        stack.push("lada");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
