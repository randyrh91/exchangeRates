package ru.alfabank.exchangeRates.giphy.model;

import lombok.Data;

@Data
public class GifModel {
	
	private String id;
	private String type;
	private String title;
	private String username;
	private String source;
	private String url;
	private ImageModel images;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ImageModel getImages() {
		return images;
	}
	public void setImages(ImageModel images) {
		this.images = images;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
