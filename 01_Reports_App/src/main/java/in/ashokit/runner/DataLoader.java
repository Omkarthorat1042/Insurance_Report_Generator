package in.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizensPlan;
import in.ashokit.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	private CitizenPlanRepository repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		//cash plan data
		CitizensPlan c1 = new CitizensPlan();
		c1.setCitizenName("John");
		c1.setGender("Male");
		c1.setPlanName("Cash Plan");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(5000.00);
		
		
		CitizensPlan c2 = new CitizensPlan();
		c2.setCitizenName("Smith");
		c2.setGender("Male");
		c2.setPlanName("Cash Plan");
		c2.setPlanStatus("Denied");
		c2.setBenefitAmt(5000.00);
		c2.setDenialReason("Rent income");
		
		CitizensPlan c3 = new CitizensPlan();
		c3.setCitizenName("Cathly");
		c3.setGender("Female");
		c3.setPlanName("Cash Plan");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().plusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmt(5000.00);
		c3.setTerminationDate(LocalDate.now());
		c3.setTerminationRsn("Employeed");
		
		//food plan data
		CitizensPlan c4 = new CitizensPlan();
		c4.setCitizenName("David");
		c4.setGender("Male");
		c4.setPlanName("Food Plan");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmt(4000.00);
		
		
		CitizensPlan c5= new CitizensPlan();
		c5.setCitizenName("Robert");
		c5.setGender("Male");
		c5.setPlanName("Food Plan");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Income");
		
		
		CitizensPlan c6 = new CitizensPlan();
		c6.setCitizenName("Orlen");
		c6.setGender("Female");
		c6.setPlanName("Food Plan");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now());
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmt(5000.00);
		c6.setTerminationDate(LocalDate.now());
		c6.setTerminationRsn("Employeed");
		
		
		//Medical plan data
				CitizensPlan c7 = new CitizensPlan();
				c7.setCitizenName("Charles");
				c7.setGender("Male");
				c7.setPlanName("Medical Plan");
				c7.setPlanStatus("Approved");
				c7.setPlanStartDate(LocalDate.now());
				c7.setPlanEndDate(LocalDate.now().plusMonths(6));
				c7.setBenefitAmt(8000.00);
				
				
				CitizensPlan c8= new CitizensPlan();
				c8.setCitizenName("Robert");
				c8.setGender("Male");
				c8.setPlanName("Medical Plan");
				c8.setPlanStatus("Denied");
				c8.setDenialReason("Property Income");
				
				
				CitizensPlan c9 = new CitizensPlan();
				c9.setCitizenName("Neel");
				c9.setGender("Female");
				c9.setPlanName("Medical Plan");
				c9.setPlanStatus("Terminated");
				c9.setPlanStartDate(LocalDate.now());
				c9.setPlanEndDate(LocalDate.now().plusMonths(6));
				c9.setBenefitAmt(5000.00);
				c9.setTerminationDate(LocalDate.now());
				c9.setTerminationRsn("Govt Employeed");
	
				
				//Employment plan data
				CitizensPlan c10 = new CitizensPlan();
				c10.setCitizenName("Charles");
				c10.setGender("Male");
				c10.setPlanName("Employment Plan");
				c10.setPlanStatus("Approved");
				c10.setPlanStartDate(LocalDate.now());
				c10.setPlanEndDate(LocalDate.now().plusMonths(6));
				c10.setBenefitAmt(4000.00);
				
				
				CitizensPlan c11= new CitizensPlan();
				c11.setCitizenName("Robert");
				c11.setGender("Male");
				c11.setPlanName("Employment Plan");
				c11.setPlanStatus("Denied");
				c11.setDenialReason("Property Income");
				
				
				CitizensPlan c12 = new CitizensPlan();
				c12.setCitizenName("eelam");
				c12.setGender("Female");
				c12.setPlanName("Employment Plan");
				c12.setPlanStatus("Terminated");
				c12.setPlanStartDate(LocalDate.now());
				c12.setPlanEndDate(LocalDate.now().plusMonths(6));
				c12.setBenefitAmt(5000.00);
				c12.setTerminationDate(LocalDate.now());
				c12.setTerminationRsn("Govt Employeed");
		
		List<CitizensPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c5, c6, c7, c8, c9, c10, c11, c12);
		
		repo.saveAll(list);
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
}
