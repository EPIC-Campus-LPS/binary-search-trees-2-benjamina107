import com.sun.source.tree.Tree;

public class BinarySearchTree {

    private TreeNode<Integer> root;
    private int numNodes = 0;

    public void add(Integer value) {

        TreeNode<Integer> val = new TreeNode<Integer>(value, null, null);

        if (numNodes == 0) {
           root = val;
        } else {
            TreeNode<Integer> current = root;

            boolean loop = true;
            while (loop) {

                //tests if the value goes to the left or right of 'current'
                if (value > current.getValue()) {

                    //if the left child value is empty, set it as the new value
                    if (current.getLeftChild() != null) {

                        current.setLeftChild(val);
                        loop = false;

                    //if the left child value is occupied, make that the new 'current'
                    } else {

                        current = current.getLeftChild();

                    }

                } else {

                    //if the right child value is empty, set it as the new value
                    if (current.getRightChild() != null) {

                        current.setRightChild(val);
                        loop = false;

                    //if the right child value is occupied, make that the new 'current'
                    } else {

                        current = current.getRightChild();

                    }

                }

            }

        }
    }

    public boolean contains(E value) {
    }

    public int countNodes() {

    }

    public int countLeafNodes() {

    }

    public int getHeight() {

    }

    public void printInorder() {

    }

    public void printPreorder() {

    }

    public void printPostorder() {

    }

    public E delete(E value) {

    }
}
