/*
*Given a string s, partition s such that every substring of the partition is a palindrome.
*Return all possible palindrome partitioning of s.
*/

/*
*solution:递归实现
*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<List<String>>();
        if(s.length() <=0 || s==null){
            return list;
        }
        ArrayList<String> partition = new ArrayList<String>();
        addPalindrome(s,0,partition,list);
        return list;
        
    }
    public void addPalindrome(String s,int start,List<String> partition,List<List<String>> result){
        if(start == s.length()){
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }
        for(int i= start+1; i<=s.length();i++){
            String str = s.substring(start,i);
            if(isPalindrome(str)){
                partition.add(str);
                addPalindrome(s,i,partition,result);
                partition.remove(partition.size()-1);
            }
        }
    } 
    
    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    } 
}

