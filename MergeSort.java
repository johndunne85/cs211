/**
 * Created by johndunne on 29/08/2017.
 */
public class MergeSort {

    public static void main(String[] args){

    int ar[] = {12,34,6,2,1,7,56,32,9};
    int workspace[] = new int[ar.length];
    mergesort(ar, workspace, 0,ar.length-1);

    for(Integer x : ar){
        System.out.print(x+" ");
    }




    }
    public static void mergesort(int[]ar, int[] workspace, int lower, int upper){
        if(lower == upper){
            return;
        }
        else{
            int mid = (lower + upper)/2;

            mergesort(ar, workspace, lower, mid);
            mergesort(ar, workspace, mid+1,upper);

            stitch(ar, workspace,lower, upper);
        }
    }

    public static void stitch(int[]ar, int[]workspace, int lower, int upper){
        int j=0; // counter for workspace array

        int mid = (upper + lower)/2;

        int first = lower, second = mid+1;

        int n = upper - lower+1;

        while(first <= mid && second<=upper){ // keep doing this until first or second in empty
            if(ar[first] < ar[second]){
                workspace[j] = ar[first];
                j++;
                first++;
            }
            else{
                workspace[j] = ar[second];
                j++;
                second++;
            }

        }

        while(first <= mid){
            workspace[j] = ar[first]; // fill up workspace array with what is left in first half
            j++;
            first++;
        }

        while(second <= upper){
            workspace[j] = ar[second];// fill up workspace array with what is left in second half
            j++;
            second++;
        }

        for(j=0;j<n;j++){
            ar[lower +j] = workspace[j]; // copy workspace array into original array
        }
    }
}
