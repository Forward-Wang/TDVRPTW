import java.util.ArrayList;
import java.util.List;

public class data {
	
	private int num_nodes,num_vehicles, max_vehicles;
//	vehicle[] vehicles;
	private List<node> nodes;
	
	data(){
		init();
	}
	
	void init() {
		num_vehicles = 0;
		num_nodes = 0;
		nodes = new ArrayList<>();
	}
	
	public int getNum_nodes() {
		return num_nodes;
	}
	
	public int getMax_vehicles() {
		return max_vehicles;
	}

	public int getNum_vehicles() {
		return num_vehicles;
	}

	public void setNum_vehicles(int num_vehicles) {
		this.num_vehicles = num_vehicles;
	}
	
	public List<node> getNodes() {
		return nodes;
	}

	public void addCustomer(String s) {
		String parts[] = s.split(" ");
		String correctParts[] = new String[7];
		
		int j=0;
		for(int i=0;i<parts.length;i++) {
			if(!parts[i].equals("") && parts[i]!=null) {
//				System.out.println("parts[i]: "+parts[i]);
				correctParts[j++] = parts[i];
//				System.out.println("j: "+j);
			}
		}
		
//		for(String p: correctParts)
//			System.out.println(p);
		
		if(correctParts[0]!=null) {
//			for(String p: correctParts)
//				System.out.println("correct parts: "+p);
			int id=Integer.parseInt(correctParts[0]),
				x=Integer.parseInt(correctParts[1]),
				y=Integer.parseInt(correctParts[2]),
				l=Integer.parseInt(correctParts[4]),
				u = Integer.parseInt(correctParts[5]);
			
			node n = new node(id);
			n.setL(l);
			n.setU(u);
			n.setX(x);
			n.setY(y);
			
			nodes.add(n);
			
			num_nodes++;
		}
	}
	
}
