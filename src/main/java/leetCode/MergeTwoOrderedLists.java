package leetCode;

/**
 * Date: 2019/5/8 12 :21
 *
 * @author moubin.mo
 * @todo 将两个有序链表合并为一个新的有序链表并返回。
 */

public class MergeTwoOrderedLists {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next= new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next= new ListNode(4);
        System.out.println("l1="+l1+"  l2="+l2);
        ListNode l3 = mergeTwoLists(l1, l2);
        System.out.println("l3="+l3);

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1.l3取l1的首结点
        ListNode head = new ListNode(0);
        ListNode cur = head;

        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1 != null && l2 != null){


            // 2.l2或者l1的结点都不为空
            while (l2 != null || l1 != null){

                if (l1.val < l2.val){
                    cur.next = l1;  //l1首元素地址赋值给cur指向的next元素
                    cur = cur.next; //cur也指向next元素
                    l1 = l1.next;
                }else {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }

                // 3.任意一条链表为空时，直接连接另外一条即可
                if (l1 == null){
                    cur.next = l2;
                    break;
                }

                if (l2 == null){
                    cur.next = l1;
                    break;
                }
            }

        }

        return head.next;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode() {
    }
};