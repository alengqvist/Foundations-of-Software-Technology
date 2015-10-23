package al223bn;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;


public class MyTransitiveClosure<E> implements TransitiveClosure<E> {

	private Map<Node<E>, Collection<Node<E>>> hashmap = new LinkedHashMap<Node<E>, Collection<Node<E>>>();
    private Set<Node<E>> visited  = new HashSet<Node<E>>();
    private Set<Node<E>> connected  = new HashSet<Node<E>>();
    private int depthNumber;

	@Override
	public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
		hashmap.clear();
		connected.clear();

		for (Node<E> node : dg) {
			visited = new HashSet<Node<E>>();
			connect(node);
			hashmap.put(node, visited);
		}

		return hashmap;
	}

	private void connect(Node<E> node) {
		node.num = depthNumber++;
        visited.add(node);
		
        Iterator<Node<E>>  it = node.succsOf();		        
        while (it.hasNext()) {
			Node<E> successor = it.next();
			if (!visited.contains(successor)) {
				connect(successor);
			}
		}        
	}

//	private void strongConnect(Node<E> node) {
//
//		node.num = depthNumber;
//		node.low = depthNumber;
//		depthNumber++;
//		stack.push(node);
//		visited.add(node);
//		for (Iterator<Node<E>> it = node.succsOf(); it.hasNext();) {
//			Node<E> successor = it.next();
//			if (!visited.contains(successor)) {
//				strongConnect(successor);
//				node.low = Math.min(node.low, successor.low);
//			} else if (stack.contains(successor)) {
//				node.low = Math.min(node.low, successor.num);
//			}
//		}
//			
//		if (node.low == node.num) {
//			scc = new LinkedList<Node<E>>();
//			Node<E> n;
//			
//			do {
//				n = stack.pop();
//				connected.add(n);
//				scc.add(n);
//			} while (n != node);
//			
//			strongly.add(scc);
//		}
//	}
}