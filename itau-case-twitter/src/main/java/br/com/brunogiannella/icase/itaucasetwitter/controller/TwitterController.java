package br.com.brunogiannella.icase.itaucasetwitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunogiannella.icase.itaucasetwitter.repository.TweetRepository;

@RestController
@RequestMapping(TwitterController.URI_BASE)
public class TwitterController {

	public final static String URI_BASE = "api/v1";
	
	@Autowired
	private Twitter twitter;
	
	@Autowired
	private TweetRepository repository;
	
	@RequestMapping(value = "tweets/{hashtag}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void processTweets(@PathVariable final String hashtag) {
		List<Tweet> tweets = this.twitter.searchOperations().search("openbanking", 20).getTweets();
		
		if(tweets != null) {
			repository.deleteAll();
			
			for(Tweet t : tweets) {
				repository.save(new br.com.brunogiannella.icase.itaucasetwitter.model.Tweet(t.getIdStr(), t.getText(), t.getUser().getName(), t.getFromUser(), String.valueOf(t.getUser().getFollowersCount()), t.getUser().getLocation(), t.getLanguageCode(), "openbaking"));
			}
		}
		
	}
	
}
