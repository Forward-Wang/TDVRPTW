
public class edge {
	
	private int end1, end2;
	private int dist;

	private int times[][] = new int[2][];
	

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
}
