
import java.util.*;

public class Main {
	
	static final Scanner ataberk = new Scanner(System.in);

	public static void main(String[] args) {


		Graph graph = new Graph(6);
		
		graph.addIsland(new Island('1'));
		graph.addIsland(new Island('2'));
		graph.addIsland(new Island('3'));
		graph.addIsland(new Island('4'));
		graph.addIsland(new Island('5'));
		graph.addIsland(new Island('6'));

		
		graph.addIslandPath(0, 1); //since in our input, our vertices starts from 1 we decrease all inputs by 1 to make it start from index 0 and compatible with our array.
		graph.addIslandPath(0, 2);
		graph.addIslandPath(1, 3);
		graph.addIslandPath(2, 3);
		graph.addIslandPath(2, 4);
		graph.addIslandPath(4, 5);	
		
		  List<Island> cycle = graph.detectCycle(0, 3);

	        if (cycle.isEmpty()) {
	            System.out.println("No cycle found");
	        }
	        else {
	            System.out.print("Cycle: ");
	            for (Island island : cycle) {
	                System.out.print(island.name + " ");
	            }
	            System.out.println();
	        }
	}
}
