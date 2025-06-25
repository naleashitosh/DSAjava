import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int target = in.nextInt();
        
        int[][] arr = {{2,4,8,11},
                        {14,23,28,32},
                        {35,38,42,47},
                        {53,59,62,75}};
                        
        int[] ans = binarySearchsorted(arr,target);
        System.out.print(Arrays.toString(ans));
    }
    static int[] binarySearchsorted(int[][] arr, int target){
        int rStart = 0;
        int rEnd = arr.length-1;
        int rmid = rStart + (rEnd - rStart)/2;
        
        
        while(rStart< rEnd){
            int cStart = 0;
            int cEnd = arr[rmid].length-1;
            int cmid = cStart + (cEnd - cStart)/2;
            rmid = rStart + (rEnd - rStart)/2;
            if(target == arr[rmid][cmid]){
                return new int[]{rmid,cmid};
            }
            else if(target > arr[rmid][cmid]){
                rStart = rmid;
            }
            else{
                rEnd = rmid;
            }
            if (rStart == rEnd-1){
                if(target == arr[rmid][cmid]){
                    return new int[]{rmid,cmid};
                }
                else if(target < arr[rEnd][0]){
                    return binarySearch(arr[rStart], target,rStart);
                }
                else{
                    return binarySearch(arr[rEnd], target,rEnd);
                }
            }
        }
        
        return  new int[]{-1,-1};
    }
    
    static int[] binarySearch(int[] arr, int target,int r){
        int start = 0;
        int end = arr.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(arr[mid] == target){
                return new int[]{r,mid};
            }
            else if(arr[mid]< target){
                start = mid + 1;
            }
            else{
                end = mid-1;
            }
            
        }
        return new int[]{-1,-1};
    }

} 
