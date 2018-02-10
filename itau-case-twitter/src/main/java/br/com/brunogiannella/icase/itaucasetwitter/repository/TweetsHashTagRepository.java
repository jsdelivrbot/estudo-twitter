package br.com.brunogiannella.icase.itaucasetwitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHashTag;

public interface TweetsHashTagRepository extends MongoRepository<TweetsHashTag, String> {
}
