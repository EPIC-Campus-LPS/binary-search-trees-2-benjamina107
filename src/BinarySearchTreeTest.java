import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @org.junit.jupiter.api.Test
    void add() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(1);
        bst.add(3);

        assertEquals(bst.contains(8), false);
    }

    @org.junit.jupiter.api.Test
    void contains() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(1);
        bst.add(3);

        assertEquals(bst.contains(2), true);
    }

    @org.junit.jupiter.api.Test
    void countNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(1);
        bst.add(3);
        bst.delete(5);

        assertEquals(bst.countNodes(), 4);
    }

    @org.junit.jupiter.api.Test
    void countLeafNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(1);
        bst.add(3);

        assertEquals(bst.countLeafNodes(), 3);
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(1);
        bst.add(3);

        assertEquals(bst.getHeight(), 2);
    }

    @org.junit.jupiter.api.Test
    void printInorder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(1);
        bst.add(3);

        bst.printInorder();
        System.out.println("Should be: 1 2 3 5 9");
    }

    @org.junit.jupiter.api.Test
    void printPreorder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(1);
        bst.add(3);

        bst.printPreorder();
        System.out.println("Should be: 5 2 1 3 9");
    }

    @org.junit.jupiter.api.Test
    void printPostorder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(1);
        bst.add(3);

        bst.printPostorder();
        System.out.println("Should be: 1 3 2 9 5");
    }

    @org.junit.jupiter.api.Test
    void delete() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(1);
        bst.add(3);
        bst.delete(5);

        assertEquals(bst.contains(5), false);
    }
}