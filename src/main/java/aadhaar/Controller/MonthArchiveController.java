package aadhaar.Controller;

import aadhaar.Dto.TransactionSummary;
import aadhaar.Model.MonthArchive;
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
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
public class MonthArchiveController {
    private final MonthArchiveService service;
    @Autowired
    private TransactionService transactionService;
    public MonthArchiveController(MonthArchiveService service) {
        this.service = service;
    }

    @GetMapping("/montharchive")
    public List<MonthArchive> getAllRecords() {
    	System.out.println(service.getAllRecords());
        return service.getAllRecords();
    }
    @GetMapping("/summary")
    public TransactionSummary getSummary() {
        return transactionService.getSummary();
    }
}