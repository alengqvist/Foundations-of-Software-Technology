package al223bn;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;


/**
 * Two nodes a and b are directly connected if their exist an edge (a,b) 
 * or an edge (b,a). Two nodes a and k are connected if there exist a sequence
 * of nodes [a,b,c,d, ... j,k] such that [a,b], [b,c], [c,d], [d,e], ..., [j,k]
 * are all directly connected.
 * <p/>
 * Problem: find a partitioning of the graph nodes such that two nodes belongs to the 
 * same partitioning if and only if they are connected.
 * </p>
 * The result is a collection of node collections.
 *  
 * @author jonasl
 *
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E> {

	private Set<Collection<Node<E>>> set;
    private Set<Node<E>> visited;
    private Set<Node<E>> connected;
    
	@Override
	public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
		set = new HashSet<Collection<Node<E>>>();
		connected = new HashSet<Node<E>>();
		visited = new HashSet<Node<E>>();
		
		for (Node<E> node : dg) {
			if (!visited.contains(node)) {
				connect(node);
				
		        Iterator<Collection<Node<E>>>  itC = set.iterator();		        
		        while (itC.hasNext()) {
		        	Collection<Node<E>> cc = itC.next();

		            if (!Collections.disjoint(cc, connected)) {
		        		cc.addAll(connected);
		    			connected = new HashSet<Node<E>>();
		            }
		        }
				
		        if (!connected.isEmpty()) {
		        	set.add(connected);
	    			connected = new HashSet<Node<E>>();
		        }
			}
		}
		return set;
	}

	private void connect(Node<E> node) {
        visited.add(node);
        connected.add(node);
		
        Iterator<Node<E>>  it = node.succsOf();		        
        while (it.hasNext()) {
			Node<E> successor = it.next();
			if (!connected.contains(successor)) {
				connect(successor);
			}
		}
	}
}