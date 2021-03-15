package graph.test01;

/**
 * 图的边
 *
 * @author moubin.mo
 * @date: 2019/9/5 17:51
 */

public class Edge {
	/**
	 * 权重
	 */
	public int weight;
	/**
	 * 起始节点
	 */
	public Node from;
	/**
	 * 结束节点
	 */
	public Node to;

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}
}
