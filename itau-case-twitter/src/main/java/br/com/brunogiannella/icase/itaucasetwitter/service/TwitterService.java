package br.com.brunogiannella.icase.itaucasetwitter.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import br.com.brunogiannella.icase.itaucasetwitter.model.TopUsers;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHashTag;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHorasDia;
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
		tweetRepository.deleteAll();
		
		for (String hashtag : hashtags) {
			List<Tweet> tweets = this.twitter.searchOperations().search(hashtag, 20).getTweets();

			if (tweets != null) {
				for (Tweet t : tweets) {
					tweetRepository.save(new br.com.brunogiannella.icase.itaucasetwitter.model.Tweet(t.getIdStr(), t.getText(),
							t.getUser().getName(), t.getFromUser(), String.valueOf(t.getUser().getFollowersCount()),
							t.getUser().getLocation(), t.getLanguageCode(), t.getCreatedAt(), hashtag));
				}
			}
		}

		processarTopUsers();
		processaHashTags();
		processaHorasDia();
	}

	private void processarTopUsers() {
		topUsersRepository.deleteAll();
		
		List<br.com.brunogiannella.icase.itaucasetwitter.model.Tweet> tweets = tweetRepository.findAll();
		Map<String, Long> usersTweets = new HashMap<String, Long>();
		
		for(br.com.brunogiannella.icase.itaucasetwitter.model.Tweet t : tweets) {
			if(!usersTweets.containsKey(t.getIdUsuario())) {
				usersTweets.put(t.getIdUsuario(), Long.valueOf(t.getQuantidadeSeguidores()));
			}
		}
		
		for(String chave : usersTweets.keySet()) {
			TopUsers topUser = new TopUsers();
			topUser.setApelido(chave);
			topUser.setQuantidadeSeguidores(usersTweets.get(chave));
			
			topUsersRepository.save(topUser);
		}
	}

	private void processaHashTags() {
		tweetsHashTagRepository.deleteAll();
		
		List<br.com.brunogiannella.icase.itaucasetwitter.model.Tweet> tweets = tweetRepository.findAll();
		Map<String, Long> hashTagPaises = new HashMap<String, Long>();
		
		for(br.com.brunogiannella.icase.itaucasetwitter.model.Tweet t : tweets) {
			if(hashTagPaises.containsKey(t.getHashtag().concat("_").concat(t.getIdioma()))) {
				hashTagPaises.put(t.getHashtag().concat("_").concat(t.getIdioma()), hashTagPaises.get(t.getHashtag().concat("_").concat(t.getIdioma())) + 1L);
			} else {
				hashTagPaises.put(t.getHashtag().concat("_").concat(t.getIdioma()), 1L);
			}
		}
		
		for(String chave : hashTagPaises.keySet()) {
			String hashtag = "";
			String pais = "Outros";
			
			try {
				hashtag = chave.split("_")[0];
			} catch(Exception e) {
				
			}
			
			try {
				pais = chave.split("_")[1];
			} catch(Exception e) {
				
			}
			
			TweetsHashTag tweetHashTah = new TweetsHashTag();
			tweetHashTah.setHashTag(hashtag);
			tweetHashTah.setPais(pais);
			tweetHashTah.setTotal(hashTagPaises.get(chave));
			
			tweetsHashTagRepository.save(tweetHashTah);
		}
	}

	private void processaHorasDia() {
		tweetsHorasDiaRepository.deleteAll();
		
		List<br.com.brunogiannella.icase.itaucasetwitter.model.Tweet> tweets = tweetRepository.findAll();
		Map<Integer, Long> tweetsHorasDia = new HashMap<Integer, Long>();
		
		for(br.com.brunogiannella.icase.itaucasetwitter.model.Tweet t : tweets) {
			Calendar postDate = Calendar.getInstance();
			postDate.setTime(t.getData());
			int horaDoDia = postDate.get(Calendar.HOUR_OF_DAY);
			
			if(tweetsHorasDia.containsKey(horaDoDia)) {
				tweetsHorasDia.put(horaDoDia, tweetsHorasDia.get(horaDoDia) + 1);
			} else {
				tweetsHorasDia.put(horaDoDia, 1L);
			}
		}
		
		for(Integer chave : tweetsHorasDia.keySet()) {
			TweetsHorasDia tweetsHoraDiaResumo = new TweetsHorasDia();
			tweetsHoraDiaResumo.setHora(chave);
			tweetsHoraDiaResumo.setTotal(tweetsHorasDia.get(chave));
			
			tweetsHorasDiaRepository.save(tweetsHoraDiaResumo);
		}
	}

}
