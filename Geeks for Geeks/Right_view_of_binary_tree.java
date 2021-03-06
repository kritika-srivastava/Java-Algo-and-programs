
/**
 * ~/Documents/Drive-E/GitHub/Competitive-Coding/Geeks for Geeks/Right_view_of_binary_tree.java
 * @author Kritika Srivastava
 * @since July 16, 2021
 *
 * Link - https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
 */
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution tree = new Solution();
            ArrayList<Integer> arr = tree.rightView(root);
            for (int x : arr)
                System.out.print(x + " ");
            System.out.println();

        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * Complete The Function Provided Given Below is The Node Of Tree class Node {
 * int data; Node left, right; public Node(int data) { this.data = data; left =
 * right = null; } }
 */

class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        if (root == null) {
            return l;
        }
        q.add(root);
        int k = 1;
        while (!q.isEmpty()) {
            k = q.size();
            Node n = q.peek();
            while (k-- > 0) {
                Node m = q.poll();

                if (m.right != null) {
                    q.add(m.right);
                }
                if (m.left != null) {
                    q.add(m.left);
                }

            }
            l.add(n.data);
        }
        return l;
    }
}
