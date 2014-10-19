/*
  使用的是递归方式来比较字符串，回溯的方式来实现
  但不是最优解
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean flag = false;
        for(int i=0; i<len; i++){
            String subStr = s.substring(0,i);
            if(dict.contains(subStr)){
                if(subStr.length() == len){
                    return true;
                }else {
                    flag = wordBreak(s.substring(i),dict);
                }
            }
        }
        return flag;
    }
}
