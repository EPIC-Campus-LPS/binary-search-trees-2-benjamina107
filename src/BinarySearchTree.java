import com.sun.source.tree.Tree;

public class BinarySearchTree {

    private TreeNode<Integer> root;
    private int numNodes = 0;

    public void add(Integer value) {

        TreeNode<Integer> val = new TreeNode<Integer>(value, null, null);

        if (numNodes == 0) {
           root = val;
        } else {

            //starts at root
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

        numNodes++;

    }

    public boolean contains(E value) {
        
            //starts at root
            TreeNode<Integer> current = root;

            boolean loop = true;
            while (loop) {

                //tests if the value goes to the left or right of 'current'
                if (value > current.getValue()) {

                    //if the child is null simply return false
                    if (current.getLeftChild() == null) {

                        loop = false;
                        return false;

                    //if the left child value is occupied, test if it is value
                    }else if(current.getLeftChild().getValue() == value) {

                        loop = false;
                        return true;
                    
                    //if nothing is found then continue
                    } else {

                        current = current.getLeftChild();

                    }

                } else {

                  
                    //if the child is null simply return false
                    if (current.getRightChild() == null) {

                        loop = false;
                        return false;

                    //if the right child value is occupied, test if it is value
                    }else if(current.getRightChild().getValue() == value) {

                        loop = false;
                        return true;
                    
                    //if nothing is found then continue
                    } else {

                        current = current.getRightChild();

                    }

                }

            }

    }

    public int countNodes() {
        return numNodes;
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
