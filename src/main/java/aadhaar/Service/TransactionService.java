package aadhaar.Service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aadhaar.Dto.TransactionSummary;
import aadhaar.Model.MonthArchive;
import aadhaar.Model.PusedSummary;
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
		            .collect(Collectors.toList());

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
		            .collect(Collectors.toList());

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
		    	    .filter(m -> "-OTP-".equals(m.getPused()))   // ✅ exact match only
		    	    .collect(Collectors.toList());

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
		            .collect(Collectors.toList());

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
	 private TransactionSummary buildSummary(List<MonthArchive> list) {
		    TransactionSummary summary = new TransactionSummary();

		    // ---- TOTAL ----
		    long total = (long) list.stream().mapToDouble(MonthArchive::getTranscation).sum();
		    long success = (long) list.stream().filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();
		    long failed = (long) list.stream().filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();

		    summary.setTotalTransactions(total);
		    summary.setTotalSuccess(success);
		    summary.setTotalFailed(failed);

		    // ---- AUTH ----
		    List<MonthArchive> auth = list.stream()
		            .filter(m -> m.getPused() != null && m.getPused().startsWith("AUTH"))
		            .collect(Collectors.toList());

		    long authTotal = (long) auth.stream().mapToDouble(MonthArchive::getTranscation).sum();
		    long authSuccess = (long) auth.stream().filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();
		    long authFailed = (long) auth.stream().filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();

		    summary.setAuthTotal(authTotal);
		    summary.setAuthSuccess(authSuccess);
		    summary.setAuthFailed(authFailed);

		    // ---- KYC ----
		    List<MonthArchive> kyc = list.stream()
		            .filter(m -> m.getPused() != null && m.getPused().contains("KYC"))
		            .collect(Collectors.toList());

		    long kycTotal = (long) kyc.stream().mapToDouble(MonthArchive::getTranscation).sum();
		    long kycSuccess = (long) kyc.stream().filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();
		    long kycFailed = (long) kyc.stream().filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();

		    summary.setKycTotal(kycTotal);
		    summary.setKycSuccess(kycSuccess);
		    summary.setKycFailed(kycFailed);

		    // ---- OTP ----
		    List<MonthArchive> otp = list.stream()
		            .filter(m -> "-OTP-".equals(m.getPused()))
		            .collect(Collectors.toList());

		    long otpTotal = (long) otp.stream().mapToDouble(MonthArchive::getTranscation).sum();
		    long otpSuccess = (long) otp.stream().filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();
		    long otpFailed = (long) otp.stream().filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();

		    summary.setOtpTotal(otpTotal);
		    summary.setOtpSuccess(otpSuccess);
		    summary.setOtpFailed(otpFailed);

		    // ---- TOKEN ----
		    List<MonthArchive> token = list.stream()
		            .filter(m -> m.getPused() != null && m.getPused().contains("TKN"))
		            .collect(Collectors.toList());

		    long tokenTotal = (long) token.stream().mapToDouble(MonthArchive::getTranscation).sum();
		    long tokenSuccess = (long) token.stream().filter(m -> "y".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();
		    long tokenFailed = (long) token.stream().filter(m -> "n".equalsIgnoreCase(m.getRet()))
		            .mapToDouble(MonthArchive::getTranscation).sum();

		    summary.setTokenTotal(tokenTotal);
		    summary.setTokenSuccess(tokenSuccess);
		    summary.setTokenFailed(tokenFailed);

		    return summary;
		}
	 public TransactionSummary getsscSummary() {

		    // Fetch current & archive records
		    List<MonthArchive> currentList = repo.getsscAllRecords();
		    List<MonthArchive> archiveList = repo.getArchiveAllRecords();

		    // Build summaries
		    TransactionSummary currentSummary = buildSummary(currentList);
		    TransactionSummary archiveSummary = buildSummary(archiveList);

		    // Subtract to get "last 2 minutes" data
		    TransactionSummary recentSummary = new TransactionSummary();

		    recentSummary.setTotalTransactions(currentSummary.getTotalTransactions() - archiveSummary.getTotalTransactions());
		    recentSummary.setTotalSuccess(currentSummary.getTotalSuccess() - archiveSummary.getTotalSuccess());
		    recentSummary.setTotalFailed(currentSummary.getTotalFailed() - archiveSummary.getTotalFailed());

		    recentSummary.setAuthTotal(currentSummary.getAuthTotal() - archiveSummary.getAuthTotal());
		    recentSummary.setAuthSuccess(currentSummary.getAuthSuccess() - archiveSummary.getAuthSuccess());
		    recentSummary.setAuthFailed(currentSummary.getAuthFailed() - archiveSummary.getAuthFailed());

		    recentSummary.setKycTotal(currentSummary.getKycTotal() - archiveSummary.getKycTotal());
		    recentSummary.setKycSuccess(currentSummary.getKycSuccess() - archiveSummary.getKycSuccess());
		    recentSummary.setKycFailed(currentSummary.getKycFailed() - archiveSummary.getKycFailed());

		    recentSummary.setOtpTotal(currentSummary.getOtpTotal() - archiveSummary.getOtpTotal());
		    recentSummary.setOtpSuccess(currentSummary.getOtpSuccess() - archiveSummary.getOtpSuccess());
		    recentSummary.setOtpFailed(currentSummary.getOtpFailed() - archiveSummary.getOtpFailed());

		    recentSummary.setTokenTotal(currentSummary.getTokenTotal() - archiveSummary.getTokenTotal());
		    recentSummary.setTokenSuccess(currentSummary.getTokenSuccess() - archiveSummary.getTokenSuccess());
		    recentSummary.setTokenFailed(currentSummary.getTokenFailed() - archiveSummary.getTokenFailed());

		    return recentSummary;
		}
	 public TransactionSummary getCurrentSSC() {
		    return buildSummary(repo.getsscAllRecords());
		}
	 
	 public List<PusedSummary> getCurrentVsRecentSummary() {
		    List<MonthArchive> currentList = repo.getsscAllRecords();
		    List<MonthArchive> archiveList = repo.getArchiveAllRecords();

		    Map<String, List<MonthArchive>> currentMap = currentList.stream()
		            .collect(Collectors.groupingBy(MonthArchive::getPused));

		    Map<String, List<MonthArchive>> archiveMap = archiveList.stream()
		            .collect(Collectors.groupingBy(MonthArchive::getPused));

		    Set<String> allPused = new HashSet<>();
		    allPused.addAll(currentMap.keySet());
		    allPused.addAll(archiveMap.keySet());

		    List<PusedSummary> summaries = new ArrayList<>();

		    long totalCurrTotal = 0, totalCurrSuccess = 0, totalCurrFailed = 0;
		    long totalArchTotal = 0, totalArchSuccess = 0, totalArchFailed = 0;

		    for (String pused : allPused) {
		        List<MonthArchive> current = currentMap.getOrDefault(pused, Collections.emptyList());
		        List<MonthArchive> archive = archiveMap.getOrDefault(pused, Collections.emptyList());

		        long currTotal = sum(current);
		        long currSuccess = sum(current.stream().filter(m -> "y".equalsIgnoreCase(m.getRet())).collect(Collectors.toList()));
		        long currFailed = sum(current.stream().filter(m -> "n".equalsIgnoreCase(m.getRet())).collect(Collectors.toList()));

		        long archTotal = sum(archive);
		        long archSuccess = sum(archive.stream().filter(m -> "y".equalsIgnoreCase(m.getRet())).collect(Collectors.toList()));
		        long archFailed = sum(archive.stream().filter(m -> "n".equalsIgnoreCase(m.getRet())).collect(Collectors.toList()));

		        // ✅ Clamp negatives to zero
		        long recentTotal = Math.max(0, currTotal - archTotal);
		        long recentSuccess = Math.max(0, currSuccess - archSuccess);
		        long recentFailed = Math.max(0, currFailed - archFailed);

		        PusedSummary s = new PusedSummary();
		        s.setPused(pused);

		        // current
		        s.setCurrentTotal(currTotal);
		        s.setCurrentSuccess(currSuccess);
		        s.setCurrentFailed(currFailed);
		        s.setCurrentSuccessPct(percent(currSuccess, currTotal));
		        s.setCurrentFailedPct(percent(currFailed, currTotal));

		        // recent
		        s.setRecentTotal(recentTotal);
		        s.setRecentSuccess(recentSuccess);
		        s.setRecentFailed(recentFailed);
		        s.setRecentSuccessPct(percent(recentSuccess, recentTotal));
		        s.setRecentFailedPct(percent(recentFailed, recentTotal));

		        summaries.add(s);

		        // accumulate totals
		        totalCurrTotal += currTotal;
		        totalCurrSuccess += currSuccess;
		        totalCurrFailed += currFailed;
		        totalArchTotal += archTotal;
		        totalArchSuccess += archSuccess;
		        totalArchFailed += archFailed;
		    }

		    // --- Add TOTAL row ---
		    PusedSummary totalRow = new PusedSummary();
		    totalRow.setPused("TOTAL");

		    totalRow.setCurrentTotal(totalCurrTotal);
		    totalRow.setCurrentSuccess(totalCurrSuccess);
		    totalRow.setCurrentFailed(totalCurrFailed);
		    totalRow.setCurrentSuccessPct(percent(totalCurrSuccess, totalCurrTotal));
		    totalRow.setCurrentFailedPct(percent(totalCurrFailed, totalCurrTotal));

		    // ✅ Clamp negatives in totals too
		    long totalRecentTotal = Math.max(0, totalCurrTotal - totalArchTotal);
		    long totalRecentSuccess = Math.max(0, totalCurrSuccess - totalArchSuccess);
		    long totalRecentFailed = Math.max(0, totalCurrFailed - totalArchFailed);

		    totalRow.setRecentTotal(totalRecentTotal);
		    totalRow.setRecentSuccess(totalRecentSuccess);
		    totalRow.setRecentFailed(totalRecentFailed);
		    totalRow.setRecentSuccessPct(percent(totalRecentSuccess, totalRecentTotal));
		    totalRow.setRecentFailedPct(percent(totalRecentFailed, totalRecentTotal));

		    summaries.add(0, totalRow); // put TOTAL at top

		    return summaries;
		}

		// ✅ Safe sum method (handles Double/Integer/Long)
		private long sum(List<MonthArchive> list) {
		    return list.stream()
		               .mapToLong(m -> (m.getTranscation() == null ? 0 : m.getTranscation().longValue()))
		               .sum();
		}


		private double percent(long part, long total) {
		    return total == 0 ? 0.0 : (part * 100.0 / total);
		}
	 
}
