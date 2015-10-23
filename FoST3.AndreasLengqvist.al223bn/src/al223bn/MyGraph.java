package al223bn;

import graphs.DirectedGraph;
import graphs.Node;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MyGraph<E> implements DirectedGraph<E> {
	
	private Map<E, Node<E>> graph;
	private Set<Node<E>> heads;
	private Set<Node<E>> tails;
	
	public MyGraph() {
		graph = new LinkedHashMap<>();
		heads = new HashSet<>();
		tails = new HashSet<>();
	}
	
	@Override
	public Node<E> addNodeFor(E item) {
		if (item == null) {
			throw new NullPointerException("Couldn't add Node. Input was null!");
		}
		
		Node<E> node = graph.get(item);
		if (node == null) {
			node = new MyNode<E>(item);
			tails.add(node);
			heads.add(node);
			graph.put(item, node);
			return node;		
		}
		return node;	
	}

	@Override
	public Node<E> getNodeFor(E item) {
		if (item == null) {
			throw new NullPointerException("Couldn't get Node. Input was null!");
		}
		
		Node<E> node = graph.get(item);
		if (node == null) {
			throw new NullPointerException("Couldn't get Node. Node doesn't exist!");
		}
		return node;
	}

	@Override
	public boolean addEdgeFor(E from, E to) {
		if (from == null || to == null) {
			throw new NullPointerException("Couldn't add Edge. Input was null!");
		}
		
		MyNode<E> src = (MyNode<E>) addNodeFor(from);
		MyNode<E> tgt = (MyNode<E>) addNodeFor(to);
		
		if (src.hasSucc(tgt)) {
			return false;
		} else {
			src.addSucc(tgt);
			tgt.addPred(src);
			tails.remove(src);
			heads.remove(tgt);
			return true;
		}
	}

	@Override
	public boolean containsNodeFor(E item) {
		if (item == null) {
			throw new NullPointerException("Couldn't check if contains. Input was null!");
		}
		return graph.containsKey(item);
	}

	@Override
	public int nodeCount() {
		return graph.size();
	}

	@Override
	public Iterator<Node<E>> iterator() {
		return graph.values().iterator();
	}

	@Override
	public Iterator<Node<E>> heads() {
		return heads.iterator();
	}

	@Override
	public int headCount() {
		return heads.size();
	}

	@Override
	public Iterator<Node<E>> tails() {
		return tails.iterator();
	}

	@Override
	public int tailCount() {
		return tails.size();
	}

	@Override
	public List<E> allItems() {
		return new LinkedList<E>(graph.keySet());
	}

	@Override
	public int edgeCount() {
		int count = 0;
		for (Node<E> node : graph.values()) {
			count += node.outDegree();
		}
		return count;
	}

	@Override
	public void removeNodeFor(E item) {
		MyNode<E> node = (MyNode<E>) graph.get(item);
		if (item == null || node == null) {
			throw new NullPointerException("Input was null!");
		}
				
		for (Iterator<Node<E>> itP = node.predsOf(); itP.hasNext();) {
			MyNode<E> pred = (MyNode<E>) itP.next();
			pred.removeSucc(node);
			if (pred.isTail()) {
				tails.add(pred);
			}
			itP.remove();
		}
		
		for (Iterator<Node<E>> itS = node.succsOf(); itS.hasNext();) {
			MyNode<E> succ = (MyNode<E>) itS.next();
			succ.removePred(node);
			if (succ.isHead()) {
				heads.add(succ);
			}
			itS.remove();
		}
		node.disconnect();
		heads.remove(node);
		tails.remove(node);
		graph.remove(item);
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		if (from == null || to == null) {
			throw new NullPointerException("Couldn't check if contains Edge. Input was null!");
		}
		
		Node<E> nodeFrom = graph.get(from);
		Node<E> nodeTo = graph.get(to);
		if (nodeFrom != null && nodeFrom.hasSucc(nodeTo)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEdgeFor(E from, E to) {
		if (from == null || to == null) {
			throw new NullPointerException("Couldn't remove Edge. Input was null!");
		}
		
		MyNode<E> nodeFrom = (MyNode<E>) graph.get(from);
		MyNode<E> nodeTo = (MyNode<E>) graph.get(to);
		if (nodeFrom != null && nodeFrom.hasSucc(nodeTo)) {

			nodeFrom.removeSucc(nodeTo);
			nodeTo.removePred(nodeFrom);
			
			if (nodeFrom.isTail()) {
				tails.add(nodeFrom);
			}
			if (nodeTo.isHead()) {
				heads.add(nodeTo);
			}
			return true;
		}
		return false;
	}
}