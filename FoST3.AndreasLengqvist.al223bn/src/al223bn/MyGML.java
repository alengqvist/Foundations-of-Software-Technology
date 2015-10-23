package al223bn;

import java.util.Iterator;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;


public class MyGML<E> extends GML<E> {

	public MyGML(DirectedGraph<E> dg) {
		super(dg);
	}
	
	public static void main(String[] args) {
		DirectedGraph<Integer> dg = new MyGraph<Integer>();
		
		
		
		dg.addEdgeFor(0,1);
		dg.addEdgeFor(1,2);
		dg.addEdgeFor(2,0);
		
		dg.addEdgeFor(0,1);
		dg.addEdgeFor(0,2);
		dg.addEdgeFor(1,3);
		dg.addEdgeFor(2,3);
		dg.addEdgeFor(2,2); // reflexive
		dg.addEdgeFor(3,1); //cycle
		dg.addEdgeFor(3,4);
		dg.addEdgeFor(4,5);
		dg.addEdgeFor(5,3); //cycle
		dg.addEdgeFor(4,6); //leaf
		
		/* acyclic part */
		dg.addEdgeFor(10,11);
		dg.addEdgeFor(10,12);
		dg.addEdgeFor(11,13);
		dg.addEdgeFor(12,13);
		dg.addEdgeFor(13,14);
		dg.addEdgeFor(14,15);
		dg.addEdgeFor(13,15); 
		dg.addEdgeFor(14,16); //leaf
		GML<Integer> gml = new MyGML<Integer>(dg);

		gml.dumpGML();

	}

	@Override
	public String toGML() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		sb.append("graph [ \r\n");
		
		for(Node<E> node : graph){
			System.out.println(node);
		    sb.append("node [ id " + node + "\n");
		    sb.append("\t label \"" + node + "\"\n");
		    sb.append("\t ]\n");			
		}
		
		for(Node<E> node : graph){
			
			for (Iterator<Node<E>> succs = node.succsOf(); succs.hasNext();) {
				Node<E> next = succs.next();
				sb.append("edge [\n");
			    sb.append("\t source " + node + "  target " + next
				    + "\n");
			    sb.append("\t ]\n");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}