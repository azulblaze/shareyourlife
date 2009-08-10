package com.twitpic.domain;

import java.io.File;
import java.util.Iterator;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * <code>JPEGExitInfo.java</code>
 * 
 * @version 1.0, 2009-8-10
 */
public class JPEGExitInfo {

	public void read(String file) throws Exception {
		File jpegFile = new File(file);
		Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
		Iterator directories = metadata.getDirectoryIterator();
		while (directories.hasNext()) {
			Directory directory = (Directory) directories.next(); 
			Iterator tags = directory.getTagIterator();
			while (tags.hasNext()) {
				Tag tag = (Tag) tags.next(); // use Tag.toString()
				if(!tag.getTagName().startsWith("Unknown")){
					System.out.println("-------------");
					System.out.println("Description:"+tag.getDescription());
					System.out.println("DirectoryName:"+tag.getDirectoryName());
					System.out.println("TagName:"+tag.getTagName());
					System.out.println("TagType:"+tag.getTagType());
				}
			}
		}
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JPEGExitInfo je = new JPEGExitInfo();
		//je.read("D:/My Documents/My Pictures/lijiang/http_imgload1.jpg");
		//je.read("D:/My Documents/My Pictures/pic/P1100300.JPG");
		//je.read("D:/My Documents/My Pictures/jason.jpg");
		//je.read("Z:/CD003/Sol/Photograph/2009-06-26(hailuogou)/DSC_3438.JPG");
		je.read("D:/Program Files/Google/Picasa3/photo/DSC_3438.JPG");
	}

}
