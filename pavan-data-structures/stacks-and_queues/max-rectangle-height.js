class MaxRectangleArea {
    /*
        max Rectangle area of given reactangles with height [4,2,10,11,4,3] problem?
        assume width as 1
    */
    
    constructResultWithBruteForce(list) {
        this.result;
        let left = 0;
        let right = 0;
        let maxValue = 0;
        const stack = new Stack();
        console.log(list);
        for(let i=0; i<list.length; i++) {
            const value = list[i];
            let j = i - 1;
            while(j > 0 && value < list[j]) {
                j--;
            }
            left = j + 1;

            j = i + 1;
            while(j < list.length && value < list[j]) {
                j++;
            }
            right = j - 1;
            console.log(left,right);
            const mayBeMax = (right - left + 1) * value;
            console.log(mayBeMax);
            if (maxValue < mayBeMax) {
                maxValue = mayBeMax;
            }
        }
        
        console.log(maxValue);
    }

    constructResult(list) {
        this.result;
        const stack = new Stack();
        for(let i=0; i<list.length; i++) {
            
        }
        console.log(this.result);
    }
    getMaxArea(val) {
        printText(`stock value is low from past ${resVal !== 1 ? `${resVal} days` : `1 day`}`);
    }
}

const MRA = new MaxRectangleArea();
MRA.constructResultWithBruteForce([4,2,10,11,4,3]);
// MRA.constructResult([100,60,70,75,80,85,100]);
// MRA.getMaxArea();