package br.com.brunogiannella.icase.itaucasetwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunogiannella.icase.itaucasetwitter.dto.EntradaProcessarTwitter;
import br.com.brunogiannella.icase.itaucasetwitter.service.TwitterService;

@RestController
@RequestMapping(TwitterController.URI_BASE)
public class TwitterController {

	public final static String URI_BASE = "api/v1";
	
	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping(value = "tweets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.POST)
	public void processTweets(@RequestBody EntradaProcessarTwitter request) {
		twitterService.processarTweets(request.getHashtags());
	}
	
}
