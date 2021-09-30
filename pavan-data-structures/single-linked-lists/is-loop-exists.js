class IsLoopExists extends SingleLinkedList {
    
    // to make linked list as loop
    makeALoopAt(index) {
        let listEnd = this.head;
        let listLoopAt = this.head;
        let counter = 0;
        while(listEnd.next) {
            listEnd = listEnd.next;
            counter++;
            if (counter < index ) {
                listLoopAt = listLoopAt.next;
            }
        }
        this.printText(`list loop at position ${index}`);
        listEnd.next = listLoopAt;
    }

    // to find loop exists
    isLoopExists() {
        let slowPointer = this.head;
        let fastPointer = this.head.next.next;
        while(fastPointer.next && fastPointer !== slowPointer) {
            if (fastPointer.next.next) {
                fastPointer = fastPointer.next.next;
            } else {
                fastPointer = fastPointer.next;
            }
            slowPointer = slowPointer.next;
        }
        if (fastPointer === slowPointer) {
            this.printText('loop exists');
            return;
        }
        this.printText('loop doesn`t exists');
    }

    //
    findStartingPointOfLoop() {

    }
}

const ILE = new IsLoopExists();
ILE.makeALoopAt(2);
ILE.isLoopExists();