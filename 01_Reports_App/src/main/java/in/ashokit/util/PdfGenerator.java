package in.ashokit.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokit.entity.CitizensPlan;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	public boolean generate(HttpServletResponse response, List<CitizensPlan> plans) throws Exception {
	
	
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Paragraph p = new Paragraph("Citizen's Plan Information");
		document.add(p);
		  
		
		PdfPTable table = new PdfPTable(6);
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan status");
		table.addCell("Start Date");
		table.addCell("End Date");
		
		
		
		for(CitizensPlan plan : plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanStatus());
			table.addCell(String.valueOf(plan.getPlanStartDate()));
			table.addCell(String.valueOf(plan.getPlanEndDate()));
		}
		
		document.add(table);
		document.close();
		
		return true;
				
	}
	
}
