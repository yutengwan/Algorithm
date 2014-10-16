/*
* 查找出最小的值，在旋转有序的数组中
*/
public class Solution {
    public int findMin(int[] num) {
        int counter = num.length;
        if(counter == 1){
            return num[counter-1];
        }
        int start = 0;
        int end = counter-1;
        while(start<end){
            int mid = (start+end)/2;
            if(num[mid]<num[end]){            //判断是在左半部分还是右半部分
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return num[start];
    }
}
