
import java.util.*;

public class Main {
	
	static final Scanner ataberk = new Scanner(System.in);

	public static void main(String[] args) {
		
		int airportSize = ataberk.nextInt();
		int airwaySize = ataberk.nextInt();
		char counter = '1';
		Airport.setStateChangeTime(ataberk.nextInt());
		Airport.setFlightTime(ataberk.nextInt());
		
		Graph graph = new Graph(airportSize);
		
		while(airportSize != 0) {
			graph.addAirport(new Airport(counter));
			counter++;
			airportSize--;
		}
		while(airwaySize != 0) {
			graph.addAirway(ataberk.nextInt()-1,ataberk.nextInt()-1);
			airwaySize--;
		}
		ArrayList<Integer> shortestAirway = new ArrayList<Integer>();
		shortestAirway = graph.findShortestPathwithBFS(ataberk.nextInt()-1, ataberk.nextInt()-1);
		Collections.reverse(shortestAirway);
		for(int i : shortestAirway) {
			System.out.print(i+1+" ");
		}
		System.out.println();
		System.out.println(Airport.getrealTime());
/*		Graph graph = new Graph(5);
		
		graph.addAirport(new Airport('1'));
		graph.addAirport(new Airport('2'));
		graph.addAirport(new Airport('3'));
		graph.addAirport(new Airport('4'));
		graph.addAirport(new Airport('5'));
		
		graph.addAirway(0, 1); //since in our input, our vertices starts from 1 we decrease all inputs by 1 to make it start from index 0 and compatible with our array.
		graph.addAirway(0, 2);
		graph.addAirway(1, 3);
		graph.addAirway(0, 3);
		graph.addAirway(1, 4);
		
		graph.printAll();
		
		ArrayList<Integer> shortestAirway = new ArrayList<Integer>();
		
		shortestAirway = graph.findShortestPathwithBFS(0, 4);
	
		Collections.reverse(shortestAirway);
		for(int i : shortestAirway) {
			System.out.print(i+1+" ");
		}*/
		
	}

}
