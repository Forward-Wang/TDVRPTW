import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class initialsolution {
	void createSoln(data d) {
		List<List<Integer>> routes = new ArrayList<>();
		
		List<node> nodes = d.getNodes();
		int num_nodes = d.getNum_nodes() - 1;				// -1 for the depot
		int num_routed = 0;
		
//		for(node n: nodes) {
//			if(n.getId()!=0)
//			routes.add(new ArrayList<>(Arrays.asList(n.getId())));
//		}
		
		boolean routed_nodes[] = new boolean[num_nodes];
		
		for(int i=0;i<num_nodes;i++) {			//continue from here
			routed_nodes[i] = false;
		}
		
		while(num_routed!=num_nodes) {
			List<Integer> route = new ArrayList<>();
		}
		
	}
	
	private node findNearest(node n, List<node> nodes, double current_time) {
		
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
			
			if(other_end != n.getId() && other_end!=0) {
				
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
		
		return min_node;
	}
}
