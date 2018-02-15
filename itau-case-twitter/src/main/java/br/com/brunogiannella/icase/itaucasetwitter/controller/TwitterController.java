package br.com.brunogiannella.icase.itaucasetwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunogiannella.icase.itaucasetwitter.dto.EntradaProcessarTwitter;
import br.com.brunogiannella.icase.itaucasetwitter.service.IndicadoresService;
import br.com.brunogiannella.icase.itaucasetwitter.service.TwitterService;
import br.com.brunogiannella.icase.itaucasetwitter.transform.TransformacaoIndicadores;

/**
 * 
 * @author Bruno Giannella de Melo
 * 
 * Classe responsável por receber as requisições, encaminhar ao service e retornar ao consumidor
 * Faz o papel do Controller no MVC
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(TwitterController.URI_BASE)
public class TwitterController {

	public final static String URI_BASE = "v1";
	public final static String ERROR_404_PARAMETRO_VIEW = "O parâmetro view é obrigatório.";

	@Autowired
	private TwitterService twitterService;

	@Autowired
	private IndicadoresService indicadoresService;

	/**
	 * 
	 * Método responsável por expor uma API POST para processar determinadas hashtags e gravar na base
	 * 
	 * @param request EntradaProcessarTwitter - recebe as hashtags a serem processadas e gravadas na base
	 * @return ResponseEntity - retorna a resposta e também o status code da API
	 */
	@RequestMapping(value = "tweets/processarTweets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> processTweets(@RequestBody EntradaProcessarTwitter request) {
		twitterService.processarTweets(request.getHashtags());
		return new ResponseEntity<>(request, HttpStatus.OK);
	}

	/**
	 * 
	 * Método responsável por expor uma API GET para consultar e retornar os indicadores dos tweets
	 * 
	 * @param view String - parâmetro view (neste caso aceita apenas "indicadores")
	 * @return ResponseEntity - retorna a resposta e também o status code da API
	 */
	@RequestMapping(value = "tweets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> consultarIndicadores(@RequestParam final String view) {
		if ("indicadores".equals(view)) {
			return new ResponseEntity<>(TransformacaoIndicadores.transformar(indicadoresService.consultarTopUsers(),
					indicadoresService.consultarTweetsHashTag(), indicadoresService.consultarTweetsHorasDia()), HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(TwitterController.ERROR_404_PARAMETRO_VIEW);
		}
	}

}
