package aadhaar.Repository;

import aadhaar.Model.MonthArchive;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//Optional: empty interface
@Repository
public interface MonthArchiveRepository {
 // No methods needed; JdbcTemplate in service handles queries
}
