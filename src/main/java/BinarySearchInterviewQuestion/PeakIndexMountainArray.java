package BinarySearchInterviewQuestion;

public class PeakIndexMountainArray {
        public int peakIndexInMountainArray(int[] arr) {
            int start = 0 ;
            int end = arr.length-1;
            while(start<end){
                int mid = start + (end-start)/2;
                if(arr[mid]>arr[mid+1]){
                    //you are on descending side
                    //this may be answer but look left
                    //thswy end!=mid-1; //can be answer

                    end  =  mid;
                }else{
                    start = mid +1;
                }
            }
            return start;  //or end both at max index
        }

}
