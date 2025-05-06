# Family Tree

In this assignment you will be building a family tree and answering questions about how members of the family are related. To keep things simple, each person only has one parent, but a parent can have multiple children. You are given the beginnings of a FamilyTree class that stores the tree as a graph of FamilyMember instances. The FamilyMember class is simply a node in the tree that keeps track of its parent and children. The FamilyMember instances are kept track of using a HashMap that allows you to look up a FamilyMember by name. Below is an image of the family tree we will be using, each node is a FamilyMember and the letters are their names.

![The family tree for the problem.](/tree.png "Family Tree")

## Changes to FamilyMember and FamilyTree

You are given some initial code for FamilyMember and FamilyTree, but you will need to make some additions:

### Line of Ascent

You will need to add a public method to FamilyMember called `lineOfAscent`. This function returns an ArrayList of FamilyMember instances, starting with itself and going all the way up to the top of the tree. For example, the line of ascent for `D` is `D B A`. You should follow each nodes parent link until you reach the node whose parent link is `null`. As more examples, the line of ascent for `K` is `K G C A` and the line of ascent for `A` is simply `A` (as it is the root node).

### Printing Relationships

You will need to add a public void method to FamilyTree called `printRelationship`. This method will take two names of family members (Strings) and print out the nature of their relationship. In order to calculate how two family members are related you will need to find the line of ascent for each. Then you will need to find each members distance to their closest common ancestor. Now for some examples:

Suppose you are calculating the relationship between H and J. The line of ascent for `H` is `H D B A`, and the line of ascent for `J` is `J E B A`. Their closest common ancestor is `B` and H's distance is 2 and J's distance is also 2. You will then take those two numbers and look them up in the table below to find their relationship. We see that H is the first cousin of J.

Suppose you are calculating the relationship between K and C. The line of ascent for `K` is `K G C A`, and the line of ascent for `C` is `C A`. Their closest common ancestor is `C` and K's distance is 2 and C's distance is 0. You will then take those two numbers and look them up in the table below to find their relationship. We see that K is the grandchild of C.

Suppose you are calculating the relationship between D and B. The line of ascent for `D` is `D B A`, and the line of ascent for `C` is `C A`. Their closest common ancestor is `A` and D's distance is 2 and B's distance is 1. You will then take those two numbers and look them up in the table below to find their relationship. We see that D is the first cousin once removed of B.

In the table below X and Y are each members distance from their common ancestor. 

| X | Y | Relationship |
| - | - | ------------ |
| 0 | 0 | X and Y are the same person |
| 0 | 1 | X is the parent of Y |
| 0 | 2 | X is the grandparent of Y |
| 0 | 3 | X is the great-grandparent of Y |
| 1 | 0 | X is the child of Y |
| 1 | 1 | X is a sibling of Y |
| 1 | 2 | X is a first cousin once removed of Y |
| 1 | 3 | X is a first cousin twice removed of Y |
| 2 | 0 | X is a grandchild of Y |
| 2 | 1 | X is a first cousin once removed of Y |
| 2 | 2 | X is a first cousin of Y |
| 2 | 3 | X is a second cousin once removed |
| 3 | 0 | X is the great-grandchild of Y |
| 3 | 1 | X is the second cousin twice removed of Y |
| 3 | 2 | X is the second cousin once removed of Y |
| 3 | 3 | X is the second cousin of Y |

## Changes to Main

### Building the Tree
The Main includes a function called `buildTree` that reads in family tree information from a file. The file contains lines like `H -- D`,  which means H is a child of D. You don't have to handle reading the file, but you will need to build the relationships. You will have to add lines to this function that create the FamilyMember instances, if they don't already exist in the family tree. Then setup the parent and child links between the family members.

### I/O Loop
You will need to add an input/output loop to your Main that reads in two names and prints out their relationship. Your loop should continue until user types quit. You can add error checking if you like, but you can also assume the user types in valid names.

## Sample Output
```
Enter two names:
A C
A is the parent of C
Enter two names:
B J
B is the grandparent of J
Enter two names:
J B
J is the grandchild of B
Enter two names:
H C
H is the second cousin twice removed of C
Enter two names:
D F
D is the first cousin of F
Enter two names:
quit
```