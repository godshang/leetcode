package q432_all_oone_data_structure;

public class Solution {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.inc("leet");
//        System.out.println(allOne.getMaxKey());
//        System.out.println(allOne.getMinKey());
        allOne.inc("leet");
        allOne.dec("hello");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}
