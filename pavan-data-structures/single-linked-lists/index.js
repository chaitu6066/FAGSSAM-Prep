class Node {
    constructor(data, next = null) {
        this.data = data;
        this.next = next;
    }
}

class SingleLinkedList {
    constructor(list) {
        this.head = null;
        const defaultList = [1, 14, 12, 10, 9, 8, 21, 3, 4, 7, 6, 29];
        this.insertMultipleAtEnd(list?.length ? list : defaultList);
    }

    insertMultipleAtEnd(list) {
        let current = this.head;
        while (current && current.next) {
            current = current.next;
        }
        for(let i = 0; i < list.length; i++) {
            if (!current) {
                this.head = new Node(list[i], null);
                current = this.head;
            } else {
                current.next = new Node(list[i], null);
                current = current.next;
            }            
        }
    }

    printText(text) {
        document.getElementById('container').innerHTML += text;
        document.getElementById('container').innerHTML += '<br />';
    }

    printList() {
        let current = this.head;
        let concateText = '';
        while(current) {
            concateText = concateText ? `${concateText}, ${current.data}` : current.data;
            current =  current.next;
        }
        this.printText(concateText);
    }
    
    printGivenList(head) {
        let current = head;
        let concateText = '';
        while(current) {
            concateText = concateText ? `${concateText}, ${current.data}` : current.data;
            current =  current.next;
        }
        this.printText(concateText);
    }

    stack(list) {
        let tempHead = null;
    
        for(let i = 0; i < list.length; i++) {
            if (!tempHead) {
                tempHead = new Node(list[i], null);
            } else {
                tempHead = new Node(list[i], tempHead);
            }            
        }
        this.printGivenList(tempHead);
    }

}
