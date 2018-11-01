import java.util.Scanner;

public class CheckTriangle {
    public static void main(String args[] ) throws Exception {
    	Scanner scan = new Scanner(System.in);
		int noOfLines = Integer.parseInt(scan.nextLine());

		String[] type = new String[noOfLines];
		
		for (int i=0;i<noOfLines;i++) {
			String values=scan.nextLine();
			String[] traingleSides=values.split(" ");		
			
			type[i] = triangleSides(Integer.parseInt(traingleSides[0]), Integer.parseInt(traingleSides[1]),Integer.parseInt(traingleSides[2]));
		}
		scan.close();
		
		for (int i = 0; i < type.length; i++) {
			System.out.println(type[i]);
		}
		
	}

	public static String triangleSides(int a, int b, int c) {
	
		String type = "";
		if (a+b>c && b+c>a && a+c>b) {
			if(a==b&&b==c&&c==a)
	            type = "Equilateral";
	        else if((a==b)||(b==c)||(c==a))
	        	type = "Isosceles";
	        else if(a!=b&&b!=c&&c!=a)
	        	type = "Scalene";
		}else {
			type = "Not a valid triangle";
		}
		return type;
	} 
    
}