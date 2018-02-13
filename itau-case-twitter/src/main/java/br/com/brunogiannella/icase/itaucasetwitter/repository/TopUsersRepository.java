package br.com.brunogiannella.icase.itaucasetwitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.brunogiannella.icase.itaucasetwitter.model.TopUsers;

/**
 * 
 * @author Bruno Giannella de Melo
 * 
 * Classe responsável pelo mapeamento e operações com a base de dados
 * para a entidade TopUsers.
 */
public interface TopUsersRepository extends MongoRepository<TopUsers, String> {
}
