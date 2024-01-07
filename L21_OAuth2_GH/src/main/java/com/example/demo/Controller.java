package com.example.demo;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String home() {
		return "Home Works!";
	}
	
	@GetMapping("/loginSuccess")
	public String profile() {
		return "Profile Works!";
	}
	
	@GetMapping("/profile")
	public String getLoginInfo(Model model) {
		
		String userDetails =" Test ";
	    Authentication authentication = SecurityContextHolder.getContext()
	            .getAuthentication();

	    //Add this:
	    Object principal = authentication.getPrincipal();
	    if(principal instanceof OAuth2AuthenticationToken){
	      OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken)principal;
	     //By default its DefaultOAuth2User.
	     OAuth2User oAuth2User = oAuth2AuthenticationToken.getPrincipal();
	     Map<String,Object> attributes =  oAuth2User.getAttributes();
	    
	     userDetails = attributes.toString();
	    }
	    
	    
	    
	    //now you can retrieve all attribute values you are interested from attributes map and store or return to view...


	   // your logic here



	    return userDetails;
	}
}
