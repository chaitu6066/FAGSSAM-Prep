class CloneRandomPointer extends SingleLinkedList {
    // clone random pointer linked list
    cloneRandomPointer() {
        let current = this.head;
        // 2,4,5,3,1
        this.printText('original list');
        this.printList();
        // create copy
        // 2,2,4,4,5,5,3,3,1,1
        while(current) {
            let temp = current.next;
            current.next = new Node(current.data);
            current.next.next = temp;
            current = temp;
        }
        current = this.head;
        // set random value on copy
        while(current) {
            if (current.next && current.random) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        current = this.head;
        // remove copied nodes
        // 2,2,4,4,5,5,3,3,1,1
        while(current) {
            if (current.next) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        this.printText('cloned list');
        this.printList();
    }

    inputToProblem() {
        // list 2,4,5,3,1
        const node1 = new Node(1, null);
        const node2 = new Node(3, node1);
        const node3 = new Node(5, node2);
        node3.random = node2;
        const node4 = new Node(4, node3);
        const node5 = new Node(2, node4);
        node5.random = node1;
        this.head = node5;
        
    }
}

const CRP = new CloneRandomPointer();
CRP.inputToProblem();
CRP.cloneRandomPointer();