import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Console {

    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        System.out.println("Please enter file name [file must be in main folder] : ");
        Scanner stringScanner = new Scanner(System.in);
        String file = stringScanner.next();
        File fin = new File(file);
        Scanner in = new Scanner(fin);

        while (in.hasNextLine()) {
            bst.add(Integer.valueOf(in.nextLine()));
        }
        System.out.println();
        System.out.println("Add item: ");
        bst.add(Integer.valueOf(stringScanner.next()));
        System.out.println();
        System.out.println("Remove item: ");
        System.out.println("Removed " + bst.delete(Integer.valueOf(stringScanner.next())) + ".");
        System.out.println();
        System.out.println("Test if contains item: ");
        System.out.println("Contains item: " + bst.contains(Integer.valueOf(stringScanner.next())));

        System.out.println();
        bst.printPreorder();
        bst.printInorder();
        bst.printPostorder();
        System.out.println();

        System.out.print("This tree has ");
        System.out.print(bst.countNodes());
        System.out.println(" nodes.");

        System.out.print("This tree has ");
        System.out.print(bst.countLeafNodes());
        System.out.println(" leaf nodes.");

        System.out.print("This tree's height is ");
        System.out.print(bst.getHeight());
        System.out.println(".");
        System.out.println();

        bst = new BinarySearchTree<Integer>();
        System.out.println("Cleared tree.");
    }


}
