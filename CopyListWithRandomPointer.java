/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 /*
 *解法思路：将新建的节点放在同一张链表上，比如：a->b->null
 *可以复制成：a->A->b->B->null
 *然后A->random = a->random->next
 *最后再将链表拆分开来
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return head;
        }
        RandomListNode rOld = head;
        RandomListNode rNew = head;
        while(rOld != null){
            rNew = new RandomListNode(rOld.label);
            rNew.next = rOld.next;
            rOld.next = rNew;
            rOld = rNew.next;
        }
        rOld = head;
        rNew = rOld.next;
        RandomListNode newNode = rNew;
        while(rNew.next != null){
            if(rOld.random != null){
                rNew.random = rOld.random.next;
            }else {
                rNew.random = null;
            }
            rOld.next = rNew.next;
            rOld = rNew.next;
            rNew.next = rOld.next;
            rNew = rNew.next;
        }
        rOld.next = null;
        return newNode;
    }
}
