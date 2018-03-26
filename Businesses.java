import java.io.*;

public class Businesses implements Serializable{
	private String buinessName, status, regDate, cancelDate, renewDate, stateNum, regState, abn;
	private int ID;

	public Businesses(int ID, String buinessName, String status, String regDate, String cancelDate, String renewDate, String stateNum, String regState, String abn){
		this.ID = ID;
		this.buinessName = buinessName;
		this.status = status;
		this.regDate = regDate;
		this.cancelDate = cancelDate;
		this.renewDate = renewDate;
		this.stateNum = stateNum;
		this.regState = regState;
		this.abn = abn;
	}
	
}