import com.sun.source.tree.Tree;

/**
 * A class representing a binary tree
 */
public class BinarySearchTree<E> {

    private TreeNode<Integer> root;
    private int numNodes = 0;

    /**
     * Adds an item to the binary tree
     * 
     * @param value the value to be added
     */
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
                    if (current.getRightChild() == null) {

                        current.setRightChild(val);
                        loop = false;

                    //if the left child value is occupied, make that the new 'current'
                    } else {

                        current = current.getRightChild();

                    }

                } else {

                    //if the right child value is empty, set it as the new value
                    if (current.getLeftChild() == null) {

                        current.setLeftChild(val);
                        loop = false;

                    //if the right child value is occupied, make that the new 'current'
                    } else {

                        current = current.getLeftChild();

                    }

                }

            }

        }

        numNodes++;

    }

    /**
     * Adds a pre-existing node to the binary search tree (Helper method for delete)
     * 
     * @param val the node to be added
     */
    public void addNode(TreeNode<Integer> val) {

        if (numNodes == 0) {
           root = val;
        } else {

            //starts at root
            TreeNode<Integer> current = root;

            boolean loop = true;
            while (loop) {

                //tests if the value goes to the left or right of 'current'
                if (val.getValue() > current.getValue()) {

                    //if the left child value is empty, set it as the new value
                    if (current.getRightChild() == null) {

                        current.setRightChild(val);
                        loop = false;

                    //if the left child value is occupied, make that the new 'current'
                    } else {

                        current = current.getRightChild();

                    }

                } else {

                    //if the right child value is empty, set it as the new value
                    if (current.getLeftChild() == null) {

                        current.setLeftChild(val);
                        loop = false;

                    //if the right child value is occupied, make that the new 'current'
                    } else {

                        current = current.getLeftChild();

                    }

                }

            }

        }

    }

    /**
     * Tests if the tree contains a specific value
     * 
     * @param value the value to be tested for
     * @return true or false of whether the value is there or not
     */
    public boolean contains(int value) {

                if (numNodes == 0) {
                    return false;
                }       
        
            //starts at root
            TreeNode<Integer> current = root;

                if (current.getValue() == value) { return true;}

            boolean loop = true;
            while (loop) {

                //tests if the value goes to the left or right of 'current'
                if (value <= current.getValue()) {

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
        return false;
    }

    /**
     * Tells you how many nodes are in the tree
     * 
     * @return the amount of nodes in the tree
     */
    public int countNodes() {
        return numNodes;
    }

    /**
     * Counts the amount of child-less nodes in the tree
     * 
     * @return the amount of child nodes
     */
    public int countLeafNodes() {

        if (numNodes == 0) {
            return -1;
        }

        return countLeafNodesHelper(root);

    }

    /**
     * Recursive helper method for countLeafNodes
     * 
     * @param rt the node in question
     * @return the amount of leaf nodes at current point in counting
     */
    public int countLeafNodesHelper(TreeNode<Integer> rt) {
        //count of leaf nodes to be returned
        int count = 0;

        if(rt.getLeftChild() == null && rt.getRightChild() == null) {
            // if you get to a leaf node, return with 1 to represent the 1 leaf node you just found
            return 1;

        }
    
        //if there's a child on the left
        if(rt.getLeftChild() != null) {

            //add count result from next left node to this count
            count += countLeafNodesHelper(rt.getLeftChild());

        }

        //if there's a child on the right
        if(rt.getRightChild() != null) {

            //add count result from next right node to this count
            count += countLeafNodesHelper(rt.getRightChild());

        }

        //return sum of descendant leaf nodes
        return count;

    }

    /**
     * Tells you the height of the tree
     * 
     * @return the height of the tree
     */
    public int getHeight() {
        
        if (numNodes == 0) {
            return -1;
        }

        return heightHelper(root, 0);

    }

    /**
     * Recursive helper method for getHeight
     * 
     * @param rt the node in question
     * @param depth the depth at current point in counting
     * @return the depth at current point in counting
     */
    public int heightHelper(TreeNode<Integer> rt,int depth) {

        //to compare which is the biggest, left or right
        int leftDepth = -1;
        int rightDepth = -1;

        if(rt.getLeftChild() == null && rt.getRightChild() == null) {
            //if it gets to the bottom, simply return the precalculated depth
            return depth;

        }
    

        if(rt.getLeftChild() != null) {

            //goes down a level to left and adds 1 to depth
            leftDepth = heightHelper(rt.getLeftChild(), depth + 1);

        }

    
        if(rt.getRightChild() != null) {

            //goes down a level to right and adds 1 to depth
            rightDepth = heightHelper(rt.getRightChild(), depth + 1);

        }

        //compare left and right heights to get the max
        int biggestDepth = leftDepth;

        if(leftDepth < rightDepth) {biggestDepth = rightDepth;}

        return biggestDepth;

    }

    /**
     * Prints the inorder traversed tree
     */
    public void printInorder() {

        System.out.print("Inorder: ");
        helpInorder(root);
        System.out.println();

    }

    /**
     * Recursively prints in ineorder the amount of items in the tree (Helper method for printInorder)
     * 
     * @param rt the current node
     */
    public void helpInorder(TreeNode<Integer> rt) {

        //if it is null, finish without printing
        if (!(rt == null)) {

            //left, root, right
            helpInorder(rt.getLeftChild());
            System.out.print(rt.getValue() + " ");
            helpInorder(rt.getRightChild());

        }

    }

    /**
     * Prints the preorder traversed tree
     */
    public void printPreorder() {

        System.out.print("Preorder: ");
        helpPreorder(root);
        System.out.println();

    }

    /**
     * Recursively prints in preorder the amount of items in the tree (Helper method for printPreorder)
     * 
     * @param rt the current node
     */
    public void helpPreorder(TreeNode<Integer> rt) {

        //if it is null, finish without printing
        if (!(rt == null)) {

            //root, left, right
            System.out.print(rt.getValue() + " ");
            helpPreorder(rt.getLeftChild());
            helpPreorder(rt.getRightChild());

        }

    }

    /**
     * Prints the postorder traversed tree
     */
    public void printPostorder() {

        System.out.print("Postorder: ");
        helpPostorder(root);
        System.out.println();

    }

    /**
     * Recursively prints in postorder the amount of items in the tree (Helper method for printPostorder)
     * 
     * @param rt the current node
     */
    public void helpPostorder(TreeNode<Integer> rt) {

        //if it is null, finish without printing
        if (!(rt == null)) {

            //left, right, root
            helpPostorder(rt.getLeftChild());
            helpPostorder(rt.getRightChild());
            System.out.print(rt.getValue() + " ");

        }

    }

   /**
     * Deletes an item in the tree
     * 
     * @param value the value to be found and deleted
     * @return the item that was deleted, null if nonexistent
     */
    public int delete(int value) {

        if (numNodes == 0) {
            return -1;
        }

        //starts at root
        TreeNode<Integer> current = root;

        //parent of node to be deleted, to reattach the tree
        TreeNode<Integer> delParent;

        if (numNodes == 1 && root.getValue() == value) { root = null; numNodes--; }
//e
        if (root.getValue() == value) {

            TreeNode<Integer> left = root.getLeftChild();
            TreeNode<Integer> right = root.getRightChild();
            root = left;
            addNode(right);
            numNodes--;
            return value;

        }


        boolean loop = true;
        while (loop) {

            //tests if the value goes to the left or right of 'current'
            if (value <= current.getValue()) {

                //if the child is null simply return null
                if (current.getLeftChild() == null) {

                    loop = false;
                    return -1;

                //if the left child value is occupied, test if it is value, once found delete
                }else if(current.getLeftChild().getValue() == value) {

                    loop = false;
                    delParent = current;
                    TreeNode<Integer> del = current.getLeftChild();
                    
                    //if its a leaf node, delete it
                    if(del.getRightChild() == null && del.getLeftChild() == null) {
                    
                        delParent.setLeftChild(null);

                    //if there is only one child, replace with child
                    } else if(del.getRightChild() == null) {

                        delParent.setLeftChild(del.getLeftChild());

                    } else if(del.getLeftChild() == null) {

                        delParent.setLeftChild(del.getRightChild());

                    //only other case is if the left node is there still
                    } else {
                        //replace del with left child and reinsert right child
                        delParent.setLeftChild(del.getLeftChild());
                        addNode(del.getRightChild());

                    }
                    numNodes--;
                    return del.getValue();
                
                //if nothing is found then continue
                } else {

                    current = current.getLeftChild();

                }

            } else {

            
                //if the child is null simply return null
                if (current.getRightChild() == null) {

                    loop = false;
                    return -1;

                //if the right child value is occupied, test if it is value, once found delete
                }else if(current.getRightChild().getValue() == value) {

                    loop = false;
                    delParent = current;
                    TreeNode<Integer> del = current.getRightChild();
                    
                    //if its a leaf node, delete it
                    if(del.getRightChild() == null && del.getLeftChild() == null) {
                    
                        delParent.setRightChild(null);

                    //if there is only one child, replace with child
                    } else if(del.getRightChild() == null) {

                        delParent.setRightChild(del.getLeftChild());

                    } else if(del.getLeftChild() == null) {

                        delParent.setRightChild(del.getRightChild());

                    //only other case is if the left node is there still
                    } else {
                        //replace del with left child and reinsert right child
                        delParent.setRightChild(del.getLeftChild());
                        addNode(del.getRightChild());

                    }
                    numNodes--;
                    return del.getValue();

                //if nothing is found then continue
                } else {

                    current = current.getRightChild();

                }

            }

        }

        
        return -1;

    }

}
