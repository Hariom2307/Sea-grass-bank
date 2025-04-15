package Model;
import java.util.Date;

public class TransactionHistory {
	
	   
	    private long senderAccNo;
	    private long receiverAccNo;
	    
	    private float amount;
	    private Date transactionDate;
	    private float CURRBAL;
		public TransactionHistory() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public TransactionHistory(long senderAccNo, long receiverAccNo, float amount, Date transactionDate,
				float cURRBAL) {
			super();
			this.senderAccNo = senderAccNo;
			this.receiverAccNo = receiverAccNo;
			this.amount = amount;
			this.transactionDate = transactionDate;
			CURRBAL = cURRBAL;
		}

		public long getSenderAccNo() {
			return senderAccNo;
		}
		public void setSenderAccNo(long senderAccNo) {
			this.senderAccNo = senderAccNo;
		}
		public long getReceiverAccNo() {
			return receiverAccNo;
		}
		public void setReceiverAccNo(long receiverAccNo) {
			this.receiverAccNo = receiverAccNo;
		}
		public float getAmount() {
			return amount;
		}
		public void setAmount(float amount) {
			this.amount = amount;
		}
		public Date getTransactionDate() {
			return transactionDate;
		}
		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}
		public float getCURRBAL() {
			return CURRBAL;
		}
		public void setCURRBAL(float cURRBAL) {
			CURRBAL = cURRBAL;
		}
		
		
	    
}
