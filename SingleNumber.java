/*
*Given an array of integers, every element appears twice except for one. Find that single one
*对A中的元素进行异或运算，最后剩下的就是只出现一次的数字
*/
public class Solution {
    public int singleNumber(int[] A) {
        int num = A[0];
        for(int i=1;i<A.length;i++){
            num = num^A[i];
        }
        return num;
    }
}
