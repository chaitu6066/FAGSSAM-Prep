class PrintFromLast extends SingleLinkedList {
    // fast pointer and slow pointer
    printValueFromLastAtPosition(index) {
        let fastPointer = this.head;
        let slowPointer = this.head;
        for(let i=0 ; i<index ; i++) {
            fastPointer = fastPointer.next;
        }
        while(fastPointer) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        this.printText(`value from last at position ${index} is ${slowPointer.data}`);
    }
}

const pfl = new PrintFromLast();
pfl.printValueFromLastAtPosition(3);