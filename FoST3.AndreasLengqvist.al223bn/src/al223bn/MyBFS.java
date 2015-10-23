package al223bn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;


public class MyBFS<E> implements BFS<E> {

    private Set<Node<E>> visited = new HashSet<Node<E>>();
    private List<Node<E>> collected = new LinkedList<Node<E>>();
	private Queue<Node<E>> queue = new LinkedList<Node<E>>();
	private int breadthNumber = 0;

	private void reset() {
		visited.clear();
		collected.clear();
	}
	
	private void bfs(Node<E> root) {
		
	    visited.add(root);
	    queue.add(root);
	    
	    while(!queue.isEmpty()) {
	        Node<E> n = queue.remove();
        	collected.add(n);
        	n.num = breadthNumber++;
        	
			for (Iterator<Node<E>> it = n.succsOf(); it.hasNext();) {
	        	Node<E> s = it.next();
	        	if (!visited.contains(s)) {
		        	visited.add(s);
		        	queue.add(s);
	        	}
	        }
	    }
	}
	
	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
		reset();
		queue.clear();
		bfs(root);
	    return collected;
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph) {
		reset();
		for (Node<E> root : graph) {
			queue.clear();
			if (!visited.contains(root)) {
				bfs(root);
			}
		}
		return collected;
	}
}