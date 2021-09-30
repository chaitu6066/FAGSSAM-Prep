class InsertATKPosition extends SingleLinkedList {
    // fast pointer and slow pointer
    insertAt(index, data) {
        if (index === 0) {
            this.insertAtStart(data);
            return;
        }

        let current, previous;
        current = this.head;
        let count = 0;
        while (count < index) {
            previous = current;
            current = current.next;
            count++;
        }
        previous.next = new Node(data, current);
    }

    removeAt (index) {
        if (index === 0) {
            this.removeAtStart();
            return;
        }

        let current, previous;
        current = this.head;
        let count = 0;
        while (count < index) {
            previous = current;
            current = current.next;
            count++;
        }
        previous.next = current.next;

    }

    getItemAt (index) {
        let current = this.head;
        let count = 0;
        while (count < index) {
            current = current.next;
            count++;
        }
        this.printText(`item at index ${index} is - ${current.data}`);
    }

    insertAtStart(data) {
        this.head = new Node(data, this.head);
    }
    
    insertAtEnd(data) {
        if (!this.head) {
            this.head = new Node(data, this.head);
        } else {
            let current = this.head;
            while (current.next) {
                current =  current.next;
            }
            current.next = new Node(data, null);
        }
    }

    removeAtStart () {
        this.head = this.head.next;
    }

    removeAtEnd () {
        if (!this.head.next) {
            this.head = null;
            return;
        }

        let current = this.head;
        let previous;
        while (current.next) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }
}

const IAKP = new InsertATKPosition();
IAKP.insertAt(2, 105);
IAKP.getItemAt(2);
IAKP.removeAt(2);