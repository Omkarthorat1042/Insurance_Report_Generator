package in.ashokit.util;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizensPlan;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

    // No need for planRepo in this class if it's not used

    public boolean generate(HttpServletResponse response, List<CitizensPlan> records) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Plans-Data");
        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Citizen Name");
        headerRow.createCell(2).setCellValue("Plan Name");
        headerRow.createCell(3).setCellValue("Plan Status");
        headerRow.createCell(4).setCellValue("Plan Start Date");
        headerRow.createCell(5).setCellValue("Plan End Date");
        headerRow.createCell(6).setCellValue("Benefit Amount");

        int dataRowIndex = 1;

        for (CitizensPlan plan : records) {
            Row dataRow = sheet.createRow(dataRowIndex++);
            dataRow.createCell(0).setCellValue(plan.getCitizenId());
            dataRow.createCell(1).setCellValue(plan.getCitizenName());
            dataRow.createCell(2).setCellValue(plan.getPlanName());
            dataRow.createCell(3).setCellValue(plan.getPlanStatus());
            dataRow.createCell(4).setCellValue(plan.getPlanStartDate());
            dataRow.createCell(5).setCellValue(plan.getPlanEndDate());
            dataRow.createCell(6).setCellValue(plan.getBenefitAmt() != null ? plan.getBenefitAmt().toString() : "N/A");
        }

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=plans.xls");

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            workbook.write(outputStream);
        } finally {
            workbook.close();
        }

        return true;
    }
}
