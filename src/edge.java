
public class edge {
	
	private int end1, end2;
	private int dist;
	private double[][] speed;
	
	private int times[][] = new int[2][];
	
	public double[][] getSpeed() {
		return speed;
	}
	
	public void setSpeed(double[][] speed) {
		this.speed = speed;
	}

	public int getEnd1() {
		return end1;
	}

	public void setEnd1(int end1) {
		this.end1 = end1;
	}

	public int getEnd2() {
		return end2;
	}

	public int getDist() {
		return dist;
	}
	
	public void setDist(int dist) {
		this.dist = dist;
	}
	
	public void setEnd2(int end2) {
		this.end2 = end2;
	}
	
	public int[][] getTimes() {
		return times;
	}
	
	public int getOther_end(int n) throws Exception {
		if(end1==n)
			return end2;
		else if(end2==n)
			return end1;
		else
			throw new Exception("Edge not incident on this node.");
	}
}
