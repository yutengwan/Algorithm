/*
*["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
*["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i=0;i<tokens.length;i++){
            char [] num = tokens[i].toCharArray();
            int num1=0,num2=0;
            boolean isNum = true;
            for(int j=0;j<num.length;j++){
                if(num[0] == '-' && num.length>1){                  //判断'-'号，负数
                    continue;
                }
                if(!Character.isDigit(num[j])){
                    isNum = false;
                }
            }
            if(isNum){
                stack.push(Integer.parseInt(tokens[i]));
            }else {
                switch(num[0]){
                    case '+':
                        num1 = stack.pop();
                        num2 = stack.pop();
                        stack.push(num2+num1);
                        break;
                    case '-':
                        num1 = stack.pop();
                        num2 = stack.pop();
                        stack.push(num2-num1);
                        break;
                    case '/':
                        num1 = stack.pop();
                        num2 = stack.pop();
                        stack.push(num2/num1);
                        break;
                    case '*':
                        num1 = stack.pop();
                        num2 = stack.pop();
                        stack.push(num2*num1);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }
}
