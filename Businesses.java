import java.io.*;

public class Businesses implements Serializable{
	private String businessName, regDate, cancelDate, renewDate, stateNum, regState, abn;
	private boolean status;

	public Businesses(String businessName, Boolean status, String regDate){
		this.businessName = businessName;
		this.status = status;
		this.regDate = regDate;
	}

	public String getBusinessName(){return businessName;}

	public boolean getStatus(){return status;}

	public String getRegDate(){return regDate;}

	public String getCancelDate(){return cancelDate;}

	public String getRenewDate(){return renewDate;}

	public String getStateNum(){return stateNum;}
	
	public String getRegState(){return regState;}

	public String getAbn(){return abn;}

	public void setBusinessName(String businessName){
		this.businessName = businessName;
	}

	public void setStatus(Boolean status){
		this.status = status;
	}

	public void setRegDate(String regDate){
		this.regDate = regDate;
	}

	public void setcancelDate(String cancelDate){
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

	public String toString(){
		return "BN_Name: " + businessName + " BN_Status: " + status + " BN_RegDate: " + regDate;
	}
}