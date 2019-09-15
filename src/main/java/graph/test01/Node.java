package graph.test01;

import java.util.ArrayList;

/**
 * 图的节点
 *
 * @author moubin.mo
 * @date: 2019/9/5 17:51
 */

public class Node {
	public int value;
	public int in;
	public int out;
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
