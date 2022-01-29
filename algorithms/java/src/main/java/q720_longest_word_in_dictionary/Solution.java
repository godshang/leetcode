package q720_longest_word_in_dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        trie.words = words;
        int index = 0;
        for (String word : words) {
            trie.insert(word, ++index);
        }
        return trie.dfs();
    }

    public class Node {
        char c;
        Map<Character, Node> children = new HashMap<>();
        int end;

        public Node(char c) {
            this.c = c;
        }
    }

    public class Trie {
        Node root;
        String[] words;

        public Trie() {
            this.root = new Node('0');
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        public String dfs() {
            String ans = "";
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }
                    for (Node child : node.children.values()) {
                        stack.push(child);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}
