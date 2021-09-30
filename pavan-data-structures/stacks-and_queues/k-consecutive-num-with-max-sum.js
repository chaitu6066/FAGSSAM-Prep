class KConsecutiveNumWithMaxSum {
    /*
        In the given list get k consecutive numbers which sum be larger?
    */

    constructor(list) {
        this.list = list;
    }
    
    getMaxSumOfCount(kNum) {
        let maxSum = 0;
        let count = kNum;
        for (let i=0; i<this.list.length; i++) {
            if (count > 0) {
                count--;
                maxSum += this.list[i];
            } else {
                const newSum = maxSum - this.list[i-kNum] + this.list[i];
                if (newSum > maxSum) {
                    maxSum = newSum;
                }
            }
        }
        printText(`Max sum of ${kNum} consecutive numbers in the list ${this.list} is ${maxSum}`);
    }
}

const KCNWM = new KConsecutiveNumWithMaxSum([1,2,3,4,5,6,7,8,9]);
KCNWM.getMaxSumOfCount(3);