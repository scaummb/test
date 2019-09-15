package graph.test01;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author moubin.mo
 * @date: 2019/9/5 17:50
 */

public class Graph {
	public HashMap<Integer, Node> nodes;
	public HashSet<Edge> edges;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
