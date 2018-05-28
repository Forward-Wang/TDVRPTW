import java.util.Vector;

public class node {
	
	private int id;
	private Vector<Integer> neighbours;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vector<Integer> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(Vector<Integer> neighbours) {
		this.neighbours = neighbours;
	}

	
	node(int id){
		this.id = id;
	}
	
	void addNeighbour(int n){
		neighbours.addElement(n);
	}
	
}
