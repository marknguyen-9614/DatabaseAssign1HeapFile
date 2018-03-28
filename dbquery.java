import java.io.*;
import java.util.*;

public class dbquery{
	static int pageSize = 0;
	static int pagesSearched = 0;
	static int businessesFound = 0;
	static String searchQuery;
	static long startTime = 0;
	static long endTime = 0;
	static ArrayList<Page> heap = new ArrayList<Page>();

	public static void readFile(File f){
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
			Page page = null;
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			while(true){
				try{
					Object obj = ois.readObject();
					page = (Page)obj;
					heap.add(page);
					//System.out.println(page.businesses);
				}
				catch(EOFException eoe){
					break;
				}
			}
		}
		catch(FileNotFoundException fnf){
			System.out.println(fnf.getMessage());
			System.out.println("Terminating Program");
			System.exit(0);
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				fis.close();
				ois.close();
			}
			catch(Exception ee){
			}
		}
	}

	public static void search(){
		for (Page p:heap){
			for(Businesses b:p.businesses){
				//System.out.println(b);
				if(b.getBusinessName().toLowerCase().contains(searchQuery.toLowerCase())){
					System.out.println("======================================================");
					System.out.println("Business Name: " + b.getBusinessName());
					System.out.println("Reg Status: " + b.getStatus());
					System.out.println("Reg Date: " + b.getRegDate());
					System.out.println("Cancel Date: " + b.getCancelDate());
					System.out.println("Renew Date: " + b.getRenewDate());
					System.out.println("State Number: " + b.getStateNum());
					System.out.println("Reg State: " + b.getRegState());
					System.out.println("ABN: " + b.getAbn());
					System.out.println("======================================================");
					System.out.println();
					businessesFound++;
				}
			}
			pagesSearched++;
		}
	}

	public static void stdout(){
		System.out.println("Businesses Found: " + businessesFound);
		System.out.println("Pages searched: "+ pagesSearched);
		System.out.println("Time Taken: " + (endTime - startTime) +"ms");	
	}
	public static void main(String[] args) {
		if(args.length >= 2){
			try{
				pageSize = Integer.parseInt(args[1]);
			} 
			catch(NumberFormatException e){
				pageSize = 4096;
				System.out.println("Pagesize was not a number defaulting to 4096");
			}
			File f = new File("heap." + pageSize);
			searchQuery = args[0];

			System.out.println("Reading File");
			readFile(f);
			startTime = System.currentTimeMillis();
			System.out.println("Searching");
			search();
			endTime = System.currentTimeMillis();
			stdout();
					
		}
		else{
			System.out.println("Run format: java dbquery [text] [pagesize]");
		}
	}
}