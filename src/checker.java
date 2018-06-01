import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checker
{
	public static void mains ( String args [])
	{
		BufferedReader br = null;
		data r = new data();

		try {
			String actionString;
			br = new BufferedReader(new FileReader("text/C101.txt"));
			
			for(int i=0;i<9;i++) {
				actionString = br.readLine();
//				
			}
			
			while ((actionString = br.readLine()) != null) {
				r.addCustomer(actionString);
			}
			
			System.out.println("numbe rof nodes: "+r.getNum_nodes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String args[]) {
		List<Integer> in = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		
		for(int i: in) {
			System.out.println(i);
		}
	}
}