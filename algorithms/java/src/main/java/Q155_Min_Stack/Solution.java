package q155_min_stack;

import java.util.Stack;

public class Solution {

    class MinStack {

        private Stack<Integer> min;
        private Stack<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            min = new Stack<Integer>();
            stack = new Stack<Integer>();
        }

        public void push(int x) {
            if (min.isEmpty() || x < min.peek())
                min.push(x);
            else
                min.push(min.peek());
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    class MinStack2 {

        private Node head;

        /** initialize your data structure here. */
        public MinStack2() {
        }

        public void push(int x) {
            if (head == null)
                head = new Node(x, x);
            else
                head = new Node(x, Math.min(head.min, x), head);
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.min;
        }

        private class Node {
            int value, min;
            Node next;

            public Node(int value, int min) {
                this.value = value;
                this.min = min;
            }

            public Node (int value, int min, Node next) {
                this.value = value;
                this.min = min;
                this.next = next;
            }
        }
    }


    public static void main(String[] args) {
        Solution.MinStack2 minStack = new Solution().new MinStack2();
        minStack.push(-1);
        System.out.println(minStack.getMin());
        minStack.push(-2);
        System.out.println(minStack.getMin());
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
