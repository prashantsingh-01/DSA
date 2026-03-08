public class Recursion {
    // Tiling Problem
    public static int tilingProblem(int n){ // floor size is 2 * n
        if(n == 0 || n == 1) return 1;

        // Vertical Choice
        int fn1 = tilingProblem(n-1);
        // Horizontal Choice
        int fn2 = tilingProblem(n-2);
        int total = fn1 + fn2;
        return total;
    }

    // Remove duplicate from String
    public static void removeDuplicates(String str, int  idx, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        // Kaam
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            // Duplicate
            removeDuplicates(str, idx+1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int friendsPairing(int n){
        if(n==1 || n==2) return n;
        // Choice
        // Single
        // int fnm1 = friendsPairing(n-1);
        // // Pair
        // int fnm2 = friendsPairing(n-2);
        // int pairWays = (n-1) * fnm2;
        // // totways
        // int totways = fnm1 + pairWays;
        // return totways;

        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    public static void printBinStrings(int n, int lastPlace, StringBuilder str){
        // base case
        if(n==0){
            System.out.println(str);
            return;
        }
        // Kaam
        printBinStrings(n-1, 0, str.append("0"));
        if(lastPlace == 0){
            printBinStrings(n-1, 1, str.append("1"));
        }
    }

    public static void main(String[] args) {
        // System.out.println(tilingProblem(4));
        // removeDuplicates("prashant", 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(friendsPairing(3));
        printBinStrings(3, 0, new StringBuilder(""));
    }
}