class ReverseLinkedList extends SingleLinkedList {
    // reverse list
    // with right access
    reverseLinkedList() {
        let current = this.head;
        let prev = null;
        let next = null;
        this.printText('original list');
        this.printList();
        while(current) {
            // store next
            next = current.next;
            // reverse current pointer
            current.next = prev;
            // move one position 
            prev = current;
            current = next;
        }
        this.head = prev;
        this.printText('reverse of list');
        this.printList();
    }
}

const RLL = new ReverseLinkedList();
RLL.reverseLinkedList();