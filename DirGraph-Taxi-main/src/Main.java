import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ataberk = new Scanner(System.in);
        
        // getting number of taxis for vertices
        System.out.println("Enter the number of taxi pickups: ");
        int taxiPickups = ataberk.nextInt();

        System.out.println("Enter the number of taxi rides: ");
        
        // getting taxi rides for edges
        int taxiRides = ataberk.nextInt();
        DirectedGraph graph = new DirectedGraph(taxiPickups,taxiRides);
        System.out.println("Enter the taxi rides: ");
        
        // adding edges to graph.
        for (int i = 0; i < taxiRides; i++) {
            graph.addTaxiRide(ataberk.next(), ataberk.next());
 
        }

        // printing output
        graph.printRides();
        
        
        
    }
}
// To try an input by myself.
// Cayyolu -> 0, Emek -> 1, Kızılay -> 2, Yenimahalle -> 3, 