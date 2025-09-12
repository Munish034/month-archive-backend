package aadhaar.Model;

import java.time.LocalDate;


public class MonthArchive {

   
    private String lk;

    private LocalDate date;
    private String sa;
    private String sanull;
    private String pused;
    private String ret;
    private Double transcation;
    
 
	public String getSanull() {
		return sanull;
	}
	public void setSanull(String sanull) {
		this.sanull = sanull;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getSa() {
		return sa;
	}
	public void setSa(String sa) {
		this.sa = sa;
	}
	public String getLk() {
		return lk;
	}
	public void setLk(String lk) {
		this.lk = lk;
	}
	public String getPused() {
		return pused;
	}
	public void setPused(String pused) {
		this.pused = pused;
	}
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public Double getTranscation() {
		return transcation;
	}
	public void setTranscation(Double transcation) {
		this.transcation = transcation;
	}
	

    // getters and setters
}