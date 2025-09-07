package searches;
public class Binary_Search{
    public static int binarySearch(int numbers[],int key){
        int start=0,end=numbers.length-1;

        while(start<=end){
            int mid=(start+end)/2;

            if(numbers[mid]==key){
                return mid;
            }
            //comparisons
            if(numbers[mid]<key){//right
                start=mid+1;
            }
            else{//left
                end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int number[]={1,2,3,4,5,5,5,6,8};
        int key=2;
        System.out.println(binarySearch(number,key));
    }
}