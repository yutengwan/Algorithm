/*
  思路：先通过快慢指针判断是否有环(是否相遇)
  然后通过计算可以得出：
  假设：出发点(X)到环的入口(Y)的距离为a,相遇点(Z)
  X-Y：a，Y-Z：b，Z-X：c
  慢指针相遇走的距离为：a+b;
  快指针走的距离为：a+b+c+b;
  则有公式：2(a+b) = a+b+c+b
  则：a=c
  则可以得出：Z-Y的距离等于X-Y的距离
  所以可以有两个指针同时从X，Z出发，相遇的地方就是环的入口

*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //用快慢指针判断是否有环
        while(true){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        //将快慢指针变换找到环的入口点
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        
    }
}
