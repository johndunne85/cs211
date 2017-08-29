/**
 * Created by johndunne on 29/08/2017.
 */
public class binarySearch {


    public static void main(String [] args){


        int ar[] = {1,2,5,7,8,12,16,26,45,57};

        System.out.println(search(ar, 5));

    }
    public static boolean search(int[]ar, int key){
        int lower = 0, upper = ar.length-1;
        int middle = (lower + upper)/2;

        while(lower <= upper){
            middle = (lower + upper)/2;

            if(ar[middle] == key){
                return true;
            }
            else if(key < ar[middle]){
                upper = middle -1;
            }
            else{
                lower = middle +1;
            }
        }
        return false;
    }


}
