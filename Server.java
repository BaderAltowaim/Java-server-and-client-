package ServerPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		int milk = 50;
		int water = 100;
		int chocolate = 200;
		int potatochips = 150;
		int sum = 0;
		int temp = 0;
		String menu1 = "Item name    \t\t Price(SR) \t\t Available Quantity ";
		String menu2 = "Milk         \t\t 7         \t\t " + milk;
		String menu3 = "Water        \t\t 1         \t\t " + water;
		String menu4 = "Chocolate    \t\t 4         \t\t " + chocolate;
		String menu5 = "Potato Chips \t\t 2         \t\t " + potatochips;
		
					 
		
		try{
			ServerSocket ss = new ServerSocket(9999);
			Socket s = ss.accept();
			
			System.out.println("Client Connected");
			
			InputStreamReader in = new InputStreamReader(s.getInputStream());
			BufferedReader bf = new BufferedReader(in);
			
			
			PrintStream pr = new PrintStream(s.getOutputStream());
			
			String log = bf.readLine();
			
			if(log.equalsIgnoreCase("admin")) {
				pr.println("Welcome admin, enter available quantity of Milk");
				milk = Integer.parseInt(bf.readLine());
				
				pr.println("Enter available quantity of Water");
				water = Integer.parseInt(bf.readLine());
				
				pr.println("Enter available quantity of Chocolate");
				chocolate = Integer.parseInt(bf.readLine());
				
				pr.println("Enter available quantity of Potato Chips");
				potatochips = Integer.parseInt(bf.readLine());
				
				menu1 = "Item name    \t\t Price(SR) \t\t Available Quantity ";
				menu2 = "Milk         \t\t 7         \t\t " + milk;
				menu3 = "Water        \t\t 1         \t\t " + water;
				menu4 = "Chocolate    \t\t 4         \t\t " + chocolate;
				menu5 = "Potato Chips \t\t 2         \t\t " + potatochips;
			}
			
			
			
			String m = bf.readLine();
			
			if(m.equalsIgnoreCase("menu")) {
				
				pr.println(menu1);
				pr.println(menu2);
				pr.println(menu3);
				pr.println(menu4);
				pr.println(menu5);
			}
			
			String order = bf.readLine();
			
			if(order.equalsIgnoreCase("yes")) {
				
				pr.println("How many Milk you want ?");
				temp = Integer.parseInt(bf.readLine());
				if(temp < 0)
					temp = 0;
				if(temp > milk)
					temp = milk;
				sum += 7 * temp;
				milk -= temp;
				
				pr.println("How many Water you want ?");
				temp = Integer.parseInt(bf.readLine());
				if(temp < 0)
					temp = 0;
				if(temp > water)
					temp = water;
				sum += 1 * temp;
				water -= temp;		
				
				pr.println("How many Chocolate you want ?");
				temp = Integer.parseInt(bf.readLine());
				if(temp < 0)
					temp = 0;
				if(temp > chocolate)
					temp = chocolate;
				sum += 4 * temp;
				chocolate -= temp;
				
				pr.println("How many Potato Chips you want");
				temp = Integer.parseInt(bf.readLine());
				if(temp < 0)
					temp = 0;
				if(temp > potatochips)
					temp = potatochips;
				sum += 2 * temp;
				potatochips -= temp;
						
				}
			pr.println(sum);
				
		
			
		}catch(Exception e) {
			
		}

	}

}
