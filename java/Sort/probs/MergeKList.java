
import java.util.LinkedList;
import java.util.List;

public class MergeKList {

    public static void main(String[] args) {
        // EC-1 - if array is empty
        // if (arr.length == 0)
        // return;
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        // ListNode[] arr = new ListNode[3];
        // ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        // ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        // ListNode node3 = new ListNode(3, new ListNode(6));
        // arr[0] = node1;
        // arr[1] = node2;
        // arr[2] = node3;

        // ListNode result = new ListNode();
        System.out.println(node1.toString());
        // System.out.println(arr.toString());
        // result = mergeArraysHelper(arr, 0, arr.length - 1);
        // System.out.println(result.toString());
    }

}

// // since these are sorted array and we know the size of each array (K) which
// is
// // same.
// // we can take 2 arrays and start compare and merge and form an array.
// // repeat this and make sure we have compared and merged (N) arrays.
// // this should leave is with a single sorted array.
// public static ListNode mergeArraysHelper(ListNode[] arr, int start, int end)
// {
// // base case
// if (start >= end) {
// return arr[start];
// }
// // rec
// int mid = start + (end - start) / 2;
// ListNode a = mergeArraysHelper(arr, start, mid);
// ListNode b = mergeArraysHelper(arr, mid + 1, end);
// return compareAndMerge(a, b);

// }

// // compare the each item in 2 arrays and merge them to a res array .
// public static ListNode compareAndMerge(ListNode a, ListNode b) {

// ListNode res = new ListNode();

// // iterate the list
// while (a.next != null && b.next != null) {
// if (a.val <= b.val) {
// res.next = a;
// a = a.next;
// } else {
// res.next = b;
// b = b.next;
// }
// res = res.next;
// }

// res.next = (a.next != null) ? a : b;

// return res;

// }
