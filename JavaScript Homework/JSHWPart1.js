// Travis Williamson - JavaScript Homework Part One - 7/14/19

let homework = {};

/*
 1. Return the nth Fibonacci number
`x`
 f(0) = 0
 f(1) = 1
 f(10) = 55 
*/

function fibonacci (n){
    let m = n -1;
    let l = n-2;
    if (n <= 1) {
        return n;
    } return fibonacci(m) + fibonacci(l);
}

homework.fibonacci = fibonacci;

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/

function sort(array) {
    
    for (i = 0; i < array.length; i++) {
        for(j = i + 1; j < array.length; j++) {
            if(array[i] > array[j]) {
                let temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    return array;
}

homework.sort = sort;

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/

function factorial(n){
    if (n <= 1) {
        return n;
    } return n * factorial(n-1);
};

homework.factorial = factorial;

/*


 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/

function rotateLeft(array, n) {
    let x = 0;
    while(x < n) {
        tempFirst = array[0];
        for(i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1]
        }
        array[array.length-1] = tempFirst;
        x++;
    }
    return array;
}

homework.rotateLeft = rotateLeft;

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/

function balancedBrackets(bracketsString) {
    if(bracketsString.length % 2 != 0) {
        return false;
    }

    for (i = 0; i < bracketsString.length / 2; i++) {
        j = bracketsString.length - (i + 1);

        if(bracketsString.charAt(i) == "(") {
            if(bracketsString.charAt(j) != ")") {
                return false;
            }
        } else if(bracketsString.charAt(i) == "{") {
            if(bracketsString.charAt(j) != "}") {
                return false;
            }
        } else if(bracketsString.charAt(i) == "[") {
            if(bracketsString.charAt(j) != "]") {
                return false;
            }
        }
    }
    return true;
}

homework.balancedBrackets = balancedBrackets;

