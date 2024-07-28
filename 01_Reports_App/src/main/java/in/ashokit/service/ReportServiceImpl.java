package in.ashokit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.collection.PdfTargetDictionary;

import in.ashokit.entity.CitizensPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.request.SearchRequest;
import in.ashokit.util.ExcelGenerator;
import in.ashokit.util.PdfGenerator;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private CitizenPlanRepository planRepo;
    
    @Autowired
    private ExcelGenerator excelGenerator;
    
    @Autowired
    private PdfGenerator pdfGenerator;

    @Override
    public List<String> getplanName() {
        return planRepo.getPlanNames();
    }

    @Override
    public List<String> getplanStatus() {
        return planRepo.getPlanStatuses();
    }

    @Override
    public List<CitizensPlan> search(SearchRequest request) {
        CitizensPlan entity = new CitizensPlan();

        if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
            entity.setPlanName(request.getPlanName());
        }

        if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
            entity.setPlanStatus(request.getPlanStatus());
        }

        if (null != request.getGender() && !"".equals(request.getGender())) {
            entity.setGender(request.getGender());
        }

        // If no criteria are provided, return all records
        if (entity.getPlanName() == null && entity.getPlanStatus() == null && entity.getGender() == null) {
            return planRepo.findAll();
        }

        return planRepo.findAll(Example.of(entity));
    }

    @Override
    public boolean exportExcel(HttpServletResponse response) throws Exception{
        
    	List<CitizensPlan> plans = planRepo.findAll();
    	excelGenerator.generate(response, plans);
    	return true;
    }

   @Override
   public boolean exportPdf(HttpServletResponse response) throws Exception {

	   	List<CitizensPlan> plans = planRepo.findAll();
	   	pdfGenerator.generate(response, plans);
	   	return true;
}
}
