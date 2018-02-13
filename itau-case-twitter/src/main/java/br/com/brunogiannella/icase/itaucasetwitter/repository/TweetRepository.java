package br.com.brunogiannella.icase.itaucasetwitter.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.brunogiannella.icase.itaucasetwitter.model.Tweet;

/**
 * 
 * @author Bruno Giannella de Melo
 * 
 * Classe responsável pelo mapeamento e operações com a base de dados
 * para a entidade Tweet.
 */
public interface TweetRepository extends MongoRepository<Tweet, String> {
    public List<Tweet> findByHashtag(String hashtag);
}
