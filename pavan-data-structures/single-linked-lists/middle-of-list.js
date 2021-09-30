class MiddleOfLinkedList extends SingleLinkedList {
    // middle of linked list 
    // runner technic
    middleOfLinkedList() {
        let slowPointer = this.head;
        let fastPointer = this.head;
        
        while (fastPointer.next) {
            if (fastPointer.next.next) {
                fastPointer = fastPointer.next.next;
            } else {
                fastPointer = fastPointer.next;
            }
            slowPointer = slowPointer.next; 
        }
        this.printText(`middle of the linked list is ${slowPointer.data}`);

    }
}

const MLL = new MiddleOfLinkedList();
MLL.middleOfLinkedList();