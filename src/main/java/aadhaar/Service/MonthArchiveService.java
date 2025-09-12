package aadhaar.Service;

import aadhaar.Model.MonthArchive;
import aadhaar.Repository.MonthArchiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            "SELECT * FROM project",
            (rs, rowNum) -> {
                MonthArchive m = new MonthArchive();
                m.setLk(rs.getString("lk"));
					/*
					 * String dateStr = rs.getString("date"); DateTimeFormatter formatter =
					 * DateTimeFormatter.ofPattern("yyyy-M-d"); LocalDate localDate =
					 * LocalDate.parse(dateStr, formatter); m.setDate(localDate);
					 */
                m.setSa(rs.getString("sa"));
                m.setPused(rs.getString("pused"));
                m.setRet(rs.getString("ret"));
                m.setTranscation(rs.getDouble("uid"));
                return m;
            }
        );
    }
    public List<MonthArchive> getsscAllRecords() {
        return jdbcTemplate.query(
            "SELECT * FROM project where sa='DL016SSCAA'",
            (rs, rowNum) -> {
                MonthArchive m = new MonthArchive();
                m.setLk(rs.getString("lk"));
					/*
					 * String dateStr = rs.getString("date"); DateTimeFormatter formatter =
					 * DateTimeFormatter.ofPattern("yyyy-M-d"); LocalDate localDate =
					 * LocalDate.parse(dateStr, formatter); m.setDate(localDate);
					 */
                m.setSa(rs.getString("sa"));
                m.setPused(rs.getString("pused"));
                m.setRet(rs.getString("ret"));
                m.setTranscation(rs.getDouble("uid"));
                return m;
            }
        );
    }
    public List<MonthArchive> getArchiveAllRecords() {
        return jdbcTemplate.query(
            "SELECT * FROM arcrive_project WHERE sa='DL016SSCAA'",
            (rs, rowNum) -> {
                MonthArchive m = new MonthArchive();
                m.setLk(rs.getString("lk"));
                m.setSa(rs.getString("sa"));
                m.setPused(rs.getString("pused"));
                m.setRet(rs.getString("ret"));
                m.setTranscation(rs.getDouble("uid"));
                return m;
            }
        );
    }
    public List<MonthArchive> getAllprojectRecords() {
        return jdbcTemplate.query(
            "SELECT ma.lk,ma.sa,dv.project,ma.pused,ma.ret,ma.uid FROM project  ma left join projectdb.documents_validity  dv on ma.lk=dv.lk ;",
            (rs, rowNum) -> {
                MonthArchive m = new MonthArchive();
                m.setLk(rs.getString("lk"));
					/*
					 * String dateStr = rs.getString("date"); DateTimeFormatter formatter =
					 * DateTimeFormatter.ofPattern("yyyy-M-d"); LocalDate localDate =
					 * LocalDate.parse(dateStr, formatter); m.setDate(localDate);
					 */
                m.setSanull(rs.getString("sa"));
                m.setSa(rs.getString("project"));
                m.setPused(rs.getString("pused"));
                m.setRet(rs.getString("ret"));
                m.setTranscation(rs.getDouble("uid"));
                return m;
            }
        );
    }

    
}