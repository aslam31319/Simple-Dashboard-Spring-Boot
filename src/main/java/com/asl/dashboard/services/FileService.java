package com.asl.dashboard.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.asl.dashboard.model.UserDTO;
import com.asl.dashboard.repository.UserRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class FileService {

	@Autowired
	private UserRepository userRepository;

	public void download(HttpServletRequest req, HttpServletResponse resp, String fileEXT) {

		if (fileEXT.equals("XLSX")) {

			try {
				downloadXLSX(req, resp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (fileEXT.equals("PDF")) {

			try {
				downloadPDF(req, resp);
			} catch (IOException | DocumentException e) {
				e.printStackTrace();
			}
		}
		if (fileEXT.equals("CSV")) {
			try {
				downloadCSV(req, resp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//
	public void downloadCSV(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		File file = generateCSV(req);

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype : " + mimeType);
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		System.out.println("mimetype by Auto : " + mimeType);
		resp.setContentType(mimeType);
		resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		resp.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, resp.getOutputStream());
	}

	public File generateCSV(HttpServletRequest req) throws IOException {
		File file = new File(req.getServletContext().getRealPath("/") + "user.csv");

		List<UserDTO> list = userRepository.findAll();
		FileWriter writer = new FileWriter(file);
		writer.write("User Id,First Name,Last Name,Phone,Email,Gender,Date of Birth,Country,State,City");

		for (UserDTO user : list) {
			writer.append('\n');
			writer.append("" + user.getUserId());
			writer.append(',');
			writer.append(user.getFirstName());
			writer.append(',');
			writer.append(user.getLastName());
			writer.append(',');
			writer.append(user.getPhone());
			writer.append(',');
			writer.append(user.getEmail());
			writer.append(',');
			writer.append(user.getGender());
			writer.append(',');
			writer.append(user.getDOB());
			writer.append(',');
			writer.append(user.getCountry());
			writer.append(',');
			writer.append(user.getState());
			writer.append(',');
			writer.append(user.getCity());
			writer.append(',');
		}
		writer.close();
		return file;
	}

	public void downloadPDF(HttpServletRequest req, HttpServletResponse resp) throws IOException, DocumentException {

		File file = generatePDF(req);

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype : " + mimeType);
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		System.out.println("mimetype by Auto : " + mimeType);
		resp.setContentType(mimeType);
		resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		resp.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, resp.getOutputStream());

	}

	public File generatePDF(HttpServletRequest req) throws IOException, DocumentException {

		Document my_pdf_report = new Document();
		PdfWriter.getInstance(my_pdf_report,
				new FileOutputStream(req.getServletContext().getRealPath("/") + "user.pdf"));
		my_pdf_report.open();

		// we have four columns in our table
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100); // Width 100%
		table.setSpacingBefore(10f); // Space before table
		table.setSpacingAfter(10f); // Space after table
		float[] columnWidths = { .5f, .75f, .75f, .65f, 1f };
		table.setWidths(columnWidths);

		// create a cell object
		PdfPCell table_cell;
		Font head = FontFactory.getFont(FontFactory.TIMES_BOLD);
		table_cell = new PdfPCell(new Paragraph("User Id", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("First Name", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Second Name", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Phone", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Email", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		/*
		 * table_cell = new PdfPCell(new Phrase("Gender")); table.addCell(table_cell);
		 * table_cell = new PdfPCell(new Phrase("Date of birth"));
		 * table.addCell(table_cell); table_cell = new PdfPCell(new Phrase("Country"));
		 * table.addCell(table_cell); table_cell = new PdfPCell(new Phrase("State"));
		 * table.addCell(table_cell); table_cell = new PdfPCell(new Phrase("City"));
		 * table.addCell(table_cell);
		 */

		// fetching all data
		List<UserDTO> list = userRepository.findAll();

		for (UserDTO user : list) {

			table_cell = new PdfPCell(new Phrase("" + user.getUserId()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getFirstName()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getLastName()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getPhone()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getEmail()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			/*
			 * table_cell = new PdfPCell(new Phrase(user.getGender()));
			 * table.addCell(table_cell); table_cell = new PdfPCell(new
			 * Phrase(user.getDOB())); table.addCell(table_cell); table_cell = new
			 * PdfPCell(new Phrase(user.getCountry())); table.addCell(table_cell);
			 * table_cell = new PdfPCell(new Phrase(user.getState()));
			 * table.addCell(table_cell); table_cell = new PdfPCell(new
			 * Phrase(user.getCity())); table.addCell(table_cell);
			 */
		}

		my_pdf_report.add(table);
		table.flushContent();

		table_cell = new PdfPCell(new Phrase("Gender", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Date of birth", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Country", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("State", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("City", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);

		for (UserDTO user : list) {

			table_cell = new PdfPCell(new Phrase(user.getGender()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getDOB()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getCountry()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getState()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getCity()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);

		}
		my_pdf_report.add(table);
		my_pdf_report.close();

		return new File(req.getServletContext().getRealPath("/") + "user.pdf");

	}

	public void downloadXLSX(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// opening file
		File file = generateXLSX(req);

		// setting mime type
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype : " + mimeType);
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		System.out.println("mimetype by Auto : " + mimeType);
		resp.setContentType(mimeType);
		System.out.println(file.getName());
		// setting header
		resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		resp.setContentLength((int) file.length());

		// copying to response
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, resp.getOutputStream());
	}

	public File generateXLSX(HttpServletRequest req) throws IOException {

		// fetching all data
		List<UserDTO> list = userRepository.findAll();

		// creating XLSX
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("User Details");
		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;
		cell = row.createCell(1);
		cell.setCellValue("User Id");
		cell = row.createCell(2);
		cell.setCellValue("First Name");
		cell = row.createCell(3);
		cell.setCellValue("Last Name");
		cell = row.createCell(4);
		cell.setCellValue("Phone");
		cell = row.createCell(5);
		cell.setCellValue("Email");
		cell = row.createCell(6);
		cell.setCellValue("Gender");
		cell = row.createCell(7);
		cell.setCellValue("Date of birth");
		cell = row.createCell(8);
		cell.setCellValue("Country");
		cell = row.createCell(9);
		cell.setCellValue("State");
		cell = row.createCell(10);
		cell.setCellValue("City");
		int i = 2;
		for (UserDTO user : list) {

			row = spreadsheet.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue(user.getUserId());
			cell = row.createCell(2);
			cell.setCellValue(user.getFirstName());
			cell = row.createCell(3);
			cell.setCellValue(user.getLastName());
			cell = row.createCell(4);
			cell.setCellValue(user.getPhone());
			cell = row.createCell(5);
			cell.setCellValue(user.getEmail());
			cell = row.createCell(6);
			cell.setCellValue(user.getGender());
			cell = row.createCell(7);
			cell.setCellValue(user.getDOB());
			cell = row.createCell(8);
			cell.setCellValue(user.getCountry());
			cell = row.createCell(9);
			cell.setCellValue(user.getState());
			cell = row.createCell(10);
			cell.setCellValue(user.getCity());
			i++;

		}
		File file = new File(req.getServletContext().getRealPath("/") + "user.xlsx");
		// saving to file
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		out.close();
		workbook.close();
		return file;
	}
}
