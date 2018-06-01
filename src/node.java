import java.util.ArrayList;
import java.util.List;

public class node {
	
	private int id,x,y,u,l;
	private List<edge> incident_edges;		//list of edges incident on current node
	
	node(){
		incident_edges = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public List<edge> getIncident_edges() {
		return incident_edges;
	}

	public void setIncident_edges(List<edge> incident_edges) {
		this.incident_edges = incident_edges;
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
	
	void addIncident_edges(edge e){
		incident_edges.add(e);
	}

	
	
}
