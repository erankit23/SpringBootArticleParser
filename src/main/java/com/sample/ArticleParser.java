package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ArticleParser {
	private static Pattern pattern;
	private static Matcher matcher;
	
	
	public static ArticleDTO articleParser(String url)
	{
		pattern = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
		Document document =null;
		
		ArticleDTO articleDTO= new ArticleDTO();
		List<String> imageList=new ArrayList<String>();
		List<Map<String,String>> metaList=new ArrayList<Map<String,String>>();
		Map<String,String> metaMap=null;
		
	    try {
	    	document = Jsoup.connect(url).get();
	        Elements titles= document.getElementsByTag("title");
	        
	       articleDTO.setNewsTitle(titles.get(0).text());
	       Elements metaTags = document.getElementsByTag("meta");
	       for (Element metaTag : metaTags) {
	    	   
	    	   String name = metaTag.attr("name");
	    	   String content =metaTag.attr("content");
	    	   if(!name.equals(""))
	    	   {
	    	   metaMap=new HashMap<>();
	    	   metaMap.put(name, content);
	    	   metaList.add(metaMap);
	    	   }
	    	   if(name.equals("author"))
	    	   {
	    		   articleDTO.setAuthor(content);
	    	   }
	    		   
	    	   if(name.equals("description"))
	    	   {
	    		   articleDTO.setNewsSummary(content);
	    	   }
	    		   
	    	   if(name.equals("pubdate"))
	    	   {
	    		   articleDTO.setPublishDate(content.substring(0, content.indexOf("T")));
	    	   }
	    		   
	    	   
	       }
	       articleDTO.setMetaData(metaList);
	       Elements images = document.getElementsByTag("img");
	       for(Element image: images)
	       {
	    	   if(validate(image.attr("src")))
	    	   imageList.add(image.attr("src"));
	       }
	       articleDTO.setListImages(imageList);
	       articleDTO.setNewsFullStory(document.select("section div").text());
	   
	      }
	      
	      catch (Exception e) {
	    	  e.printStackTrace();
	    	  
	          System.err.println("Exception while parsing article");
	      }
	    return articleDTO;
	}
	
	public static boolean  validate(final String image){

		  matcher = pattern.matcher(image);
		  return matcher.matches();

	   }
}
