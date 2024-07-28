package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.CitizensPlan;
import in.ashokit.request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {

	public List<String> getplanName();
	
	public List<String> getplanStatus();
	
	public List<CitizensPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response) throws Exception; 
	
}
