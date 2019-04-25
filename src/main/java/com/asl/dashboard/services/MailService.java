package com.asl.dashboard.services;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.asl.dashboard.model.MailDTO;
import com.itextpdf.text.DocumentException;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private FileService fileService;

	public boolean sendSimpleMail(MailDTO mail) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("no-repaly@gmail.com");
		message.setTo(mail.getMailTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getBody());
		mailSender.send(message);
		return true;
	}

	public boolean sendMimeMail(MailDTO mail, HttpServletRequest req) {
		if (mail.getFileEXT().equals("CSV")) {
			try {
				mail.setFile(fileService.generateCSV(req));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (mail.getFileEXT().equals("PDF")) {
			try {
				mail.setFile(fileService.generatePDF(req));
			} catch (IOException | DocumentException e) {
				e.printStackTrace();
			}
		}
		if (mail.getFileEXT().equals("CSV")) {
			try {
				mail.setFile(fileService.generateCSV(req));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		MimeMessage mimeMail = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMail, true);
			helper.setFrom("no-reply@spring.com");
			helper.setTo(mail.getMailTo());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getBody());
			helper.addAttachment(mail.getFile().getName(),mail.getFile());
			Thread mailThread =new Thread(()->mailSender.send(mimeMail));
			mailThread.start();
			
			
		} catch (MessagingException e) {

			e.printStackTrace();
		}
		return true;
	}
}
