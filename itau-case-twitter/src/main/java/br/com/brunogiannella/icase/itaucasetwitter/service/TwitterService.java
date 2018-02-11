package br.com.brunogiannella.icase.itaucasetwitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import br.com.brunogiannella.icase.itaucasetwitter.repository.TopUsersRepository;
import br.com.brunogiannella.icase.itaucasetwitter.repository.TweetRepository;
import br.com.brunogiannella.icase.itaucasetwitter.repository.TweetsHashTagRepository;
import br.com.brunogiannella.icase.itaucasetwitter.repository.TweetsHorasDiaRepository;

@Service
public class TwitterService {

	@Autowired
	private Twitter twitter;

	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private TopUsersRepository topUsersRepository;

	@Autowired
	private TweetsHashTagRepository tweetsHashTagRepository;

	@Autowired
	private TweetsHorasDiaRepository tweetsHorasDiaRepository;

	public void processarTweets(List<String> hashtags) {
		for (String hashtag : hashtags) {
			List<Tweet> tweets = this.twitter.searchOperations().search(hashtag, 20).getTweets();

			if (tweets != null) {
				tweetRepository.deleteAll();

				for (Tweet t : tweets) {
					tweetRepository.save(new br.com.brunogiannella.icase.itaucasetwitter.model.Tweet(t.getIdStr(), t.getText(),
							t.getUser().getName(), t.getFromUser(), String.valueOf(t.getUser().getFollowersCount()),
							t.getUser().getLocation(), t.getLanguageCode(), hashtag));
				}
			}
		}

		processarTopUsers();
		processaHashTags();
		processaHorasDia();
	}

	private void processarTopUsers() {
		topUsersRepository.deleteAll();
	}

	private void processaHashTags() {
		tweetsHashTagRepository.deleteAll();
	}

	private void processaHorasDia() {
		tweetsHorasDiaRepository.deleteAll();
	}

}
