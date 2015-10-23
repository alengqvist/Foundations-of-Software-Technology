package al223bn;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;


public class MyDFS<E> implements DFS<E> {
	
	private List<Node<E>> collected = new LinkedList<Node<E>>();
	private Set<Node<E>> visited = new HashSet<Node<E>>();
	private int depthNumber = 0;
	private int postOrderNumber = 0;
	
	private void reset() {
		visited.clear();
		collected.clear();
	}
	
	private void dfs(Node<E> node) {
		node.num = depthNumber++;
		visited.add(node);
		collected.add(node);
		Iterator<Node<E>> it = node.succsOf();
		while (it.hasNext()) {
			Node<E> successor = it.next();
			if (!visited.contains(successor)) {
				dfs(successor);
			}
		}
	}

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
		reset();
		dfs(root);
		return collected;
	}

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {	
		reset();
		for (Node<E> node : graph) {
			if (!visited.contains(node)) {
				dfs(node);
			}
		}
		return collected;
	}

	private void postOrder(Node<E> node) {
		visited.add(node);
		Iterator<Node<E>> it = node.succsOf();
		while (it.hasNext()) {
			Node<E> successor = it.next();
			if (!visited.contains(successor)) {
				postOrder(successor);
			}
		}	
		node.num = postOrderNumber++;
		collected.add(node);
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
		reset();
		postOrder(root);
		return collected;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		reset();
		for (Iterator<Node<E>> it = g.iterator(); it.hasNext();) {
			Node<E> node = it.next();
			if (!visited.contains(node)) {
				postOrder(node);
			}
		}
		return collected;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
		reset();
		for (Node<E> node : g) {
			if (attach_dfs_number) {
				node.num = depthNumber++;
				postOrder(node);
			} else{
				postOrder(node);
			}
		}
		return collected;
	}

	@Override
	public boolean isCyclic(DirectedGraph<E> graph) {
		for (Node<E> node : postOrder(graph)) {
			for (Iterator<Node<E>> it = node.succsOf(); it.hasNext();) {
				if (node.num <= it.next().num) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Node<E>> topSort(DirectedGraph<E> graph) {
		List<Node<E>> list = postOrder(graph);
		Collections.reverse(list);
		return list;
	}
}