/**
 * Class to represent a Node in a Binary Search Tree (BST).
 */
class BSTNode {
    /**
     * Constructs a new instance of a BST node.
     * @param {number} data The integer to store in the node.
     */
    constructor(data) {
        this.data = data;
        /**
       * These properties are how this node is connected to other nodes to form
       * the tree. Similar to .next in a SinglyLinkedList except a BST node can
       * be connected to two other nodes. To start, new nodes will not be
       * connected to any other nodes, these properties will be set after
       * the new node is instantiated.
       *
       * @type {BSTNode|null}
       */
        this.left = null;
      /** @type {BSTNode|null} */
        this.right = null;
    }
}

/**
   * Represents an ordered tree of nodes where the data of left nodes are <= to
   * their parent and the data of nodes to the right are > their parent's data.
   */
class BinarySearchTree {
    constructor() {
        /**
       * Just like the head of a linked list, this is the start of our tree which
       * branches downward from here.
       *
       * @type {BSTNode|null}
       */
        this.root = null;
    }
    
    printInorder(curr = this.root) {
        if (!curr) {
            return;
        }
        if (curr) {
            this.printInorder(curr.left);
            console.log(curr.data);
            this.printInorder(curr.right);
        }
    }
    
    printPreorder(curr = this.root) {
        if (!curr) {
            return;
        }
        if (curr) {
            console.log(curr.data);
            this.printPreorder(curr.left);
            this.printPreorder(curr.right);
        }
    }
    
    printPostorder(curr = this.root) {
        if (!curr) {
            return;
        }
        if (curr) {
            this.printPostorder(curr.left);
            this.printPostorder(curr.right);
            console.log(curr.data);
        }
    }
    
    
    /**
   * Recursively counts the total number of nodes in this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} node The current node during the traversal of this tree.
   * @returns {number} The total number of nodes.
   */
    size(node = this.root, count=0) {
        if (node == null)
            return count;
        return (this.size(node.left, count=1) + this.size(node.right, count=1));
    }

    
    size1(node = this.root) {
        if (node == null)
            return 0;
        else
        return (this.size1(node.left) + 1 + this.size1(node.right));
    }

    /**
   * Calculates the height of the tree which is based on how many nodes from
   * top to bottom (whichever side is taller).
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} node The current node during traversal of this tree.
   * @returns {number} The height of the tree.
   */
    height(node = this.root, height=1) {
        if(!node){
            return 0;
        }
        return 1 + Math.max(this.height(node.left), this.height(node.right));
        }
    

    /**
   * Determines if this tree is a full tree. A full tree is a tree where every
   * node has both a left and a right except for the leaf nodes (last nodes)
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} node The current node during traversal of this tree.
   * @returns {boolean} Indicates if this tree is full.
   */
    isFull(node = this.root) {
        if(node.left && !node.right){
            return false;
        }
        else if(!node.left && node.right){
            return false;
        }
        else if(!node.left && !node.right){
            return true;
        }
        else{
            return this.isFull(node.left) && this.isFull(node.right);
        }
    }
    
    // Logs this tree horizontally with the root on the left.
    print(node = this.root, spaceCnt = 0, spaceIncr = 10) {
        if (!node) {
            return;
        }
    
        spaceCnt += spaceIncr;
        this.print(node.right, spaceCnt);
    
        console.log(
            " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
            `${node.data}`
        );
    
        this.print(node.left, spaceCnt);
        }
}

const emptyTree = new BinarySearchTree();


const oneNodeTree = new BinarySearchTree();
oneNodeTree.root = new BSTNode(10);

/* twoLevelTree - full tree
        root
        10
    /   \
    5     15
*/
const twoLevelTree = new BinarySearchTree();
twoLevelTree.root = new BSTNode(10);
twoLevelTree.root.left = new BSTNode(5);
twoLevelTree.root.right = new BSTNode(15);

/* threeLevelTree - not full
        root
        10
    /   \
    5     15
/ \    / \
2   6  13  
*/
const threeLevelTree = new BinarySearchTree();
threeLevelTree.root = new BSTNode(10);
threeLevelTree.root.left = new BSTNode(5);
threeLevelTree.root.left.left = new BSTNode(2);
threeLevelTree.root.left.right = new BSTNode(6);
threeLevelTree.root.right = new BSTNode(15);
threeLevelTree.root.right.left = new BSTNode(13);
// threeLevelTree.print()


/* threeLevelTree - full
        root
        10
    /   \
    5     15
/ \    
2   6  
*/
const fullThreeLevelTree = new BinarySearchTree();
fullThreeLevelTree.root = new BSTNode(10);
fullThreeLevelTree.root.left = new BSTNode(5);
fullThreeLevelTree.root.left.left = new BSTNode(2);
fullThreeLevelTree.root.left.right = new BSTNode(6);
fullThreeLevelTree.root.right = new BSTNode(15);
fullThreeLevelTree.print()

console.log("here is the size: " + fullThreeLevelTree.size())
console.log("here is the size: " + fullThreeLevelTree.size1())
console.log("here is the size: " + fullThreeLevelTree.height())
console.log(fullThreeLevelTree.isFull())
console.log(threeLevelTree.isFull())
