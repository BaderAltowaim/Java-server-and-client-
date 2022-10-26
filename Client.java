package ClientPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		String tmp = "null";
		String order = "null";
		
		try {
			Socket s = new Socket("localhost",9999);
			
			PrintStream pr = new PrintStream(s.getOutputStream());
			
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(in);
			
			InputStreamReader sin = new InputStreamReader(s.getInputStream());
			BufferedReader sbf = new BufferedReader(sin);
			
			System.out.println("Hello welcome to our Online Grocery Store");
			System.out.println("If you are an Administrator please log in or type anything else");
			
			String admin = bf.readLine();
			 pr.println(admin);
			if(admin.equalsIgnoreCase("admin")) {
				
				for(int i = 0 ;i < 4 ; i++) {
					String tmp2 = sbf.readLine();
					System.out.println(tmp2);
					int number = Integer.parseInt(bf.readLine());
					pr.println(number);	
				}
			}
			while(!tmp.equalsIgnoreCase("menu") && !tmp.equalsIgnoreCase("exit")) {
				System.out.println("You can requset our menu by typing (menu) or if you want to exit type (exit)");
			
				tmp = bf.readLine();
			}
			if(tmp.equalsIgnoreCase("exit")) {
				System.out.println("Good bye");
				s.close();
			 } else if(tmp.equalsIgnoreCase("menu")){
				 
				 pr.println(tmp);
				 
				 for(int i = 0;i<5 ;i++) {
				 String menu = sbf.readLine();
				 System.out.println(menu);
				 }
				 while(!order.equalsIgnoreCase("yes") && !order.equalsIgnoreCase("no")) {
					 System.out.println("Do you want to order type (yes) or (no)");
					 order = bf.readLine();
				 }
				
					
					if(order.equalsIgnoreCase("no")) {
						System.out.println("Good bye");
						s.close();
					}else if(order.equalsIgnoreCase("yes")) {
						pr.println(order);
						for(int i = 0 ;i < 4 ; i++) {
							String tmp2 = sbf.readLine();
							System.out.println(tmp2);
							int number = Integer.parseInt(bf.readLine());
							pr.println(number);	
						}
						
						System.out.println("Total price :" + Integer.parseInt(sbf.readLine()));
						System.out.println("Thank you for visiting our Online Grocery Store");
					}
					
			 }
			
		}catch(Exception e) {
			
		}

	}

}
