package q432_all_oone_data_structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

    private Node head, tail;
    private Map<String, Node> nodeMap;

    public AllOne() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>();
    }

    public void inc(String key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.set.remove(key);
            int cnt = node.count;
            Node next;
            if (node.next.count == cnt + 1) {
                next = node.next;
            } else {
                next = new Node(cnt + 1);
                node.insertAfter(next);
            }
            next.set.add(key);
            nodeMap.put(key, next);
            node.clear();
        } else {
            Node node;
            if (head.next.count == 1) {
                node = head.next;
            } else {
                node = new Node(1);
                head.insertAfter(node);
            }
            node.set.add(key);
            nodeMap.put(key, node);
        }
    }

    public void dec(String key) {
        Node node = nodeMap.get(key);
        node.set.remove(key);
        int cnt = node.count;
        if (cnt == 1) {
            nodeMap.remove(key);
        } else {
            Node prev;
            if (node.prev.count == cnt - 1) {
                prev = node.prev;
            } else {
                prev = new Node(cnt - 1);
                node.insertBefore(prev);
            }
            prev.set.add(key);
            nodeMap.put(key, prev);
        }
        node.clear();
    }

    public String getMaxKey() {
        Node node = tail.prev;
        if (node.set.size() > 0) return node.set.iterator().next();
        return "";
    }

    public String getMinKey() {
        Node node = head.next;
        if (node.set.size() > 0) return node.set.iterator().next();
        return "";
    }

    static class Node {
        Node prev, next;
        Set<String> set = new HashSet<>();
        int count;

        public Node() {
        }

        public Node(int count) {
            this.count = count;
        }

        public void insertAfter(Node node) {
            node.prev = this;
            node.next = this.next;
            this.next.prev = node;
            this.next = node;
        }

        public void insertBefore(Node node) {
            node.next = this;
            node.prev = this.prev;
            this.prev.next = node;
            this.prev = node;
        }

        public void clear() {
            if (this.set.size() == 0) {
                this.count = 0;
                this.prev.next = this.next;
                this.next.prev = this.prev;
                this.prev = null;
                this.next = null;
            }
        }
    }
}
