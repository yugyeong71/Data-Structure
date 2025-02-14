package queue.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS {

	private final Map<Integer, List<Integer>> graph; // 노드 번호 & 연결된 노드 리스트

	public BFS(Map<Integer, List<Integer>> graph) {
		this.graph = graph;
	}

	public List<Integer> bfs(int startNode) {
		List<Integer> result = new ArrayList<>();

		if (!graph.containsKey(startNode)) {
			System.out.println("존재하지 않는 노드입니다.");
			return result;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);

		Set<Integer> visited = new HashSet<>();
		visited.add(startNode);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			result.add(node);

			List<Integer> neighborList = graph.getOrDefault(node, new ArrayList<>());
			for (int neighbor : neighborList) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}

		return result;
	}

}
