/**
 * Yan Chen
 */
package com.zhelazhela.actions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.zhelazhela.util.ConsVar;

/**
 * @author Yan Chen
 * 
 */
public class ValidateCodeAction extends BaseAction {

	
	public static java.util.List<String> s_names = new java.util.ArrayList<String>();
	static{
		s_names.add("validate_code");
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2620679226905081661L;
	
	private String sessionName;

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	public String execute() throws Exception {
		int width=60, height=20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200,250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		g.setColor(getRandColor(160,200));
		for (int i=0;i<155;i++)
		{
		 int x = random.nextInt(width);
		 int y = random.nextInt(height);
		        int xl = random.nextInt(12);
		        int yl = random.nextInt(12);
		 g.drawLine(x,y,x+xl,y+yl);
		}
		String sRand="";
		for (int i=0;i<4;i++){
		    String rand=String.valueOf(random.nextInt(10));
		    sRand+=rand;
		    g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
		    g.drawString(rand,13*i+6,16);
		}
		saveSession(sessionName,sRand);
		g.dispose();
		HttpServletResponse response = getHttpServletResponse();
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		ImageIO.write(image, "JPEG", response.getOutputStream());
		return null;
	}
	
	public void validate() {
		if(!s_names.contains(sessionName)){
			return;
		}
	}
	
	public String ValidateCode()throws Exception{
		int width=158, height=65;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Chiller",Font.BOLD,50));
		g.setColor(new Color(255, 0, 0));
		String sRand="";
		for (int i=0;i<8;i++){
		    String rand= ""+ConsVar.CONSTANT_ABC[random.nextInt(26)];
		    sRand+=rand;
		    g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
		    g.drawString(rand,18*i+8,42);
		}
		this.getHttpSession().setAttribute(sessionName,sRand);
		g.dispose();
		this.getHttpServletResponse().setHeader("Pragma","No-cache");
		this.getHttpServletResponse().setHeader("Cache-Control","no-cache");
		this.getHttpServletResponse().setDateHeader("Expires", 0);
		try {
			ImageIO.write(image, "JPEG", this.getHttpServletResponse().getOutputStream());
		} catch (IOException e) {
			
		}
		return null;
	}
}
