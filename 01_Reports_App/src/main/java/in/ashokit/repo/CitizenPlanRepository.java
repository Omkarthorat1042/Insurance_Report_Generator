package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.CitizensPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizensPlan, Integer> {
    
    @Query("select distinct c.planName from CitizensPlan c")
    public List<String> getPlanNames();

    @Query("select distinct c.planStatus from CitizensPlan c")
    public List<String> getPlanStatuses();
}

