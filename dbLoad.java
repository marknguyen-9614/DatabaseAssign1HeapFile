import java.io.*;


public class dbload{
	static int pageSize;
	static ArraList<Page> page = new ArraList<Page>();
	public static void main(String[] args) {
		//File f = new File("FormattedDataWithCounterNewNoNull.csv");
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
			}
		}
		else{
			System.out.println("Run format : java dbload -p [pagesize] [file]");
		}
		
	}

	public static void readLines(File f) throws IOException{
		Businesses businesses = null;
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		br.readLine();
		while((line = br.readLine()) != null){
			boolean regStatus = true;
			String[] values = line.split("\t");
			if(values[2].equals("Deregistered")){
				regStatus = false;
			}
			businesses = new Businesses(values[1],regStatus,values[3]);

			
		}
		br.close();
		fr.close();

	}
}