package com.zhela.android.core.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FormFile {
	private InputStream inStream;
	private String fileName;
	private String formname = "attachmentFile";
	private String contentType = "application/octet-stream";
	
	public FormFile(String fileName,String formName) throws Exception{
		File file = new File(fileName);
		if(file.exists()&&file.isFile()){
			this.fileName = fileName;
			this.inStream = new FileInputStream(file);
			this.formname = formName;
		}else{
			throw new Exception("can't find the file");
		}
	}

	public InputStream getInStream() {
		return inStream;
	}

	public void setInStream(InputStream inStream) {
		this.inStream = inStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFormname() {
		return formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
