public class mergesort {
    
    public static void mergeSort(int[] arr){
        if(arr.length <= 1){
            return;
        }

        int mid = arr.length/2;
        //now we make 2 arrays
        int[] part1 = new int[mid];
        int[] part2 = new int[arr.length-mid];

        //now we copy elements in both arrays
        for(int i = 0; i < mid;i++){
            part1[i] = arr[i];
        }
        int k = 0;
        for(int i = mid; i < arr.length;i++){
            part2[k] = arr[i];
            k++;
        }

        mergeSort(part1);
        mergeSort(part2);
        merge(part1,part2,arr);

    }

    private static void merge(int[] part1, int[] part2, int[] arr) {
        int i =0 , j =0, k=0;

        //now we compare both part1 and part2 and place them in origial array
        while(i < part1.length && j < part2.length){
            if(part1[i] <= part2[j]){
                arr[k] = part1[i];
                i++;
                k++;
            }else{
                arr[k] = part2[j];
                j++;
                k++;
            }
        }
        //At some point if one list gonna empty and other list contain elements in it now we put them in original array
        if(i < part1.length){
            while(i < part1.length){
                arr[k] = part1[i];
                i++;
                k++;
            }
        }
        if(j < part2.length) {
			while(j < part2.length) {
				arr[k] = part2[j];
				j--;
				k++;
			}
		}

    }

}
