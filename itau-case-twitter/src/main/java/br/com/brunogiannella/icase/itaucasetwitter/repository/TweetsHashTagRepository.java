package br.com.brunogiannella.icase.itaucasetwitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHashTag;

/**
 * 
 * @author Bruno Giannella de Melo
 * 
 * Classe responsável pelo mapeamento e operações com a base de dados
 * para a entidade TweetsHashTag.
 */
public interface TweetsHashTagRepository extends MongoRepository<TweetsHashTag, String> {
}
