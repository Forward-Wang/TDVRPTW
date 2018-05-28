
public class commonFunctions {

	static int findIndex(double time, double[][] speed, int start, int end) {
		if(time < speed[0][0])return -1;
		else if(time > speed[0][speed[0].length-1])return speed[0].length-1;
//		int index;
		System.out.println("findIndex: "+start+", "+end);
//		if (start > end)
//			return -1;
//		else {
//			int middle = (start + end) / 2;
//			if (speed[0][middle] < time && middle == speed.length - 1) {
//				return middle;
//			} else if (speed[0][middle] <= time && speed[0][middle+1] > time) {
//				return middle;
//			} else if (speed[0][middle] > time && middle == 0) {
//				return middle;
//			} else {
//				if(middle==start && middle==end)return -1;
//				int i1 = findIndex(time, speed, start, middle), i2 = findIndex(time, speed, middle + 1, end);
//				if (i1 != -1) {
//					System.out.println("returning i1");
//					return i1;
//				}
//				else {					
//					System.out.println("returning i2");
//					return i2;
//				}
//			}
//		}
		
		int middle = (start+end)/2;

		if(speed[0][middle]==time)return middle;
	
		if(start==middle) {
			if(middle==0) {
				if(speed[0][middle] > time)return -1;
				else return middle;
			}else if(middle == speed[0].length-1) {
				return middle;
			}else {
				return middle;
			}
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

		if(k != speed[0].length-1) {
			while(t_ > speed[0][k+1]) {
				d-= speed[1][k] * (speed[0][k+1] - t);
				t = speed[0][k+1];
				t_ = t + d/speed[1][k+1];
				k++;
			}
		}
		System.out.println("Final time: "+t_);
		return t_;
	}
}
