package edu.sdccd.cisc191;

import java.util.Objects;

public class BinarySearchTree {
    /**
     * Recursively finds the needle in the Binary Search Tree (BST) haystack
     * @param root which node to start searching from
     * @param needle the data to search for
     * @return the first BSTNode containing the needle, null if doesn't exist
     */
    public BSTNode contains(BSTNode root, String needle) {
        // TODO: fill this out, you can choose any order of traversal
        if (Objects.equals(root.getData(), needle)) {
            return root;
        }
        else {
            if (root.getLeft() != null) {
                return contains(root.getLeft(), needle);
            }
            if (root.getRight() != null) {
                return contains(root.getRight(), needle);
            }
        }
        return null;
    }

    /**
     * Recursively converts a String array to Binary Search Tree (BST)
     * @param array the array of Strings to import into the BST
     * @param end index in the array to stop importing
     * @return the root node of the generated BST
     */
    public BSTNode fromArray(String[] array, int end) {
        // TODO: fill this out, you can choose any order of traversal
        BSTNode root = new BSTNode(array[array.length/2 - 1]);
        int i = 1;
        while (i <  end - 1) {
            root.setLeft(new BSTNode(array[i]));
            i++;
            root.setRight(new BSTNode(array[i]));
            i++;
        }
        return root;
    }
}

