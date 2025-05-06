import java.util.ArrayList;

// Class to hold family member relationships
public class FamilyMember {
    public String name;
    public FamilyMember parent = null; // link to parent
    public ArrayList<FamilyMember> children = new ArrayList<FamilyMember>(); // links to children

    public FamilyMember(String name) {
      this.name = name;
    }

    public String toString() {
      return name;
    }

    // Your code here
  }