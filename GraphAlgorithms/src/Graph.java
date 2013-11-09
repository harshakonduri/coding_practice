import java.util.*;
/*
 * AdjacencyList Representation:
 * constructor : build an empty graph
 * constructor : build graph from file with specified delimiter 
 * with 1 edge per line
 * int numberofVerticies(); return number of verticies in graph
 * int numberofEdges(); return number of Edges in graph
 * int AdjacencyList(u); return all adjacent nodes of vertex u
 * int addEdge(String u,String v); Add an edge between 2 verticies.
 */
public class Graph {
	private HashMap<String,ArrayList<GraphNode>> adjList;
	private int V;
	private int E;
	public Graph() {
		adjList = new HashMap<String, ArrayList<GraphNode>>();
	}
	/**
	 * 
	 * @param fileName specify the fileName to read input
	 * @param delimiter specify delimiter to differentiate edges
	 */
	public Graph(String fileName,String delimiter) {
		adjList = new HashMap<String, ArrayList<GraphNode>>();
		buildGraph(fileName,delimiter);
	}
	/**
	 * 
	 * @param v Check if the vertex is in the graph
	 * @return true or false
	 */
	public boolean hasVertex(String v) {
		return (adjList.containsKey(v));
	}
	/**
	 * 
	 * @param u Source vertex of Edge
	 * @param v Destination Vertex of Edge
	 * @return true if the Edge is present in graph else false 
	 */
	public boolean hasEdge(String u,String v) {
		if(hasVertex(u)) {
			ArrayList<GraphNode> aL = adjacencyList(u);
			for(GraphNode l : aL) {
				if(l.getName().equals(v)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 
	 * @param v
	 * @return
	 */
	public GraphNode getVertex(String v) {
		GraphNode node=null;
		if(hasVertex(v)) {
			return new GraphNode(v);
		}
		return null;
	}
	/**
	 * 
	 * @param u Source vertex of edge
	 * @param v Destination vertex of edge
	 * @return true if edge addition was successful.
	 */
	public boolean addEdge(String u,String v) {
		GraphNode unode=null,vnode=null;
		if(!hasVertex(u)) {
			unode = new GraphNode(u);
		}
		else {
			unode = getVertex(u);
		}
		if(!hasVertex(v)) {
			vnode = new GraphNode(v);
		}
		else {
			vnode = new GraphNode(v);
		}
		if(!hasEdge(u, v)) {
			ArrayList<GraphNode> listOfU = adjacencyList(u);
			if(listOfU != null) { // adj list contains key u
				adjList.remove(u);
				listOfU.add(vnode);
				adjList.put(u,listOfU);
			}
			else {
				listOfU = new ArrayList<GraphNode>();
				listOfU.add(vnode);
				adjList.put(u, listOfU);
			}
			ArrayList<GraphNode> listOfV = adjacencyList(v);
			if(listOfV != null) { // adj list contains key v
				adjList.remove(v);
				listOfV.add(unode);
				adjList.put(v, listOfV);
			}
			else {
				listOfV = new ArrayList<GraphNode>();
				listOfV.add(unode);
				adjList.put(v, listOfV);
			}		
		}
		return false;
	}
	/**
	 * 
	 * @param vertex : Input vertex
	 * @return the adjacencyList representation of the vertex
	 */
	public ArrayList<GraphNode> adjacencyList(String vertex) {
		if(hasVertex(vertex)) {
			return adjList.get(vertex);
		}
		return null;
	}
	/**
	 * 
	 * @param fileName specify the fileName to read input
	 * @param delimiter specify delimiter to differentiate edges
	 */
	public void buildGraph(String fileName, String delimiter) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Display the Adjacency List of the Graph
	 */
	public void displayGraph() {
		Set<String> verticies = adjList.keySet();
		Iterator<String> ir = verticies.iterator();
		while(ir.hasNext()) {
			String key = ir.next();
			ArrayList<GraphNode> adjListVertex = adjacencyList(key);
			System.out.print(key + ":" + " ");
			for(GraphNode loop : adjListVertex) {
				System.out.print(loop.getName() + " ");
			}
			System.out.println();
		}
	}
}
