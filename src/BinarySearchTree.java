import com.sun.source.tree.Tree;

public class BinarySearchTree {

    private TreeNode<Integer> root =;
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

        if (numNodes = 0) {
            return -1;
        }

        return countLeafNodesHelper(root)

    }

    public int countLeafNodesHelper(TreeNode<Integer> rt) {
        //count of leaf nodes to be returned
        int count = 0;

        if(rt.getLeftChild == null && rt.getRightChild == null) {
            // if you get to a leaf node, return with 1 to represent the 1 leaf node you just found
            return 1;

        }
    
        //if there's a child on the left
        if(rt.getLeftChild != null) {

            //add count result from next left node to this count
            count += countLeafNodesHelper(rt.getLeftChild)

        }

        //if there's a child on the right
        if(rt.getRightChild != null) {

            //add count result from next right node to this count
            count += countLeafNodesHelper(rt.getRightChild)

        }

        //return sum of descendant leaf nodes
        return count;

    }

    public int getHeight() {
        
        if (numNodes = 0) {
            return -1;
        }

        return heightHelper(root, 0);

    }

    public int heightHelper(TreeNode<Integer> rt, depth) {

        //to compare which is the biggest, left or right
        int leftDepth = -1;
        int rightDepth = -1;

        if(rt.getLeftChild == null && rt.getRightChild == null) {
            //if it gets to the bottom, simply return the pre calculated depth
            return depth;

        }
    

        if(rt.getLeftChild != null) {

            //goes down a level to left and adds 1 to depth
            int leftDepth = heightHelper(rt.getLeftChild, depth + 1);

        }

    
        if(rt.getRightChild != null) {

            //goes down a level to right and adds 1 to depth
            int rightDepth = heightHelper(rt.getRightChild, depth + 1);

        }

        //compare left and right heights to get the max
        int biggestDepth = leftDepth;

        if(leftDepth < rightDepth) {biggestDepth = rightDepth};

        return biggestDepth;

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
