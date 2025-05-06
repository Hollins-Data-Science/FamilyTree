import java.util.HashMap;

public class FamilyTree {
    // Hash table for storing the tree
    private HashMap<String, FamilyMember> tree;

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
}