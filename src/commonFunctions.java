import java.util.List;

public class commonFunctions {

	static int findIndex(double time, double[][] speed, int start, int end) {
		if(time < speed[0][0])return -1;
		else if(time >= speed[0][speed[0].length-1])return speed[0].length-1;
		
		int middle = (start+end)/2;

		if(speed[0][middle]==time)return middle;
	
		if(start==middle) {
			return middle;
		}
		
		else {
			if(speed[0][middle] > time) {
				return findIndex(time, speed, start,middle);
			}else {
				return findIndex(time,speed,middle,end);
			}
		}
		
	}

	static double timeFromSpeed(double[][] speed, double current_time, double dist) {
		double t = current_time;
		double d = dist;
		int k = findIndex(t, speed, 0, speed[0].length - 1);
		System.out.println("index: "+k);
		double t_;
		try {
			t_ = t + d / speed[1][k];			
		}
		catch(Exception e) {
			System.err.println("Time input is smaller than the starting time.");
			return -1;
		}

		while(k != speed[0].length-1) {
			if(t_ > speed[0][k+1]) {
				d-= speed[1][k] * (speed[0][k+1] - t);
				t = speed[0][k+1];
				t_ = t + d/speed[1][k+1];
				k++;
			}
			else {
				break;
			}
		}
		System.out.println("Final time: "+t_);
		return t_;
	}
	
	static void printSolution(solution s) {
		
		System.out.println("Number of vehicles used: "+s.getNum_vehicles()+ " to cover num_nodes: "+s.getNum_nodes());
		System.out.println("Routes of vehicles are:");
		int i=0;
		for(List<Integer> route : s.getRoutes()) {
			System.out.println("vehicle no.: "+i+1);
			System.out.print("\t");
			for(int n: route) {
				System.out.print(n+", ");
			}
			System.out.println();
		}
	}
}
