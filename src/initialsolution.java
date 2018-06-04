import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class initialsolution {
	
	List<List<Integer>> routes = new ArrayList<>();
	boolean routed_nodes[];
	List<node> nodes;
	int  num_routed, num_nodes;
	node depot;
	
	solution createSoln(data d) {
		
		nodes = d.getNodes();
		num_nodes = d.getNum_nodes();	//dont do -1			// -1 for the depot
		num_routed = 0;
		depot = d.getDepot();
		
		double starting_time = d.getStarting_time(), end_time = d.getEnd_time();
				
		routed_nodes = new boolean[num_nodes];
		
		routed_nodes[0] = true;
		
		for(int i=1;i<num_nodes;i++) {
			routed_nodes[i] = false;
		}
		
		while(num_routed!=num_nodes-1) {
			List<Integer> route = makeNewRoute(starting_time,end_time);
			routes.add(route);			
		}
		
		solution s = new solution(routes.size(), num_nodes);
		s.setRoutes(routes);
		
		return s;
	}
	
	private List<Integer> makeNewRoute(double starting_time, double end_time){
		double current_time = starting_time;
		
		List<Integer> route = new ArrayList<>();
		node n = depot;
		
		while(current_time <= end_time && num_routed!=num_nodes) {
			n = findNearest(n, current_time, end_time);
			
			if(n.getId()==0) {
				break;
			}
			else {
				route.add(n.getId());
				routed_nodes[n.getId()] = true;
				num_routed++;
			}
		}
		
		return route;
	}
	
	private node findNearest(node n, double current_time, double end_time) {
				
		double min_time=Double.MAX_VALUE;
		node min_node = null;
		List<edge> incident_edges =  n.getIncident_edges();
		
		for(edge e: incident_edges) {
			
			int other_end = 0;
			
			try {												//This error means the input was wrong somehow... an incident edge does not has the current node as its end;
				other_end = e.getOther_end(n.getId());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			if(other_end != n.getId() && other_end!=0 && routed_nodes[other_end]==false) {			//other end must be a different node and it must have not been routed already.
				
				double this_time = commonFunctions.timeFromSpeed(e.getSpeed(), current_time, e.getDist());
				node other_node = nodes.get(other_end);
				
				if(this_time < min_time && other_node.getU() > this_time+current_time) {
					if(other_node.getL() < this_time+current_time) {
						min_time = this_time + current_time;
						min_node = other_node;
					}
					else {										//vehicle has to wait to meet the starting time window constraint.
						min_time = other_node.getL();
						min_node = other_node;
					}
				}
			}
		}
		
		if(min_node==null)				// no node left which satisfies the conditions
			return depot;				//conditions are: (1) node should not have been routed (2) its upper limit must not b exceeded. (3) different from depot
		
		if(current_time + min_time + commonFunctions.timeFromSpeed(min_node.getIncident_edges().get(0).getSpeed(), current_time+min_time, min_node.getIncident_edges().get(0).getDist()) > end_time)			// 3rd parameter is the time to reach depot starting from the new nearest node
			return depot;
		
		return min_node;
	}
}
