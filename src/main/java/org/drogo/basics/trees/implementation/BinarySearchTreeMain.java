package org.drogo.basics.trees.implementation;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8);
        tree.insert(6);
        tree.insert(12);
        tree.insert(10);
        tree.display();

        tree.populate(new int[]{
                5, 2, 7, 1, 4, 6, 9, 8, 10
        });

        tree.display();

        tree.populateSorted(new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
        });

        tree.display();
    }
}
