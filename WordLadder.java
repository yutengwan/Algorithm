/*
*Given two words (start and end), and a dictionary, 
*find the length of shortest transformation sequence from start to end, such that:
*Only one letter can be changed at a time
*Each intermediate word must exist in the dictionary
*/
/*类似于树的结构遍历，依次对其进行修改字符*/
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(dict.size() == 0){
            return 0;
        }
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> disQueue = new LinkedList<Integer>();
        wordQueue.add(start);
        disQueue.add(1);
        while(!wordQueue.isEmpty()){
            String curWord = wordQueue.pop();
            int curStep = disQueue.pop();
            if(curWord.equals(end)){
                return curStep;
            }
            for(int i=0;i<curWord.length();i++){
                char [] curChar = curWord.toCharArray();
                for(char c='a';c<='z';c++){
                    curChar[i] = c;
                    String newWord = new String(curChar);
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        disQueue.add(curStep+1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
