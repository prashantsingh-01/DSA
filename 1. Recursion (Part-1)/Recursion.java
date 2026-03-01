public class Recursion{
    // Desc order
    public static void desc(int n){
        if(n==1) {
            System.out.println(n);
            return;
        };
        System.out.println(n);
        desc(n-1);
    }

    // Asce order
    public static void asce(int n){
        if(n==1) {
            System.out.println(n);
            return;
        };
        asce(n-1);
        System.out.println(n);
    }

    // Factorial
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        int fn1 = factorial(n-1);
        int fn = n * fn1;
        return fn;
    }

    // Sum of n natural nums
    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        int t1 = sum(n-1);
        int t2 = n + t1;
        return t2;
    }

    // Fibonacci
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // Check if sorted Array
    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1) return true;
        if(arr[i] > arr[i+1]) return false;

        return isSorted(arr, i+1);
    }

    // First Occurance
    public static int firstOccur(int arr[], int i, int key){
        if(i == arr.length) return -1;
        if(arr[i] == key){
            return i;
        }
        return firstOccur(arr, i+1, key);
    }

    // Last Occurance
    public static int lastOccur(int arr[], int i, int key){
        if(i == arr.length) return -1;
        int isFound = lastOccur(arr, i+1, key);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }

    // Power
    public static int pow(int n, int power){
        if(power == 0) return 1;

        // int x1 = pow(n, power-1);
        // int x2 = n * x1;    
        // return x2;
        // return n * pow(n, power-1);
        return n * pow(n, power-1);
    }
 
    public static void main(String args[]){
        int n = 5;
        int arr[] = {1,5,3,4,5};
        // desc(n);
        // asce(n);
        // System.out.println(factorial(n));
        // System.out.println(sum(n));
        // System.out.print(fibonacci(n));
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOccur(arr, 0, n));
        // System.out.println(lastOccur(arr, 0, n));
        System.out.println(pow( 2, 10));
    }
}