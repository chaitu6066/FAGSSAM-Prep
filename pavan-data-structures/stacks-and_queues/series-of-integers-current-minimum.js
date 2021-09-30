class SeriesOfIntegersCurMin {
    /*
        List with Series of integers & you are storing it in a stack. 
        Get the current minimum value?
    */
    constructor(list) {
        this.inputList = list?.length ? list : []; 
        this.stack = new Stack();
    }
    
    constructMinimumValue() {
        for(let i=0; i<this.inputList.length; i++) {
            const value = this.inputList[i];
            if (this.stack.isEmpty()) {
                this.stack.push(value);
            } else if (this.stack.top() >= value) {
                this.stack.push(value);
            }
        }
    }
    getCurrentMinimumValue() {
        const topOfStack = this.stack.top();
        printText(`current minimum value of ${this.inputList} is ${topOfStack}`);
    }
}

const SOICM = new SeriesOfIntegersCurMin([3,435,67,2,67,88,78,7878,8,88,11]);
SOICM.constructMinimumValue();
SOICM.getCurrentMinimumValue();