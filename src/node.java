import java.util.Vector;

public class node {
	
	private int id,x,y,u,l;
	private Vector<Integer> neighbours;
	
	public int getId() {
		return id;
	}

	public Vector<Integer> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(Vector<Integer> neighbours) {
		this.neighbours = neighbours;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getU() {
		return u;
	}

	public void setU(int u) {
		this.u = u;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}
	
	node(int id){
		this.id = id;
	}
	
	void addNeighbour(int n){
		neighbours.addElement(n);
	}

	
	
}
