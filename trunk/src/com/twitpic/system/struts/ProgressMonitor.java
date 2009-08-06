/*
 * ProgressMonitor.java
 *
 * Created on 26 November 2006, 22:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.twitpic.system.struts;

import java.text.NumberFormat;

import org.apache.commons.fileupload.ProgressListener;
import org.apache.log4j.Logger;

/**
 * This class is used to monitor the upload of a file from web page to the
 * server
 * 
 * @author dave
 */
public class ProgressMonitor implements ProgressListener {

	public static final String SESSION_PROGRESS_MONITOR = "com.twitpic.system.struts.ProgressMonitor";

	private static final Logger logger = Logger
			.getLogger(ProgressMonitor.class);
	private static final NumberFormat fmt = NumberFormat.getInstance();

	// Previous Values
	private long previousBytesRead;
	private int bytesReadNotChangedCount;

	// Current Values
	private long bytesRead;
	private long bytesLength;
	private boolean aborted = false;

	private String fileName = "na";

	static {
		fmt.setMaximumFractionDigits(0);
	}

	/** Creates a new instance of ProgressMonitor */
	public ProgressMonitor() {
		if (logger.isDebugEnabled())
			logger.debug("Creating Progress Monitor");
	}

	/**
	 * This is called by the notifier
	 */
	public void update(long pBytesRead, long pContentLength, int pItems) {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bytesRead = pBytesRead;
		bytesLength = pContentLength;
	}

	/**
	 * This looks at the previousBytesRead value which only will update when the
	 * file is being uploaded and it compares it against the current bytes read
	 * value passed in as a param. If they are the same more the 3 times, we
	 * assume the connection is broken and abort the upload.
	 * 
	 * This is another safety measure to reset the upload form
	 * 
	 * @param currentBytesRead
	 * @return true if the file is still uploading, or false if it has failed
	 */
	public boolean isStillProcessing() {
		if (logger.isDebugEnabled())
			logger.debug("BytesnotReadChangedCount is: "
					+ bytesReadNotChangedCount);
		if (bytesReadNotChangedCount > 3) {
			// Abort processing
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This returns the percentage complete
	 */
	public String percentComplete() {
		double percent = ((double) bytesRead / (double) bytesLength);
		percent *= 100;
		return fmt.format(percent);
	}

	public long getBytesRead() {
		if (previousBytesRead == bytesRead) {
			bytesReadNotChangedCount++;
		} else {
			bytesReadNotChangedCount = 0;
			previousBytesRead = bytesRead;
		}
		return bytesRead;
	}

	public long getBytesLength() {
		return bytesLength;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void abort() {
		this.aborted = true;
	}

	public boolean isAborted() {
		return this.aborted;
	}

	public void setPreviousBytesRead(long previousBytesRead) {
		this.previousBytesRead = previousBytesRead;
	}

}
