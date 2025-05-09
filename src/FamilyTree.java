import java.util.HashMap;
import java.util.ArrayList;

public class FamilyTree {
    // Hash table for storing the tree
    private HashMap<String, FamilyMember> tree = new HashMap<>();

    // Basic Hash Table methods

    // Add a member to the hash table
    void addMember(String name, FamilyMember member) {
        tree.put(name, member);
    }
    // Check if a member is in the table
    boolean containsMember(String name) {
        return tree.containsKey(name);
    }
    // Geet a member from the table
    FamilyMember getMember(String name) {
        return tree.get(name);
    }

    // Your code here
    public void printRelationship(String firstName, String secondName) {
        System.out.println(tree); // check tree
        FamilyMember first = tree.get(firstName);
        if (first == null) {
            System.out.printf("Name not found:%s%n", firstName);
            return;
        }
        ArrayList<FamilyMember> firstAscent = first.lineOfAscent();
        System.out.println(firstAscent); // check first line of ascent


    }
}