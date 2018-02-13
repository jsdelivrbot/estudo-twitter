package br.com.brunogiannella.icase.itaucasetwitter.transform;

import java.util.List;

import br.com.brunogiannella.icase.itaucasetwitter.dto.SaidaIndicadoresTweets;
import br.com.brunogiannella.icase.itaucasetwitter.model.TopUsers;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHashTag;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHorasDia;

/**
 * 
 * @author Bruno Giannella de Melo
 * Classe responsável pela saida dos indicadores.
 */
public class TransformacaoIndicadores {

	/**
	 * 
	 * @param topUsers List<TopUsers>
	 * @param tweetsHashTag List<TweetsHashTag>
	 * @param tweetsHorasDia List<TweetsHorasDia>
	 * @return SaidaIndicadoresTweets
	 * 
	 * Método responsável por transformar a saida dos indicadores
	 * 
	 */
	public static SaidaIndicadoresTweets transformar(List<TopUsers> topUsers, List<TweetsHashTag> tweetsHashTag, List<TweetsHorasDia> tweetsHorasDia) {
		SaidaIndicadoresTweets saida = new SaidaIndicadoresTweets();
		saida.setTopUsers(topUsers);
		saida.setHashTagsPorPais(tweetsHashTag);
		saida.setResumoTweetsPorHora(tweetsHorasDia);
		return saida;
	}
	
}
