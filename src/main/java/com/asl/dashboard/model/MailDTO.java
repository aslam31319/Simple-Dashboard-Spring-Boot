package com.asl.dashboard.model;

import java.io.File;

public class MailDTO {
	

	private String mailTo;
	private String subject;
	private String body;
	private String fileEXT;
	private File file;
	
	
	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileEXT() {
		return fileEXT;
	}

	public void setFileEXT(String fileEXT) {
		this.fileEXT = fileEXT;
	}

	
	

}
