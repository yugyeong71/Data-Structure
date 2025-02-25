package queue.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 큐(Queue)를 활용한 BFS 알고리즘 예제
 */
public class MainBFS {

	private final Map<Integer, List<Integer>> graph = new HashMap<>();

	public static void main(String[] args) throws IOException {
		MainBFS mainBFS = new MainBFS();
		mainBFS.init();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("탐색을 시작할 노드 : ");
		int startNode = Integer.parseInt(br.readLine().trim());

		BFS bfs = new BFS(mainBFS.graph);
		List<Integer> bfsResult = bfs.bfs(startNode);

		if (!bfsResult.isEmpty()) {
			System.out.print("BFS 탐색 순서 : ");
			System.out.println(bfsResult);
		}

		mainBFS.printGraph();
	}

	/**
	 * 그래프 정보 입력
	 */
	private void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("간선 개수 : ");
		int edgeCount = Integer.parseInt(br.readLine().trim());

		System.out.println("간선 데이터 :");
		for (int i = 0; i < edgeCount; i++) {
			String[] edgeData = br.readLine().trim().split(" ");
			int from = Integer.parseInt(edgeData[0]);
			int to = Integer.parseInt(edgeData[1]);

			graph.putIfAbsent(from, new ArrayList<>()); // from 이 존재하지 않는 경우, 리스트 생성
			graph.get(from).add(to); // 해당 from 에 to 추가
		}
	}

	private void printGraph() {
		System.out.println("\n그래프 구조 : ");
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

}
