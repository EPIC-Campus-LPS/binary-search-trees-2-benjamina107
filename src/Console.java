import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Console {

    public static void main(String[] args) throws FileNotFoundException {

        boolean loop = true;
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        while (loop) {

            Scanner stringScanner = new Scanner(System.in);
            System.out.println();
            System.out.println("--MENU--");
            System.out.println("[1] Fill tree from file");
            System.out.println("[2] Add value to tree");
            System.out.println("[3] Delete value from tree");
            System.out.println("[4] Test if tree contains value");
            System.out.println("[5] Print Traversals");
            System.out.println("[6] Print Stats");
            System.out.println("[7] Clear Tree");
            System.out.println("[8] Exit Program");

            System.out.println();
            int input = Integer.valueOf(stringScanner.next());
            System.out.println();

            switch(input) {
                case 1:
                    System.out.println("Enter file name (must have .txt extension and be in main folder): ");

                    String file = stringScanner.next();
                    File fin = new File(file);
                    Scanner in;
                    try {
                        in = new Scanner(fin);
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("Invalid file. Please try again.");
                        break;
                    }

                    while (in.hasNextLine()) {
                        bst.add(Integer.valueOf(in.nextLine()));
                    }

                    break;

                case 2:

                    System.out.println("Add item: ");
                    int add = Integer.valueOf(stringScanner.next());
                    bst.add(add);
                    System.out.println("Added " + add + " to tree.");

                    break;

                case 3:

                    System.out.println("Remove item: ");
                    System.out.println("Removed " + bst.delete(Integer.valueOf(stringScanner.next())) + ".");

                    break;

                case 4:

                    System.out.println("Test if contains item: ");
                    System.out.println("Contains item: " + bst.contains(Integer.valueOf(stringScanner.next())));

                    break;

                case 5:

                    bst.printPreorder();
                    bst.printInorder();
                    bst.printPostorder();

                    break;

                case 6:

                    System.out.print("This tree has ");
                    System.out.print(bst.countNodes());
                    System.out.println(" nodes.");

                    System.out.print("This tree has ");
                    System.out.print(bst.countLeafNodes());
                    System.out.println(" leaf nodes.");

                    System.out.print("This tree's height is ");
                    System.out.print(bst.getHeight());
                    System.out.println(".");

                    break;

                case 7:

                    bst = new BinarySearchTree<Integer>();
                    System.out.println("Cleared tree.");

                    break;

                case 8:

                    loop = false;

                    break;
            }



        }
    }


}
