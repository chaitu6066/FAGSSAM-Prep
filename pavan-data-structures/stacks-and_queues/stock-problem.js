class StockProblem {
    /*
        Stock problem [100,60,70,75,80,85,100]. On given day get from how many days the stock price is less?
    */
    
    constructResult(list) {
        this.result = [];
        const stack = new Stack();
        for(let i=0; i<list.length; i++) {
            const value = list[i];
            if (stack.isEmpty() || value < list[stack.top()]) {
                stack.push(i);
                this.result[i] = 1;
            } else {
                while(value > list[stack.top()]) {
                    stack.pop();
                }
                this.result[i] = i - stack.top();
            }
        }
    }
    getFromHowLongStockValueIsMin(val) {
        const resVal = this.result[val-1];
        printText(`stock value is low from past ${resVal !== 1 ? `${resVal} days` : `1 day`}`);
    }
}

const SP = new StockProblem();
SP.constructResult([100,60,70,75,80,85,100]);
// SP.constructResult([100,80,60,70,60,75,85]);
SP.getFromHowLongStockValueIsMin(3);