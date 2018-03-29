import java.io.*;

public class Businesses implements Serializable{
	private String businessName, regDate, cancelDate, renewDate, stateNum, regState, abn;
	private boolean status;

	public Businesses(String businessName, Boolean status, String regDate){
		this.businessName = businessName;
		this.status = status;
		this.regDate = regDate;
	}

	public String getBusinessName(){
		return businessName;
	}

	public boolean getStatus(){
		return status;
	}

	public String getRegDate(){
		return regDate;
	}

	public String getCancelDate(){
		return cancelDate;
	}

	public String getRenewDate(){
		return renewDate;
	}

	public String getStateNum(){
		return stateNum;
	}
	
	public String getRegState(){
		return regState;
	}

	public String getAbn(){
		return abn;
	}

	public void setBusinessName(String businessName){
		this.businessName = businessName;
	}

	public void setStatus(Boolean status){
		this.status = status;
	}

	public void setRegDate(String regDate){
		this.regDate = regDate;
	}

	public void setCancelDate(String cancelDate){
		this.cancelDate = cancelDate;
	}

	public void setRenewDate(String renewDate){
		this.renewDate = renewDate;
	}

	public void setStateNum(String stateNum){
		this.stateNum = stateNum;
	}

	public void setRegState(String regState){
		this.regState = regState;
	}

	public void setAbn(String abn){
		this.abn = abn;
	}
	//String fixed length 2 bytes per char via .length()
	//Boolean 1 byte
	public int byteAllocation(){
		int pageSize = 0;
		//businessName String
		pageSize += (200 * 2);
		//Status Boolean
		pageSize += 1;
		//regDate String
		pageSize += (10 *2);
		//cancelDate String
		if(cancelDate != null){
			pageSize += (10 *2);
		}
		//RenewDate String
		if(renewDate != null){
			pageSize += (10 *2);
		}
		//stateNum String
		if(stateNum != null){
			pageSize += (10 * 2);
		}
		//regState String
		if(regState != null){
			pageSize += (3 * 2);
		}
		//abn String
		if(abn != null){
			pageSize += (20 * 2);
		}

		return pageSize;
	}

	public String toString(){
		return "BN_Name: " + businessName + " BN_Status: " + status + " BN_RegDate: " + regDate;
	}
}