import java.io.FileInputStream;

public class Q1_2016 {
int FirstFloortofallFrom=0;
    int [] arr;
    int a;
    int count=0;
    public Q1_2016(int []arr,int a ) {
        this.arr=arr;//deem copy
        this.a=a;
    }
   public int Check(){
        return count;
   }
   public int First(){
        return FirstFloortofallFrom;
   }

    private int binarySearch(int low,int high ){

        int mid=(low+high)/2;
        if((mid==low)||(mid==high)){
            count++;
            FirstFloortofallFrom=mid;
            return mid;}
        if (arr[mid]>a){
            count++;return binarySearch(low,mid);}
        if(a>arr[mid]){
            count++;return binarySearch(mid,high);
        }
        if (arr [mid]==a){
            count++;FirstFloortofallFrom=mid;return mid;
        }

       return 0;
    }
    public int numberOfBreaks(){
        FirstFloortofallFrom=0;
        count=0;
        int low =0;
        int high=arr.length-1;
        int index=binarySearch(low,high);
        return high-index;

    }

}
