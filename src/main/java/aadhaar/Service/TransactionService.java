package aadhaar.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aadhaar.Dto.TransactionSummary;
import aadhaar.Model.MonthArchive;
import aadhaar.Repository.MonthArchiveRepository;

@Service
public class TransactionService {
	
	 @Autowired
	    private MonthArchiveService repo;
	 
	 
	 public TransactionSummary getSummary() {
		 
		 List<MonthArchive> list = repo.getAllRecords();
		 TransactionSummary summary = new TransactionSummary();
		 
		// ---- TOTAL ----
		    long total = (long) list.stream()
		            .mapToDouble(MonthArchive::getTranscation)
		            .sum();

		    long success = (long) list.stream()
		            .filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation)
		            .sum();

		    long failed = (long) list.stream()
		            .filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation)
		            .sum();

		    summary.setTotalTransactions(total);
		    summary.setTotalSuccess(success);
		    summary.setTotalFailed(failed);

		    // ---- AUTH ----
		    List<MonthArchive> auth = list.stream()
		            .filter(m -> m.getPused().startsWith("AUTH"))
		            .toList();

		    long authTotal = (long) auth.stream().mapToDouble(MonthArchive::getTranscation).sum();
		    long authSuccess = (long) auth.stream()
		            .filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();
		    long authFailed = (long) auth.stream()
		            .filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();

		    summary.setAuthTotal(authTotal);
		    summary.setAuthSuccess(authSuccess);
		    summary.setAuthFailed(authFailed);

		    // ---- KYC ----
		    List<MonthArchive> kyc = list.stream()
		            .filter(m -> m.getPused().contains("KYC"))
		            .toList();

		    long kycTotal = (long) kyc.stream().mapToDouble(MonthArchive::getTranscation).sum();
		    long kycSuccess = (long) kyc.stream()
		            .filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();
		    long kycFailed = (long) kyc.stream()
		            .filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();

		    summary.setKycTotal(kycTotal);
		    summary.setKycSuccess(kycSuccess);
		    summary.setKycFailed(kycFailed);

		    // ---- OTP ----
		    List<MonthArchive> otp = list.stream()
		            .filter(m -> m.getPused().contains("OTP"))
		            .toList();

		    long otpTotal = (long) otp.stream().mapToDouble(MonthArchive::getTranscation).sum();
		    long otpSuccess = (long) otp.stream()
		            .filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();
		    long otpFailed = (long) otp.stream()
		            .filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();

		    summary.setOtpTotal(otpTotal);
		    summary.setOtpSuccess(otpSuccess);
		    summary.setOtpFailed(otpFailed);
		    
		    ///////token
		   
		    
		    
		    List<MonthArchive> token = list.stream()
		            .filter(m -> m.getPused() != null && m.getPused().contains("TKN"))
		            .toList();

		    // Total transaction sum (not count)
		    long tokenTotal = (long) token.stream()
		            .mapToDouble(MonthArchive::getTranscation)  // take transcation column
		            .sum();

		    // Success transaction sum
		    long tokenSuccess = (long) token.stream()
		            .filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation)
		            .sum();

		    // Failed transaction sum
		    long tokenFailed = (long) token.stream()
		            .filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation)
		            .sum();
		    

		    summary.setTokenTotal(tokenTotal);
		    summary.setTokenSuccess(tokenSuccess);
		    summary.setTokenFailed(tokenFailed);

		    return summary;
		}
}
