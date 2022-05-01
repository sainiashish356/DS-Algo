public class quicksort {
    
    public static void QuickSort(int[] input,int si, int ei){
        if(si >= ei){
            return;
        }

        int pivotPos = partition(input,si,si);
        QuickSort(input, si, pivotPos-1);
        QuickSort(input, pivotPos+1, ei);

    }

    private static int partition(int[] input, int si, int ei) {

        //lets assume that first element is out pivot 
        int pivot = input[si];
        int count = 0;
        for(int i =si + 1; i <= ei;i++){
            if(input[i] <= pivot ){
                count++;
            }
        }
        //now we got count of smaller elements
        int pivotPos = si + count;
        //now we put swap to its correct pos
        int temp = input[pivotPos];
        input[pivotPos] = input[si];
        input[si] = temp;

        //now we initialize two pointer to sort 
        int i = si;
        int j = ei;
        //we put j at end and i at first to check them
        while(i < pivotPos && j > pivotPos){
            if(input[i] <= pivot){
                i++;
            }else if(input[j] > pivot){
                j--;
            }else{
                //we came here when both i and j has wrong elem and now we swap
                temp = input[i];
                input[i]= input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        return pivotPos;

    }

}
