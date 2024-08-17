package javaBeans;

import java.io.Serializable;

public class Publisher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int publisherId;
	private String publisherName;
	public Publisher() {
		super();
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
}
