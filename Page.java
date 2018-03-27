import java.io.*;
import java.util.*;

public class Page implements Serializable{
	int pageNum = 0;
	int pageSize = 0;
	ArrayList<Businesses> businesses = new ArrayList<Businesses>();
	

	public Page(int size){
		pageSize = size;
		pageNum++;
	}
	public void addBusinesses(Businesses loadLine){
		businesses.add(loadLine);
	}

	public ArrayList<Businesses> getBusinesses(){
		return businesses;
	}

	public int getPageNum(){
		return pageNum;
	}

	public int getPageSize(){
		int pageSize = 0;
		for(Businesses business : businesses){
			pageSize += business.byteAllocation();
		}
		return pageSize;
	}
}