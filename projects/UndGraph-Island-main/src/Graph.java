import java.util.*;

public class Graph {

	 public int [][] adjancencyMatrix;
	 ArrayList<Island> islands;
	 
	 Graph(int size){
		 islands = new ArrayList<>();
		 adjancencyMatrix = new int [size][size];
	 }
	 public int getAdjancencyMatrixSize() {
		 return adjancencyMatrix.length;
	 }
	 
	 
	public void addIsland(Island island) {
		islands.add(island);
	}
	
	public void addIslandPath(int source, int destination) {
		adjancencyMatrix[source][destination] = 1;
		adjancencyMatrix[destination][source] = 1;

	}
	
	public boolean checkIslandPath(int source, int destination) {
		if(adjancencyMatrix[source][destination] == 1) {
			return true;
		}
		return false;	
	}
	  private boolean hasCycleUtil(Island island, Island parent, List<Island> cycle) {
	        island.visited = true;

	        for (Island neighbour : island.getNeighbours()) {
	            if (!neighbour.visited) {
	                cycle.add(neighbour);
	                if (hasCycleUtil(neighbour, island, cycle)) {
	                    return true;
	                }
	                cycle.remove(cycle.size() - 1);
	            } else if (!neighbour.equals(parent)) {
	                cycle.add(neighbour);
	                return true;
	            }
	        }

	        return false;
	    }

	    public List<Island> detectCycle(int start, int end) {
	        List<Island> cycle = new ArrayList<Island>();
	        Island startIsland = islands.get(start);
	        Island endIsland = islands.get(end);
	        cycle.add(startIsland);

	        if (hasCycleUtil(startIsland, null, cycle)) {
	            cycle.add(startIsland);

	            int cycleStart = cycle.indexOf(endIsland);
	            if (cycleStart != -1) {
	                cycle = cycle.subList(cycleStart, cycle.size());
	            }
	            else {
	                cycle.clear();
	            }
	        }
	        else {
	            cycle.clear();
	        }

	        for (Island island : islands) {
	            island.visited = false;
	        }

	        return cycle;
	    }
	


	
	
	
	
	
	
}