class ValidataSequenceOfParathesis {
    isOpenBrace(value) {
        const parathesis = ['{', '[', '(', '<'];
        return parathesis.includes(value);
    }
    isCloseBrace(value) {
        const parathesis = [ '}', ']', ')', '>'];
        return parathesis.includes(value);
    }
    forInputBraceValidOutPutBrace(value) {
        switch(value) {
            case '{': return '}';
            case '[': return ']';
            case '(': return ')';
            case '<': return '>';
            default: return '';
        }
    }
    validateSequence(input) {
        const inputAsArray = input.split('');
        const stack = new Stack();
        let isValid = true;
        for(let i=0; i<inputAsArray.length; i++ ) {
            const char = inputAsArray[i];
            if (this.isOpenBrace(char)) {
                stack.push(char)
            } else if (this.isCloseBrace(char)) {
                const validCloseBrace = this.forInputBraceValidOutPutBrace(stack.pop());
                if (validCloseBrace !== char) {
                    i = inputAsArray.length;
                    isValid = false;
                }
            } else {
                i = inputAsArray.length;
                isValid = false;
            }
        }
        if (isValid && stack.isEmpty()) {
            printText(`valid sequence -  ${input}`);
            return;
        }
        printText(`invalid sequence -  ${input}`);

    }
}

const VSOP = new ValidataSequenceOfParathesis();
VSOP.validateSequence('(({[]}))');
VSOP.validateSequence('((]}))');