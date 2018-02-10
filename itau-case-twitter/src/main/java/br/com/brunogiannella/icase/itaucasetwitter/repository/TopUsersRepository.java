package br.com.brunogiannella.icase.itaucasetwitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.brunogiannella.icase.itaucasetwitter.model.TopUsers;

public interface TopUsersRepository extends MongoRepository<TopUsers, String> {
}
