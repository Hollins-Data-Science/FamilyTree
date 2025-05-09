import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {

  // This function opens a file with relationships and adds
  // them to the given FamilyTree
  public static void buildTree(String filePath, FamilyTree tree) {
    try {
      // open the file
      File file = new File(filePath);
      // setup a scanner
      Scanner sc = new Scanner(file);
      int lineCount = 0;
      while (sc.hasNextLine()) {
        // Pull out the child and parent
        String childName = sc.next().toUpperCase();
        sc.next(); // separator
        String parentName = sc.next().toUpperCase();

        // Your code here
        // Add the relationship to your FamilyTree:
        // Check if child and parent exist, if not create them and add to hash table
        // Set the child's parent
        // Add the child as a child of the parent
        if (!tree.containsMember(childName)) { // if the child is not in the tree
          tree.addMember(childName, new FamilyMember(childName)); // create the child and add it
        }
        FamilyMember child = tree.getMember(childName);

        // // do same thing with parent

        // Create the links
        child.parent = parent; // setup parent link
        parent.children.add(child); // setup child link

        lineCount++;
      }
      System.out.printf("File read, %d relationships added.\n", lineCount);
      sc.close();
    }
    // If we can't find the file, handle the error here
    catch (FileNotFoundException error) {
      System.out.println("File not found!");
    }
  }

  public static void main(String[] args) {
    // Create a tree
    FamilyTree tree = new FamilyTree();
    // Add the relationships in the file
    buildTree("./family.txt", tree);

    // Process user input
    // User input will look like: B A
    // Which means print how B is related to A
    // Your input loop should stop when the user types quit
    Scanner stdin = new Scanner(System.in);
    System.out.println("Enter two names:");
    String name1 = stdin.next();
    while (!name1.equals("quit")) {
      String name2 = stdin.next();
      System.out.printf("Asking about the relationship between %s and %s.%n", name1, name2);
      System.out.println("Enter two names:");
      name1 = stdin.next();
    }
    stdin.close();
  }
}