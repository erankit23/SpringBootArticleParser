package com.sample;

import java.util.List;
import java.util.Map;

public class ArticleDTO {

		private String newsTitle;
		private String newsSummary;
		private String newsFullStory;
		private List<String> listImages;
		private String author;
		private List<Map<String,String>> metaData;
		
		public List<Map<String, String>> getMetaData() {
			return metaData;
		}
		public void setMetaData(List<Map<String, String>> metaData) {
			this.metaData = metaData;
		}
		public void setListImages(List<String> listImages) {
			this.listImages = listImages;
		}
		private String publishDate;
		
		public String getNewsTitle() {
			return newsTitle;
		}
		public void setNewsTitle(String newsTitle) {
			this.newsTitle = newsTitle;
		}
		public String getNewsSummary() {
			return newsSummary;
		}
		public void setNewsSummary(String newsSummary) {
			this.newsSummary = newsSummary;
		}
		public String getNewsFullStory() {
			return newsFullStory;
		}
		public void setNewsFullStory(String newsFullStory) {
			this.newsFullStory = newsFullStory;
		}
		public List getListImages() {
			return listImages;
		}
		
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public String getPublishDate() {
			return publishDate;
		}
		public void setPublishDate(String publishDate) {
			this.publishDate = publishDate;
		}
		
}
