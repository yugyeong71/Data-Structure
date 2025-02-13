package queue.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS {

	private final Map<Integer, List<Integer>> graph;

	public BFS(Map<Integer, List<Integer>> graph) {
		this.graph = graph;
	}

	public void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);

		Set<Integer> visited = new HashSet<>();
		visited.add(startNode);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			List<Integer> neighborList = graph.getOrDefault(node, new ArrayList<>());
			for (int neighbor : neighborList) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
	}

}
