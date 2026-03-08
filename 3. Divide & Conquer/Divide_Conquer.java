public class Divide_Conquer{
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }

        // Kaam
        int mid = si+(ei - si) / 2; //(si+ei)/2
        mergeSort(arr, si, mid); //left part
        mergeSort(arr, mid+1, ei); //right part
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[], int si, int mid, int ei){
        //left(0,3)=4 right(4,6)=3 -> 6-0+1
        int temp[] = new int[ei-si+1];
        int i = si; //iterator for left part
        int j = mid+1; //iterator for right part
        int k = 0; //interator for temp arr

        while(i<=mid && j<=ei){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        // left part
        while(i<=mid){
            temp[k++] = arr[i++];
        }

        // right part
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        // Copy temp to orginal arr
        for(k=0,i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei){
        if(si>=ei) return;
        // last element
        partition(arr, si, ei);
        int pidx = partition(arr, si, ei);
        quickSort(arr, si, pidx-1); //left
        quickSort(arr, pidx+1, ei); //right
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1; //to make place for elements smaller then pivot

        for(int j=0; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                // Swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i]; //pivot = arr[i]
        arr[i] = temp;
        return i;
    }

    public static int search(int arr[], int target, int si, int ei){
        if(si>ei) return -1;

        // Kaam
        int mid = si+(ei - si) / 2;

        // Case
        if(arr[mid] == target) return mid;

        // Mid lie on L1
        if(arr[si]<= arr[mid]){
            // Case a : Left
            if(arr[si] <= target && target <= arr[mid]){
                return search(arr, target, si, mid);
            }
            // Case b : Right
            else {
                return search(arr, target, mid+1, ei);
            }
        }
        // Mid lie on L2
        else {
            // Case c : right
            if(arr[mid]<= target && target <= arr[ei]){
                return search(arr, target, mid+1, ei);                
            } else {
            // Case d : left
                return search(arr, target, si, mid);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 1, 2, 3};
        int target = 5;
        // mergeSort(arr, 0, arr.length-1);
        // quickSort(arr, 0, arr.length-1);
        System.out.println(search(arr, target, 0, arr.length-1));
        // printArr(arr);
        
    }
}