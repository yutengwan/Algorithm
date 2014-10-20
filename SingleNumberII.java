/*Given an array of integers, every element appears three times except for one. 
*Find that single one.
*先对数组排序，然后找出出现一次的数
*/
public class Solution {
    public int singleNumber(int[] A) {
        Arrays.sort(A);
        int j=1;
        for(int i=0;i<A.length-1;i++){
            if(A[i] == A[i+1]){
                j++;
            }else {
                if(j<3){
                    return A[i];
                }
                j=1;
            }
        }
        return A[A.length-1];
    }
}
