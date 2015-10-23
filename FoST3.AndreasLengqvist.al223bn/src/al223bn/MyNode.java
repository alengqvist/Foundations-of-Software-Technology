package al223bn;

import graphs.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class MyNode<E> extends Node<E> {
	
	private Set<Node<E>> preds = new HashSet<>();
	private Set<Node<E>> succs = new HashSet<>();

	protected MyNode(E item) {
		super(item);
	}

	@Override
	public boolean hasSucc(Node<E> node) {
		return succs.contains(node);
	}

	@Override
	public int outDegree() {
		return succs.size();
	}

	@Override
	public Iterator<Node<E>> succsOf() {
		return succs.iterator();
	}

	@Override
	public boolean hasPred(Node<E> node) {
		return preds.contains(node);
	}

	@Override
	public int inDegree() {
		return preds.size();
	}

	@Override
	public Iterator<Node<E>> predsOf() {
		return preds.iterator();
	}

	@Override
	protected void addSucc(Node<E> succ) {
		succs.add(succ);		
	}

	@Override
	protected void removeSucc(Node<E> succ) {
		succs.remove(succ);
	}

	@Override
	protected void addPred(Node<E> pred) {
		preds.add(pred);
	}

	@Override
	protected void removePred(Node<E> pred) {
		preds.remove(pred);
	}

	@Override
	protected void disconnect() {
		preds.clear();
		succs.clear();
	}
}