package graph.test01;

/**
 * @author moubin.mo
 * @date: 2019/9/5 17:49
 */

public class test1 {
	public static void main(String[] args){



	}

	// 图的生成
	public static Graph createGraph(Integer[][] matrix){
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++){
			Integer weight = matrix[i][0];
			Integer from = matrix[i][1];
			Integer to = matrix[i][2];

			if (!graph.nodes.containsKey(from)){
				graph.nodes.put(from, new Node(from));
			}

			if (!graph.nodes.containsKey(to)){
				graph.nodes.put(to, new Node(to));
			}

			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);

			Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);

		}

		return graph;
	}

	// 图的清空

}

