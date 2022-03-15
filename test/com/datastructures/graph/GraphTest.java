package com.datastructures.graph;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraphTest {

	private Graph<Integer> graph;
	
	@BeforeEach
	public void setUp() {
		graph = new Graph<Integer>();
		for(int i=0;i<=3;i++) {
			graph.addVertex(i);
		}
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
	}
	
	
	
	@Test
	public void createdGraph() {
		assertTrue("Difference in expected value",4 == graph.graphSize());
		graph.bfs(2);
		graph.dfs(2);
	}
}
