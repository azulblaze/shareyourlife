package com.zhelazhela.system.email;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.zhelazhela.domain.Mail;

/**
 * <code>MailServices.java</code>
 * @version 1.0, 2009-8-3
 */
public class MailServices {
	
private JavaMailSender mailSender = null;
	
	private String senderName = null;
	
	private String senderAddr = null;
	
	

	/**
	 * @param senderAddr the senderAddr to set
	 */
	public void setSenderAddr(String senderAddr) {
		this.senderAddr = senderAddr;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setMailSender(JavaMailSender mailSender){
		this.mailSender = mailSender;
	}
	
	public void setSenderName(String senderName){
		this.senderName = senderName;
	}
	
	public void sendMail(Mail mail){
		new MailThread(mail).start();
	}
	
	class MailThread extends Thread {
		
		private Logger log  = Logger.getLogger(MailThread.class);
		
		private Mail mail = null;
		
		public MailThread(Mail mail) {
			super();
			this.mail = mail;
		}

		public void run() {
			send();
		}
		
		private void send(){
			MimeMessage msg = mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg, true,
						"utf-8");
				helper.setTo(mail.getToAddr().split(";"));
				helper.setFrom(senderAddr,senderName);
				helper.setSubject(mail.getSubject());
				if(mail.getType().equals(Mail.MAIL_TYPE_HTML)){
					helper.setText(mail.getContent(), true);
				}else{
					helper.setText(mail.getContent(), false);
				}
				mailSender.send(msg);
				log.info("Send Mail:"+mail.toString());
			} catch (Exception e) {
				log.info("Send Email Exception:",e);
			}
		}
	}
	
}
