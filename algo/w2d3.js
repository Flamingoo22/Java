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

    /**
   * Inserts a new node with the given newVal in the right place to preserver
   * the order of this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {number} newVal The data to be added to a new node.
   * @returns {BinarySearchTree} This tree.
   */
    insert(newVal) {
        if(!this.root){
            this.root = new BSTNode(newVal);
        }
        let current = this.root;
        while(current){
            if(newVal >= current.data){
                if(current.right == null){
                    return current.right = new BSTNode(newVal);
                }
                current = current.right;
            }
            else{
                if(current.left == null){
                    return current.left = new BSTNode(newVal);
                }
                current = current.left;
            }
        }
    }

    /**
     * Inserts a new node with the given newVal in the right place to preserver
     * the order of this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {number} newVal The data to be added to a new node.
     * @param {Node} curr The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {BinarySearchTree} This tree.
     */
    insertRecursive(newVal, curr = this.root) {
        if(!curr){
            this.root = new BSTNode(newVal);
        }
        if(newVal >= curr.data && !curr.right){
            return curr.right = new BSTNode(newVal);
        }else if(newVal < curr.data && !curr.left){
            return curr.left = new BSTNode(newVal);
        }
    
        if(newVal>=curr.data){
            return this.insertRecursive(newVal, curr.right);
        }else{
            return this.insertRecursive(newVal, curr.left);
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

/* twoLevelTree
        root
        10
    /   \
    5     15
  */
const twoLevelTree = new BinarySearchTree();
twoLevelTree.root = new BSTNode(10);
twoLevelTree.root.left = new BSTNode(5);
twoLevelTree.root.right = new BSTNode(15);

/* threeLevelTree 
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
threeLevelTree.print()


console.log("***************************")
// threeLevelTree.insert(7);
// threeLevelTree.insert(10);
// threeLevelTree.insert(8);
// threeLevelTree.insert(20);
threeLevelTree.insertRecursive(7)
threeLevelTree.insertRecursive(10)
threeLevelTree.insertRecursive(8)
threeLevelTree.insertRecursive(20)
threeLevelTree.insertRecursive(14)



threeLevelTree.print();