package Model;

public class UserAccount {
	private long accNo;
	
	private String branchCity;
	private String IFSCcode;
	UserRegister user;
	public UserAccount(long accNo, String branchCity, String iFSCcode, UserRegister user) {
		super();
		this.accNo = accNo;
		
		this.branchCity = branchCity;
		IFSCcode = iFSCcode;
		this.user = user;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	
	public String getBranchCity() {
		return branchCity;
	}
	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}
	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}
	public UserRegister getUser() {
		return user;
	}
	public void setUser(UserRegister user) {
		this.user = user;
	}
	
}
