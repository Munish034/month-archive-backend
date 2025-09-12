package aadhaar.Model;


public class PusedSummary {
    private String pused;

    // current
    private long currentTotal;
    private long currentSuccess;
    private long currentFailed;
    private double currentSuccessPct;
    private double currentFailedPct;

    // recent
    private long recentTotal;
    private long recentSuccess;
    private long recentFailed;
    private double recentSuccessPct;
    private double recentFailedPct;
	public String getPused() {
		return pused;
	}
	public void setPused(String pused) {
		this.pused = pused;
	}
	public long getCurrentTotal() {
		return currentTotal;
	}
	public void setCurrentTotal(long currentTotal) {
		this.currentTotal = currentTotal;
	}
	public long getCurrentSuccess() {
		return currentSuccess;
	}
	public void setCurrentSuccess(long currentSuccess) {
		this.currentSuccess = currentSuccess;
	}
	public long getCurrentFailed() {
		return currentFailed;
	}
	public void setCurrentFailed(long currentFailed) {
		this.currentFailed = currentFailed;
	}
	public double getCurrentSuccessPct() {
		return currentSuccessPct;
	}
	public void setCurrentSuccessPct(double currentSuccessPct) {
		this.currentSuccessPct = currentSuccessPct;
	}
	public double getCurrentFailedPct() {
		return currentFailedPct;
	}
	public void setCurrentFailedPct(double currentFailedPct) {
		this.currentFailedPct = currentFailedPct;
	}
	public long getRecentTotal() {
		return recentTotal;
	}
	public void setRecentTotal(long recentTotal) {
		this.recentTotal = recentTotal;
	}
	public long getRecentSuccess() {
		return recentSuccess;
	}
	public void setRecentSuccess(long recentSuccess) {
		this.recentSuccess = recentSuccess;
	}
	public long getRecentFailed() {
		return recentFailed;
	}
	public void setRecentFailed(long recentFailed) {
		this.recentFailed = recentFailed;
	}
	public double getRecentSuccessPct() {
		return recentSuccessPct;
	}
	public void setRecentSuccessPct(double recentSuccessPct) {
		this.recentSuccessPct = recentSuccessPct;
	}
	public double getRecentFailedPct() {
		return recentFailedPct;
	}
	public void setRecentFailedPct(double recentFailedPct) {
		this.recentFailedPct = recentFailedPct;
	}

    // getters and setters
    // ...
}