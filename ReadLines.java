import java.io.*;


public class ReadLines{

	public static void main(String[] args) {
		//File f = new File("FormattedDataWithCounterNewNoNull.csv");
		File f = new File("BUSINESS_NAMES_201803.csv");
		try{
			readLines(f);
		} 
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void readLines(File f) throws IOException{
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
			String[] values = line.split("\t");
			for(String str : values){
				System.out.println(str);
			}
			
		}
		br.close();
		fr.close();

	}
}