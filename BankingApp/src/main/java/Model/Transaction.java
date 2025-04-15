package Model;

import java.util.Date;

public class Transaction {
	private long ACCNO;
	private float FUND;
	private Date TRANSDATE;
	private float CURRBAL;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getACCNO() {
		return ACCNO;
	}

	public void setACCNO(long aCCNO) {
		ACCNO = aCCNO;
	}

	public float getFUND() {
		return FUND;
	}

	public void setFUND(float fUND) {
		FUND = fUND;
	}

	public Date getTRANSDATE() {
		return TRANSDATE;
	}

	public void setTRANSDATE(Date tRANSDATE) {
		TRANSDATE = tRANSDATE;
	}

	public float getCURRBAL() {
		return CURRBAL;
	}

	public void setCURRBAL(float cURRBAL) {
		CURRBAL = cURRBAL;
	}

	public Transaction(long aCCNO, float fUND, Date tRANSDATE, float cURRBAL) {
		super();
		ACCNO = aCCNO;
		FUND = fUND;
		TRANSDATE = tRANSDATE;
		CURRBAL = cURRBAL;
	}

	@Override
	public String toString() {
		return "Transaction [ACCNO=" + ACCNO + ", FUND=" + FUND + ", TRANSDATE=" + TRANSDATE + ", CURRBAL=" + CURRBAL
				+ "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}


