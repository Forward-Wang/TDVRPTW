import java.util.ArrayList;
import java.util.List;

public class solution {
	
	private int num_vehicles,num_nodes, num_nodes_visited;
	private List<List<Integer>> routes;
	
	solution(int num_vehicles, int num_nodes){
		this.num_nodes = num_nodes;
		this.num_vehicles = num_vehicles;
		
		routes = new ArrayList<List<Integer>>();
		for(int i=0;i<num_vehicles;i++) {
			List<Integer> temp_list = new ArrayList<>();
			temp_list.add(0);
			routes.add(temp_list);
		}
	}
	
	public int getNum_vehicles() {
		return num_vehicles;
	}
	
	public int getNum_nodes_visited() {
		return num_nodes_visited;
	}
	
	public int getNum_nodes() {
		return num_nodes;
	}

	void addNodeToVehicle(int vehicle_id, int node_id){
		routes.get(vehicle_id).add(node_id);
	}
	
	public List<List<Integer>> getRoutes() {
		return routes;
	}
	
	public void setRoutes(List<List<Integer>> routes) {
		this.routes = routes;
	}

}
