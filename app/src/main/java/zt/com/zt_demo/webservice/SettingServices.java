package zt.com.zt_demo.webservice;

import org.androidannotations.rest.spring.annotations.Accept;
import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.MediaType;
import org.androidannotations.rest.spring.api.RestClientErrorHandling;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import zt.com.zt_demo.config.WebServicesConfig;
@Rest(rootUrl = WebServicesConfig.REST_SERVICE_PATH, converters = {GsonHttpMessageConverter.class})
public interface SettingServices extends RestClientErrorHandling {
	@Get("sys/GetSysInfo")
	@Accept(MediaType.APPLICATION_JSON)
	ResponseEntity<String> getVersion();
	
	@Post("sys/SubmitFeedback")
	@Accept(MediaType.APPLICATION_JSON)
	ResponseEntity<String> submitFeedback(@Body String jsonString);
}
