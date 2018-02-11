package br.com.brunogiannella.icase.itaucasetwitter.transform;

import java.util.List;

import br.com.brunogiannella.icase.itaucasetwitter.dto.SaidaIndicadoresTweets;
import br.com.brunogiannella.icase.itaucasetwitter.model.TopUsers;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHashTag;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHorasDia;

public class TransformacaoIndicadores {

	public static SaidaIndicadoresTweets transformar(List<TopUsers> topUsers, List<TweetsHashTag> tweetsHashTag, List<TweetsHorasDia> tweetsHorasDia) {
		SaidaIndicadoresTweets saida = new SaidaIndicadoresTweets();
		return saida;
	}
	
}
