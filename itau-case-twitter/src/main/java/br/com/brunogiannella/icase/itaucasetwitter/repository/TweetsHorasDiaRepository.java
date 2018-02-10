package br.com.brunogiannella.icase.itaucasetwitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHorasDia;

public interface TweetsHorasDiaRepository extends MongoRepository<TweetsHorasDia, String> {
}
