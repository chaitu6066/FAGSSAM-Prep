const printText = (text) => {
    document.getElementById('container').innerHTML += text;
    document.getElementById('container').innerHTML += '<br />';
}

class Stack {
    constructor(list) {
        this.list = list?.length ? list : [];
    }

    isEmpty() {
        return !this.list.length;
    }

    push(value) {
        this.list.push(value);
    }

    pop() {
        return this.list.pop();
    }

    top() {
        return this.list[this.list.length - 1];
    }

    printStack() {
        let concateText = '';
        for(let i = this.list.length-1; i >= 0 ; i--) {
            concateText = concateText ? `${concateText}, ${this.list[i]}` : this.list[i];
        }
        printText(concateText);
    }
}