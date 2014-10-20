/*
*question:here are N gas stations along a circular route, where the amount of gas at station i is gas[i].
*You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
*You begin the journey with an empty tank at one of the gas stations.
*Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
*/
/*solution 1: 依次遍历节点，判断是否满足条件，提交超时*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        for(i=0; i<length; i++){
            sum = 0;
            do{
                sum += gas[i] - cost[i];
                if(sum < 0){
                    break;
                }
                j=(i+1)%length;
            }while(j != i);
            if(j == i){
                return i;
            }
        }
        return -1;
    }
}

/* solution2 :设置一个全局的数存储用于判断最后能不能走完全程 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int sum = 0;
        int total = 0;
        int index = -1;
        for(int i=0;i<length;i++){
            sum += gas[i]-cost[i];
            total += gas[i]-cost[i];
            if(sum < 0){
                index = i;
                sum = 0;
            }
        }
        if(total < 0){
            return -1;
        }
        return index+1;
    }
}
