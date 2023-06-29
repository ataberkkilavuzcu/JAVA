import java.util.ArrayList;
import java.util.List;

class Island {
    public char name;
    public boolean visited;
    public List<Island> neighbours;

    public Island(char name) {
        this.name = name;
        this.visited = false;
        neighbours = new ArrayList<Island>();
    }

    public void addNeighbour(Island island) {
        this.neighbours.add(island);
    }

    public List<Island> getNeighbours() {
        return neighbours;
    }
}