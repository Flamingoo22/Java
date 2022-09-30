class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {

    constructor() {
        this.head = null;
    }

    isEmpty() {
        if (this.head) {
            return false;
        } else {
            return true;
        }
    }
    
/**
   * Concatenates the nodes of a given list onto the back of this list.
   * - Time: O(?).
   * - Space: O(?).
   * @param {SinglyLinkedList} addList An instance of a different list whose
   *    whose nodes will be added to the back of this list.
   * @returns {SinglyLinkedList} This list with the added nodes.
   */
concat(addList) {
    let runner = this.head;
    if(runner){
        while(runner.next){
            runner = runner.next
        }
    } else {
        this.head = addList.head;
    }
    runner.next = addList.head;
}

/**
   * Finds the node with the smallest data and moves that node to the front of
   * this list.
   * - Time: O(?).
   * - Space: O(?).
   * @returns {SinglyLinkedList} This list.
   */
moveMinToFront() {
    let index = -1;
    let runner = this.head;
    let minIndex = 0;
    let min = runner.data;
    if(runner){
        while(runner.next){
            index++;
            runner = runner.next;
            if(runner.data < min){
                min = runner.data;
                minIndex = index;
            }
        }
    }
    else{
        return false;
    }
    // console.log(minIndex)
    let prevNode = this.head;
    runner = prevNode.next;
    for(let i = 0; i < minIndex; i++){
        prevNode = runner;
        runner =  runner.next; //runner is min
    }
    // console.log(prevNode)
    prevNode.next = runner.next;
    runner.next = this.head; //make runner.next link to first node
    this.head = runner; //reassign the first node to runner(min data)
}

// EXTRA
/**
   * Splits this list into two lists where the 2nd list starts with the node
   * that has the given value.
   * splitOnVal(5) for the list (1=>3=>5=>2=>4) will change list to (1=>3)
   * and the return value will be a new list containing (5=>2=>4)
   * - Time: O(?).
   * - Space: O(?).
   * @param {any} val The value in the node that the list should be split on.
   * @returns {SinglyLinkedList} The split list containing the nodes that are
   *    no longer in this list.
   */
splitOnVal(val) {
    let prevNode = this.head;
    let runner = prevNode.next;
    if(runner){
        while(runner.data !== val){
            prevNode = runner;
            runner = runner.next;
        }
    }else{
        return false;
    }
    console.log(prevNode)
    prevNode.next = null;
    const list2 = new SinglyLinkedList()
    list2.head = runner;
    return list2;
}


    /**
     * Calls insertAtBack on each item of the given array.
     * - Time: O(n * m) n = list length, m = arr.length.
     * - Space: O(1) constant.
     * @param {Array<any>} vals The data for each new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBackMany(arrayOfValues, runner = this.head) {
        if (runner) {
            while (runner.next) {
            runner = runner.next
            }
        } else {
            this.head = new ListNode(arrayOfValues[0])
            runner = this.head
            arrayOfValues = arrayOfValues.filter((i) => i != arrayOfValues[0])
        }
        for (const val of arrayOfValues) {
            runner.next = new ListNode(val);
            runner = runner.next
        }
    }

    /**
     * Converts this list into an array containing the data of each node.
     * - Time: O(n) linear.
     * - Space: O(n).
     * @returns {Array<any>} An array of each node's data.
     */
    toArr() {
        const arr = [];
        let runner = this.head;
    
        while (runner) {
            arr.push(runner.data);
            runner = runner.next;
        }
        return arr;
    }
}

/******************************************************************* 
 */
const emptyList = new SinglyLinkedList();

const list1 = new SinglyLinkedList()
list1.insertAtBackMany([44, 56, 87])

const list2 = new SinglyLinkedList()
list2.insertAtBackMany([3, 8, 7, 9, 8, 9, 1])

const list3 = new SinglyLinkedList()
list3.insertAtBackMany([100])

console.log(list1.toArr());
console.log(list2.toArr());
list1.concat(list2);
console.log(list1.toArr());
// list1.toArr()
list1.moveMinToFront()
console.log(list1.toArr());
const list4 = list1.splitOnVal(3);
console.log("*************")
console.log(list1.toArr());
console.log(list4.toArr());
