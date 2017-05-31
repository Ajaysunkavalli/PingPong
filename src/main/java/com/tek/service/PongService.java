package com.tek.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PongService {

	@Autowired
	protected RestTemplate restTemplate;

	public int getPongServicesCount() {

		int count = 0;

		String[] services = new String[] { "Accounting", "Action", "AICampaign", 
				"AIConnection", "AIFilter","AIPixel", "Analysis", "Campaign", "Component", "DataSource",
				"Deployment","Environment","File", "FileWatcherConfiguration", "Firm", "GreenplumDataSource",
				"Layout", "License", "MongoDataSource", "Notification", "Page", "Preference", "PricingPlan",
				"Product", "Query", "Range", "Rule", "Runnable", "Script","ScriptEditor","Server","Service",
				"Session", "Spreadsheet", "SqlDataSource", "Trigger", "User", "UserComponent", "Vintage"};

		for (int i = 0; i < services.length; i++) {

			String url = "https://api.walletinsights.com/"+services[i]+"/ping";
			
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
			
			final HttpEntity<String> entity = new HttpEntity<String>(requestHeaders);
			
			try {
				ResponseEntity<String> responseEntity  = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			
				if (responseEntity.getStatusCode() == HttpStatus.OK) {
		       
		            String response = responseEntity.getBody();
		            if(response.contains("pong")) {
						count=count+1;
		            }

				}
			
				} catch (Exception exception) {
		    } 
		

	}
		return count;
}
		

}