import java.util.*;
import java.io.*;


public class Client {
	private Scanner x;
	private PrintWriter writer;
	public List<Book> lista;
	
	public Client () {
		lista=new LinkedList<Book>();
	}
	
	public void writeFile(String filename) {
		File file = new File(filename); 
		try {
			writer= new PrintWriter(file);
			for(Book b:lista) {
				writer.println(b);
			}
			writer.close();
			
		}
		catch(Exception e) {
			System.out.println("Eroare");
		}
		
		
	}
	
	public void addFromFile(String filename) {
		
		File file = new File(filename);
		try {
			x=new Scanner(file);
			while(x.hasNextLine()) {
				int i=x.nextInt();
				String s=x.next();
				String a=x.next();
				lista.add(new Book(i,s,a));
				
			}
			x.close();
		}
		catch(Exception e) {
			System.out.println("Locatia nu a fost gasita");
		}
		
	}
	
	
	public static void main(String[] args) {
		 
		Client client=new Client();
		File file = new File("lista.txt");
		
		client.addFromFile("Lista.txt");
		System.out.println("Afisam Lista");
		for(Book b:client.lista) {
			System.out.println(b.id+" "+b.name+" ");
		}
		
	}

}
