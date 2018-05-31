import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class checker
{
	public static void main ( String args [])
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
}