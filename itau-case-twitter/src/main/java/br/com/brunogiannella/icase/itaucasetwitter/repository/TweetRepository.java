package br.com.brunogiannella.icase.itaucasetwitter.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.brunogiannella.icase.itaucasetwitter.model.Tweet;

public interface TweetRepository extends MongoRepository<Tweet, String> {
    public List<Tweet> findByHashtag(String hashtag);
}
