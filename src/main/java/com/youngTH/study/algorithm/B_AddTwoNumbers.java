package com.youngTH.study.algorithm;

/**
 * @author YoungTH
 * @date 2019/5/7
 */
public class B_AddTwoNumbers {


    public static void main(String[] args) {

    }
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example:
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p=l1,q=l2,temp=result;
        int flag=0;
        while(p!=null||q!=null||flag!=0){
            int x=p!=null?p.val:0;
            int y=q!=null?q.val:0;
            int sum=flag+x+y;
            flag=sum/10;
            sum=sum%10;
            temp.next=new ListNode(sum);
            temp=temp.next;
            p=p!=null?p.next:p;
            q=q!=null?q.next:q;
        }
        if(p!=null){
            temp.next=p;
        }
        if(q!=null){
            temp.next=q;
        }
        return result.next;
    }


//
//    class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            ListNode dummyHead = new ListNode(0);
//            ListNode p = l1, q = l2, curr = dummyHead;
//            int carry = 0;
//            while (p != null || q != null) {
//                int x = (p != null) ? p.val : 0;
//                int y = (q != null) ? q.val : 0;
//                int sum = carry + x + y;
//                carry = sum / 10;
//                curr.next = new ListNode(sum % 10);
//                curr = curr.next;
//                if (p != null) {
//                    p = p.next;
//                }
//                if (q != null) {
//                    q = q.next;
//                }
//            }
//            if (carry > 0) {
//                curr.next = new ListNode(carry);
//            }
//            return dummyHead.next;
//        }
//    }

    public  class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



}
