package com.twitpic.domain;
/**
 * <code>PictureInfoList.java</code>
 * @version 1.0, 2009-8-12
 */
public class PictureInfoList {
	
	private java.util.List<PictureInfo> pis;
	
	private int size;
	
	private long maxId;
	
	private long minId;

	/**
	 * @return the pis
	 */
	public java.util.List<PictureInfo> getPis() {
		return pis;
	}

	/**
	 * @param pis the pis to set
	 */
	public void setPis(java.util.List<PictureInfo> pis) {
		this.pis = pis;
		if(pis!=null){
			this.size = pis.size();
			this.maxId = this.minId = pis.get(0).getPictures().getId();
			long tmpId;
			for(PictureInfo pi:pis){
				tmpId = pi.getPictures().getId();
				if(tmpId>this.maxId){
					this.maxId = tmpId;
				}
				if(tmpId<this.minId){
					this.minId = tmpId;
				}
			}
		}
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the maxId
	 */
	public long getMaxId() {
		return maxId;
	}

	/**
	 * @param maxId the maxId to set
	 */
	public void setMaxId(long maxId) {
		this.maxId = maxId;
	}

	/**
	 * @return the minId
	 */
	public long getMinId() {
		return minId;
	}

	/**
	 * @param minId the minId to set
	 */
	public void setMinId(long minId) {
		this.minId = minId;
	}
	
	
}
