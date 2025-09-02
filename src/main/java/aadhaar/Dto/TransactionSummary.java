package aadhaar.Dto;

public class TransactionSummary {
	 private long totalTransactions;
	 private long totalSuccess;
	    private long totalFailed;

	    private long authTotal;
	    private long authSuccess;
	    private long authFailed;

	    private long kycTotal;
	    private long kycSuccess;
	    private long kycFailed;

	    private long otpTotal;
	    private long otpSuccess;
	    private long otpFailed;
	    
	    private long tokenTotal;
	    private long tokenSuccess;
	    private long tokenFailed;
	    public long getTokenTotal() {
		return tokenTotal;
	}
	 public void setTokenTotal(long tokenTotal) {
		 this.tokenTotal = tokenTotal;
	 }
	 public long getTokenSuccess() {
		 return tokenSuccess;
	 }
	 public void setTokenSuccess(long tokenSuccess) {
		 this.tokenSuccess = tokenSuccess;
	 }
	 public long getTokenFailed() {
		 return tokenFailed;
	 }
	 public void setTokenFailed(long tokenFailed) {
		 this.tokenFailed = tokenFailed;
	 }
		
	    
		public long getTotalTransactions() {
			return totalTransactions;
		}
		public void setTotalTransactions(long totalTransactions) {
			this.totalTransactions = totalTransactions;
		}
		public long getTotalSuccess() {
			return totalSuccess;
		}
		public void setTotalSuccess(long totalSuccess) {
			this.totalSuccess = totalSuccess;
		}
		public long getTotalFailed() {
			return totalFailed;
		}
		public void setTotalFailed(long totalFailed) {
			this.totalFailed = totalFailed;
		}
		public long getAuthTotal() {
			return authTotal;
		}
		public void setAuthTotal(long authTotal) {
			this.authTotal = authTotal;
		}
		public long getAuthSuccess() {
			return authSuccess;
		}
		public void setAuthSuccess(long authSuccess) {
			this.authSuccess = authSuccess;
		}
		public long getAuthFailed() {
			return authFailed;
		}
		public void setAuthFailed(long authFailed) {
			this.authFailed = authFailed;
		}
		public long getKycTotal() {
			return kycTotal;
		}
		public void setKycTotal(long kycTotal) {
			this.kycTotal = kycTotal;
		}
		public long getKycSuccess() {
			return kycSuccess;
		}
		public void setKycSuccess(long kycSuccess) {
			this.kycSuccess = kycSuccess;
		}
		public long getKycFailed() {
			return kycFailed;
		}
		public void setKycFailed(long kycFailed) {
			this.kycFailed = kycFailed;
		}
		public long getOtpTotal() {
			return otpTotal;
		}
		public void setOtpTotal(long otpTotal) {
			this.otpTotal = otpTotal;
		}
		public long getOtpSuccess() {
			return otpSuccess;
		}
		public void setOtpSuccess(long otpSuccess) {
			this.otpSuccess = otpSuccess;
		}
		public long getOtpFailed() {
			return otpFailed;
		}
		public void setOtpFailed(long otpFailed) {
			this.otpFailed = otpFailed;
		}


}
