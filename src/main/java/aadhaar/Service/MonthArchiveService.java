package aadhaar.Service;

import aadhaar.Model.MonthArchive;
import aadhaar.Repository.MonthArchiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MonthArchiveService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MonthArchiveService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MonthArchive> getAllRecords() {
        return jdbcTemplate.query(
            "SELECT * FROM month_arcrive",
            (rs, rowNum) -> {
                MonthArchive m = new MonthArchive();
                m.setLk(rs.getString("lk"));
                m.setDate(rs.getDate("date").toLocalDate());
                m.setSa(rs.getString("sa"));
                m.setPused(rs.getString("pused"));
                m.setRet(rs.getString("ret"));
                m.setTranscation(rs.getDouble("transcation"));
                return m;
            }
        );
    }

    
}