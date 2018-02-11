package br.com.brunogiannella.icase.itaucasetwitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.brunogiannella.icase.itaucasetwitter.model.TopUsers;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHashTag;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHorasDia;
import br.com.brunogiannella.icase.itaucasetwitter.repository.TopUsersRepository;
import br.com.brunogiannella.icase.itaucasetwitter.repository.TweetsHashTagRepository;
import br.com.brunogiannella.icase.itaucasetwitter.repository.TweetsHorasDiaRepository;

@Service
public class IndicadoresService {

	@Autowired
	private TopUsersRepository topUsersRepository;

	@Autowired
	private TweetsHashTagRepository tweetsHashTagRepository;

	@Autowired
	private TweetsHorasDiaRepository tweetsHorasDiaRepository;

	public List<TopUsers> consultarTopUsers() {
		return topUsersRepository.findAll(new Sort(Sort.Direction.DESC, "quantidadeSeguidores")).subList(0, 5);
	}

	public List<TweetsHashTag> consultarTweetsHashTag() {
		return tweetsHashTagRepository.findAll(new Sort(Sort.Direction.DESC, "total"));
	}

	public List<TweetsHorasDia> consultarTweetsHorasDia() {
		return tweetsHorasDiaRepository.findAll();
	}

}
