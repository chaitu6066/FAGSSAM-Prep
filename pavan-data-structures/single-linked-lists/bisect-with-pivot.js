class BisectWithPivot extends SingleLinkedList {
    // Partition the linked list based on a given input number? Ex: All the small values should come before the bigger values of the given key
    // pivot element base bisect linked list
    // without right
    bisectWithPivot(pivot) {
        let sh;
        let st;
        let bh;
        let bt;
        let current = this.head;
        while(current.next) {
            if (current.data <= pivot) {
                if (!sh) {
                    sh = current;
                    st = sh;
                } else {
                    st.next = current;
                    st = st.next;
                }
            } else {
                if (!bh) {
                    bh = current;
                    bt = bh;
                } else {
                    bt.next = current;
                    bt = bt.next;
                }
            }
            current = current.next;
        }
        if (st) {
            bt.next = null;
            st.next = bh;
            this.printText(`list after bisected with ${pivot}`);
            this.printGivenList(sh); // print bisected list
        }

    }
}

const BWP = new BisectWithPivot();
BWP.bisectWithPivot(11);