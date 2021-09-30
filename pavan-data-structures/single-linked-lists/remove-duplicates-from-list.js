class RemoveDuplicates extends SingleLinkedList {
    // edge case in single linked list node should not be last node
    removeNodeWhenHaveWriteAccess(node) {
        if (node.next) {
            node.data = node.next.data;
            node.next = node.next.next;
        } else {
            node = node.next;
        }
        return node;
    }
    removeDuplicatesWithSpace(){
        let current = this.head;
        let map = {};
        while(current) {
            if (map[current.data]) { // if duplicate remove from list
                // to know the count of duplicates
                map[current.data] += 1;
                // to remove duplicate
                current = this.removeNodeWhenHaveWriteAccess(current);
            } else {
                map[current.data] = 1;
                current = current.next;
            }
            // current = current.next;
        } 
        console.log(map);  
    }
    removeDuplicatesWithoutSpace(){
        let current = this.head;
        while(current && current.next) {
            let temp = current;
            while (temp.next) { 
                if (current.data === temp.next.data) { // if duplicate remove from list
                    const dup = temp.next;
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            current = current.next;
        }
    }
}

const rdl = new RemoveDuplicates([1,2,5,6,7,7,8,8,9,3,4,5,6,7,5,6,7]);
// rdl.removeDuplicatesWithSpace();
rdl.removeDuplicatesWithoutSpace();
rdl.printText('after removeinh duplicates');
rdl.printList();