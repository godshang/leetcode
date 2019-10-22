package common;

public class Util {

    public static void printList(ListNode n) {
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.val).append("->");
            n = n.next;
        }
        if (sb.length() > 2) {
            System.out.println(sb.substring(0, sb.length() - 2));
        } else {
            System.out.println(sb.toString());
        }
    }

    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
