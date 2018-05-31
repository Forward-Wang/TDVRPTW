import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class main {
	public static void mains(String args[]) {
		double[][] speed = {{1,2,3,4,5,6,7,8,9,10},{2,4,5,7,8,9,3,4,6,7}};

		while(true) {

			Scanner sc=new Scanner(System.in);  

			System.out.println("Enter time");  
			double t = sc.nextDouble();  //			speed[0].

			double time = commonFunctions.timeFromSpeed(speed, t, 4);

			System.out.println("Time: "+time);

		}
	}
}
