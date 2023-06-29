import java.util.*;
public class DirectedGraph {
	
	//adjacency matrix for graph
	private int [][] adjacencyMatrix;
	
	//hash map to store taxis 
	private HashMap<String, Integer> taxis;
	
	//number of vertex and edges to create graph.
	private int vertexNum;
	private int edgeNum;
	
	public DirectedGraph(int vertexNum, int edgeNum) {
		// Summary: Constructor that creates directed graph
	     // 
		 // Precondition: vertexNum and edgeNum are integers
		 // Postcondition: The graph is created.

		this.vertexNum = vertexNum;
		this.edgeNum = edgeNum;
		adjacencyMatrix = new int[vertexNum][vertexNum];
		taxis = new HashMap<String, Integer>();
	}
	
	
	public boolean checkTownExistance(String key) {
		// Summary: checks if hash map stores given key.
		// Precondition: key is a string represents keys for hash map.
		// Postcondition: hash map has been checked.

		
		//if taxis have key it returns true else false.
		if(!taxis.containsKey(key)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public void addTown(String key) {
		// Summary: checks if hash map stores given key if not adds to end.
		// Precondition: key is a string to add hash map.
		// Postcondition: key has been added to hash map.

		if(!checkTownExistance(key)) {
			int index = taxis.size();
			taxis.put(key, index);
		}
		else {
			return;
		}
	}
	
	
	public int getIndexTown(String key) {		
		// Summary: gets the index of given key
		// Precondition: key is a string represents key for hash map.
		// Postcondition: index of given key is returned.
		if(checkTownExistance(key)) {
			return taxis.get(key);
		}
		else {
			return 0;
		}	
	}
	
	public void addTaxiRide(String sourceKey, String destinationKey) {
		// Summary: adds edge to graph.
		// Precondition: sourcekey and destination key are strings 
		// represent two keys.
		// Postcondition: edge has been added between sourcekey and destinationkey.
		int sourceIndex, destinationIndex;
		if(!checkTownExistance(sourceKey)) {
			addTown(sourceKey);
			sourceIndex = getIndexTown(sourceKey);
		}
		else {
			sourceIndex = getIndexTown(sourceKey);
		}
		if(!checkTownExistance(destinationKey)) {
			addTown(destinationKey);
			destinationIndex = getIndexTown(destinationKey);
		}
		else {
			destinationIndex = getIndexTown(destinationKey);
		}
		adjacencyMatrix[sourceIndex][destinationIndex] = 1;
		
	}
	
	public boolean checkNumofEdgeVertex() {
		// Summary: checks if number of edge and number of vertices to use for 
		// checking tree.
		// Precondition:
		// Postcondition: relation between vertex and edge number is returned.	
		if(vertexNum == edgeNum + 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkConnected() {
		// Summary: uses BFS to check whole graph is connected or not. 
		// Precondition:
		// Postcondition: return true if graph is connected.
		Queue<Integer> vertexQueue = new LinkedList<Integer>();
		boolean[] visitedVertex = new boolean[vertexNum];
		visitedVertex[0] = true;		
		vertexQueue.offer(0);
		
		//BFS 
		while(vertexQueue.size() != 0) {
			int temp = vertexQueue.poll();
			
	        // find adjacent vertices
			for(int i = 0; i < vertexNum; i++) {
				if(visitedVertex[i] == false && adjacencyMatrix[temp][i] == 1) {
					visitedVertex[i] = true;
					vertexQueue.offer(i);
					
				}
			}
	
			
		}
		
	    // check if all vertices have been visited
		for(boolean checkCon : visitedVertex) {
			if(checkCon == false) {
				return false;
		}
	}	
		return true;	
	}
	
	
	public boolean checkCycle() {
		// Summary: visiting all vertices and doing DFS 
		// Precondition:
		// Postcondition: 
		
	    boolean[] visited = new boolean[vertexNum];
	    boolean[] recursionStack = new boolean[vertexNum];

	    // performing DFS
	    for (int i = 0; i < vertexNum; i++) {
	        if (dfs(i, adjacencyMatrix, visited, recursionStack)) {
	            return true;
	        }
	    }

	    return false;
	}

	private boolean dfs(int vertex, int[][] adjacencyMatrix, boolean[] visitedVertex, boolean[] recursionStack) {
		// Summary: standard DFS method to visit all vertices
		// Precondition:
		// Postcondition: 	
	    visitedVertex[vertex] = true;
	    recursionStack[vertex] = true;

	    for (int i = 0; i < adjacencyMatrix[vertex].length; i++) {
	        if (adjacencyMatrix[vertex][i] == 1) {
	            if (visitedVertex[i] == false) {
	                if (dfs(i, adjacencyMatrix, visitedVertex, recursionStack)) {
	                    return true;
	                }
	            } else if (recursionStack[i] == true) {
	                return true;
	            }
	        }
	    }

	    recursionStack[vertex] = false;

	    return false;
	}

	
	public boolean checkTree() {
		// Summary: check if all conditions satisfies for tree.
		// Precondition:
		// Postcondition: return true if it's tree.
		if(checkConnected() && checkNumofEdgeVertex() && !checkCycle()) {
			System.out.println("This ride network can be kept in a tree structure.");
			return true;
		}
		else {
			System.out.println("This ride network cannot be kept in a tree structure.");
			return false;
		}
	}
	
	
	
	public void printRides() {
		// Summary: prints graph with respect to how it's asked in homework.
		// Precondition:
		// Postcondition: printing ride .
		
		
	    for (int i = 0; i < vertexNum; i++) {
	        String vertex = null;
	        for (String key : taxis.keySet()) {
	            if (taxis.get(key) == i) {
	                vertex = key;
	                break;
	            }
	        }
	        System.out.print(vertex + ": ");
	        boolean hasEdges = false;
	        
	        // to get same output with question 
	        // i started from vertexnum - 1 and 
	        // iterate through 0.
	        for (int j = vertexNum - 1; j > - 1; j--) {
	            if (adjacencyMatrix[i][j] == 1) {
	                if (hasEdges) {
	                    System.out.print(" ");
	                }
	                String destVertex = null;
	                for (String key : taxis.keySet()) {
	                    if (taxis.get(key) == j) {
	                        destVertex = key;
	                        break;
	                    }
	                }
	                System.out.print(destVertex);
	                hasEdges = true;
	            }
	        }
	        System.out.println();
	    }
	    //it prints if is it tree or not
	    checkTree();
	}
	
	
	
}
