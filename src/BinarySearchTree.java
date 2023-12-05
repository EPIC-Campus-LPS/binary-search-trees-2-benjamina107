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

    public void addNode(TreeNode<Integer> val) {

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

        helpInorder(root)

    }

    public void helpInorder(TreeNode<Integer> rt) {

        //if it is null, finish without printing
        if (!(rt == null)) {

            //left, root, right
            printInorder(rt.getLeftChild());
            System.out.println(rt.getValue() + ", ");
            printInorder(rt.getRightChild());

        }

    }

    public void printPreorder() {

        helpPreorder(root)

    }

    public void helpPreorder(TreeNode<Integer> rt) {

        //if it is null, finish without printing
        if (!(rt == null)) {

            //root, left, right
            System.out.println(rt.getValue() + ", ");
            printInorder(rt.getLeftChild());
            printInorder(rt.getRightChild());

        }

    }

    public void printPostorder() {

        helpPostorder(root);

    }

    public void helpPostorder(TreeNode<Integer> rt) {

        //if it is null, finish without printing
        if (!(rt == null)) {

            //left, right, root
            printInorder(rt.getLeftChild());
            printInorder(rt.getRightChild());
            System.out.println(rt.getValue() + ", ");

        }

    }

    public E delete(E value) {

        //starts at root
        TreeNode<Integer> current = root;

        //parent of node to be deleted, to reattach the tree
        TreeNode<Integer> delParent;

        boolean loop = true;
        while (loop) {

            //tests if the value goes to the left or right of 'current'
            if (value > current.getValue()) {

                //if the child is null simply return null
                if (current.getLeftChild() == null) {

                    loop = false;
                    return null;

                //if the left child value is occupied, test if it is value, once found delete
                }else if(current.getLeftChild().getValue() == value) {

                    loop == false;
                    delParent = current;
                    del = current.getLeftChild();
                    
                    //if its a leaf node, delete it
                    if(del.getRightChild == null && del.getLeftChild == null) {
                    
                        delParent.setLeftChild(null);

                    //if there is only one child, replace with child
                    } else if(del.getRightChild == null) {

                        delParent.setLeftChild(del.getLeftChild);

                    } else if(del.getLeftChild == null) {

                        delParent.setLeftChild(del.getRightChild);

                    //only other case is if the left node is there still
                    } else {
                        //replace del with left child and reinsert right child
                        delParent.setLeftChild(del.getLeftChild)
                        addNode(del.getRightChild)

                    }
                    numNodes--;
                    return del.getValue;
                
                //if nothing is found then continue
                } else {

                    current = current.getLeftChild();

                }

            } else {

            
                //if the child is null simply return null
                if (current.getRightChild() == null) {

                    loop = false;
                    return null;

                //if the right child value is occupied, test if it is value, once found delete
                }else if(current.getRightChild().getValue() == value) {

                    loop == false;
                    delParent = current;
                    del = current.getRightChild();
                    
                    //if its a leaf node, delete it
                    if(del.getRightChild == null && del.getLeftChild == null) {
                    
                        delParent.setRightChild(null);

                    //if there is only one child, replace with child
                    } else if(del.getRightChild == null) {

                        delParent.setRightChild(del.getLeftChild);

                    } else if(del.getLeftChild == null) {

                        delParent.setRightChild(del.getRightChild);

                    //only other case is if the left node is there still
                    } else {
                        //replace del with left child and reinsert right child
                        delParent.setRightChild(del.getLeftChild)
                        addNode(del.getRightChild)

                    }
                    numNodes--;
                    return del.getValue;

                //if nothing is found then continue
                } else {

                    current = current.getRightChild();

                }

            }

        }

        


    }
}
