/*question：There are N children standing in a line. Each child is assigned a rating value.
*You are giving candies to these children subjected to the following requirements:
*Each child must have at least one candy.
*Children with a higher rating get more candies than their neighbors.
*What is the minimum candies you must give?
*
*solution: 初始化所有小孩糖数目为1，
*从前往后扫描，如果第i个小孩等级比第i-1个高，那么i的糖数目等于i-1的糖数目+1；
*从后往前扫描，如果第i个的小孩的等级比i+1个小孩高,但是糖的数目却小或者相等，
*那么i的糖数目等于i+1的糖数目+1。
*第一次扫描保证i节点比它左边的满足条件
*第二次扫描保证i节点比它右边的满足条件
*这样就保证两边都满足条件了
*/

public class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int [] a = new int[length];
        for(int i=0;i<length;i++){
            a[i] = 1;
        }
        for(int i=1;i<length;i++){
            if(ratings[i] > ratings[i-1]){
                a[i] = a[i-1]+1;
            }
        }
        for(int i=length-2;i>=0; i--){
            if(ratings[i]>ratings[i+1] && a[i]<=a[i+1]){
                a[i] = a[i+1]+1;
            }
        }
        int sum = 0;
        for(int i=0; i<length; i++){
            sum += a[i];
        }
        return sum;
    }
}
