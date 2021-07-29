//package Probs;

import java.util.ArrayList;
import java.util.List;

public class MultiSet {
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);
        Node root2 = new Node(5);
        root2.left = new Node(4);
        root2.right = new Node(6);

        List<Integer> list1 = new ArrayList<Integer>();
        inorderToList(root1, list1);
        System.out.println(list1.toString());
        List<Integer> list2 = new ArrayList<Integer>();
        inorderToList(root2, list2);
        System.out.println(list2.toString());
        List<Integer> sortedList = new ArrayList<Integer>();
        mergeSort(list1, list2, sortedList);

        System.out.println(sortedList.toString());

    }

    public static void inorderToList(Node node, List<Integer> list) {
        if (node == null)
            return;

        if (node.left != null) {
            inorderToList(node.left, list);
        }

        list.add(node.key);

        if (node.right != null) {
            inorderToList(node.right, list);
        }
    }

    public static void mergeSort(List<Integer> list1, List<Integer> list2, List<Integer> sortedList) {
        int list1Index = 0;
        int list2Index = 0;
        while (list1Index < list1.size() && list2Index < list2.size()) {
            if (list1.get(list1Index) <= list2.get(list2Index)) {
                sortedList.add(list1.get(list1Index));
                list1Index = list1Index + 1;
            } else {
                sortedList.add(list2.get(list2Index));
                list2Index = list2Index + 1;
            }
        }

        while (list1Index < list1.size()) {
            sortedList.add(list1.get(list1Index));
            list1Index = list1Index + 1;
        }
        while (list2Index < list2.size()) {
            sortedList.add(list2.get(list2Index));
            list2Index = list2Index + 1;
        }
    }
}

class Node {
    int key;
    Node left;
    Node right;

    Node() {
    }

    Node(int key) {
        this.key = key;
    }

    Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
