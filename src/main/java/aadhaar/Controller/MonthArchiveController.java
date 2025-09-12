package aadhaar.Controller;

import aadhaar.Dto.TransactionSummary;
import aadhaar.Model.MonthArchive;
import aadhaar.Model.PusedSummary;
import aadhaar.Repository.MonthArchiveRepository;
import aadhaar.Service.MonthArchiveService;
import aadhaar.Service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan("aadhaar")
@RequestMapping("/api")
@CrossOrigin(origins = "*") // allow React frontend
public class MonthArchiveController {
    private final MonthArchiveService service;
    @Autowired
    private TransactionService transactionService;
    public MonthArchiveController(MonthArchiveService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String home() {
        return " forward:/index.html"; // or forward to index.html if you have one
    }
    @GetMapping("/montharchive")
    public List<MonthArchive> getAllRecords() {
    	
        return service.getAllRecords();
    }
    @GetMapping("/montharchiveprojectwise")
    public List<MonthArchive> getAllRecordsprojectwise() {
    	System.out.println(service.getAllprojectRecords().size());
        return service.getAllprojectRecords();
    }
    @GetMapping("/ssc-summary")
    public List<PusedSummary> getSscSummary() {
        return transactionService.getCurrentVsRecentSummary();
    }
   
    @GetMapping("/montharchivessc")
    public List<MonthArchive> getArchiveAllRecords() {
        return service.getArchiveAllRecords();
    }

    // ✅ Recent SSC summary (last 2 minutes = current - archive)
    @GetMapping("/montharchivessc/recent")
    public TransactionSummary getRecentSSC() {
        return transactionService.getsscSummary();
    }
    @GetMapping("/summary")
    public TransactionSummary getSummary() {
        return transactionService.getSummary();
    }
    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}