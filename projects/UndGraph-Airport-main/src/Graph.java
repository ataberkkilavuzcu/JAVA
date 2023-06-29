import java.util.*;

public class Graph {

	 private int [][] adjancencyMatrix;
	 ArrayList<Airport> airports;
	 
	 Graph(int size){
		 airports = new ArrayList<>();
		 adjancencyMatrix = new int [size][size];
	 }
	 public int getAdjancencyMatrixSize() {
		 return adjancencyMatrix.length;
	 }
	 
	 
	public void addAirport(Airport airport) {
		airports.add(airport);
	}
	
	public void addAirway(int source, int destination) {
		adjancencyMatrix[source][destination] = 1;
	}
	
	public boolean checkAirway(int source, int destination) {
		if(adjancencyMatrix[source][destination] == 1) {
			return true;
		}
		return false;	
	}
	
  
	public ArrayList<Integer> findShortestPathwithBFS(int source, int destination){

		boolean[] visited = new boolean[adjancencyMatrix.length];
		int [] parentofVertex = new int [adjancencyMatrix.length];
		Queue<Integer> bfsQueue = new LinkedList<Integer>();
		
		visited[source] = true;
		parentofVertex[source] = -5; // since our source does not have any parent.
		bfsQueue.offer(source);
		
		while(bfsQueue.size() != 0) {
			int temp = bfsQueue.poll();
			
			for(int i = 0; i < adjancencyMatrix.length; i++) {
				
				if(visited[i] != true && adjancencyMatrix[temp][i] == 1) {
					
					bfsQueue.offer(i);
					parentofVertex[i] = temp;
					visited[i] = true;
					
					if(i == destination) {
						ArrayList<Integer> shortestPath = new ArrayList<Integer>();
					
						int temp2 = destination;
						
						while(temp2 != -5) {
							shortestPath.add(temp2);
							Airport.currentStatus(source,temp2);
							temp2 = parentofVertex[temp2];
						}
						System.out.println(shortestPath.size()); // number of city we need to visit for shortest way to reach city.
						return shortestPath;
					}
					
					
				}
			}
			
			
		}
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	public void printAll() {
		System.out.print("  ");
		for(Airport airport : airports) {
			System.out.print(airport.getCity()+" ");
		}
		System.out.println();
		
		for(int i = 0; i < adjancencyMatrix.length; i++) {
			System.out.print(airports.get(i).getCity()+" ");
			for(int j = 0; j < adjancencyMatrix[i].length; j++) {
				System.out.print(adjancencyMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
}