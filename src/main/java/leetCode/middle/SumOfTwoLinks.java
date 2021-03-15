package leetCode.middle;

/**
 * leetCode:middle 2 两数相加
 *
 * @author moubin.mo
 * @date: 2019/9/4 16:59
 */

public class SumOfTwoLinks {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1, l2);

		while (result != null) {
			System.out.print(result.val);
			result = result.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		// 双指针
		ListNode l4 = new ListNode(0);
		ListNode l3 = l4;

		// 进位标志
		int flag = 0;

		// 位运算
		while (l1 != null || l2 != null) {

			// 求和
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			int sum = val1 + val2 + flag;

			// 计算进位
			flag = sum / 10;
			sum = sum % 10;

			// 创建新节点
			l3.next = new ListNode(sum);

			// 将游标值设置进目标链表
			l3 = l3.next;
			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;

		}

		// 设置最高位元素
		if (flag > 0) {
			l3.next = new ListNode(flag);
		}

		return l4.next;
	}

}

/**
 * 一个节点
 */
class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}
}