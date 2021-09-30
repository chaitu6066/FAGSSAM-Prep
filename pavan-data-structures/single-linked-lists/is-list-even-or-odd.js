class IsListEvenOrOdd extends SingleLinkedList {
    
    isEvenOrOdd() {
        
        if (!this.head) return 'empty list';
        if (!this.head.next) {
            this.printText('odd');
            return;
        }
        if (!this.head.next.next) {
            this.printText('even');
            return;
        }
        let fastPointer = this.head.next.next;
        while(fastPointer.next && fastPointer.next.next) {
           fastPointer = fastPointer.next.next;
        }
        if (fastPointer.next) {
            this.printText('even');
            return;
        }
        this.printText('odd');
    }

    //
    findStartingPointOfLoop() {

    }
}

const ISEO = new IsListEvenOrOdd([1,2,3,4,5,6,8,9,10]);
ISEO.isEvenOrOdd();