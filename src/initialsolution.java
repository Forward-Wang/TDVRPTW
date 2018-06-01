import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class initialsolution {
	void createSoln(data d) {
		List<List<Integer>> routes = new ArrayList<>();
		
		List<node> nodes = d.getNodes();
		
		for(node n: nodes) {
			if(n.getId()!=0)
			routes.add(new ArrayList<>(Arrays.asList(n.getId())));
		}
		
		
	}
	
	private node findNearest(node n, List<node> nodes, double current_time) {
		double min_time=0;
		List<edge> incident_edges =  n.getIncident_edges();
		for(edge e: incident_edges) {
			int other_end = 0;
			try {
				other_end = e.getOther_end(n.getId());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(other_end != n.getId() && other_end!=0) {
				double this_time = commonFunctions.timeFromSpeed(e.getSpeed(), current_time, e.getDist());
				if(this_time < min_time) {
					min_time = this_time;
					
				}
			}
		}
	}
}
