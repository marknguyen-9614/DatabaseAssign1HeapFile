import java.io.*;
import java.util.*;

public class dbload{
	static int pageSize;
	static int numOfBusinesses = 0;
	static int numOfPages = 0;
	static long startTime = 0;
	static long endTime = 0;
	static long totalTime = 0;

	static ArrayList<Page> heap = new ArrayList<Page>();
	public static void main(String[] args) {
		//File f = new File("FormattedDataWithCounterNewNoNull.csv");
		startTime = System.currentTimeMillis();
		if(args.length >= 3 ){
			if(args[0].equals("-p")){
				File f = new File(args[2]);
				try{
					pageSize = Integer.parseInt(args[1]);
				} catch(NumberFormatException e){
					pageSize = 4096;
					System.out.println("Pagesize was not a number defaulting to 4096");
				}
				
				try{
					readLines(f);
				} 
				catch(IOException e){
					e.printStackTrace();
				}
				System.out.println("Finished Reading File");

				writeLines();
				System.out.println("Finsihed Writing File");
				endTime = System.currentTimeMillis();
				stdout();

			}
		}
		else{
			System.out.println("Run format : java dbload -p [pagesize] [file]");
		}
		
	}

	public static void readLines(File f) throws IOException{
		Businesses businesses = null;
		Page page = new Page(pageSize);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		br.readLine();
		boolean regStatus = true;
		while((line = br.readLine()) != null){
			regStatus = true;
			String[] values = line.split("\t");
			if(values[2].equals("Deregistered")){
				regStatus = false;
			}
			businesses = new Businesses(values[1],regStatus,values[3]);
			if(!(values.length < 5)){
				if(values[4] !=null){
					businesses.setCancelDate(values[4]);
				}
				if(!(values.length < 6)){
					if(values[5] != null){
						businesses.setRenewDate(values[5]);
					}
					if(!(values.length < 7)){
						if(values[6] != null){
							businesses.setStateNum(values[6]);
						}
						if(!(values.length <8)){
							if(values[7] != null){
								businesses.setRegState(values[7]);
							}
							if(!(values.length <9)){
								if(values[8] != null){
									businesses.setAbn(values[8]);
								}	
							}
						}
					}
				}
			}
			if(page.getPageSize()+businesses.byteAllocation() < pageSize){
				page.addBusinesses(businesses);
				System.out.println(businesses);
			}
			else{
				numOfPages++;
				heap.add(page);
				page = new Page(pageSize);
				page.addBusinesses(businesses);
				System.out.println(numOfPages);
			}

			//System.out.println(businesses);
			numOfBusinesses++;
			
		}
		br.close();
		fr.close();
	}

	public static void writeLines(){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try{
			fos = new FileOutputStream("heap."+pageSize);
			oos = new ObjectOutputStream(fos);
			for(Page p:heap){
				if(p != null){
					oos.writeObject(p);
				}
			}
			fos.close();
			oos.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public static void stdout(){
		System.out.println("Number of Businesses: " + numOfBusinesses);
		System.out.println("Number of Pages: " + numOfPages);
		System.out.println("Time Taken: " + (endTime - startTime) +"ms");
	}

}