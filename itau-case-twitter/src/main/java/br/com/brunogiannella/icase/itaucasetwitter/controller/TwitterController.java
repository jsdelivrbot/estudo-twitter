package br.com.brunogiannella.icase.itaucasetwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunogiannella.icase.itaucasetwitter.dto.EntradaProcessarTwitter;
import br.com.brunogiannella.icase.itaucasetwitter.dto.RetornoConsulta;
import br.com.brunogiannella.icase.itaucasetwitter.service.IndicadoresService;
import br.com.brunogiannella.icase.itaucasetwitter.service.TwitterService;
import br.com.brunogiannella.icase.itaucasetwitter.transform.TransformacaoIndicadores;

@RestController
@RequestMapping(TwitterController.URI_BASE)
public class TwitterController {

	public final static String URI_BASE = "api/tweets/v1";
	public final static String ERROR_404_PARAMETRO_VIEW = "O parâmetro view é obrigatório.";

	@Autowired
	private TwitterService twitterService;

	@Autowired
	private IndicadoresService indicadoresService;

	@RequestMapping(value = "tweets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> processTweets(@RequestBody EntradaProcessarTwitter request) {
		twitterService.processarTweets(request.getHashtags());
		return new ResponseEntity<>(request, HttpStatus.OK);
	}

	@RequestMapping(value = "tweets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> consultarIndicadores(@RequestParam final String view) {
		if ("indicadores".equals(view)) {
			RetornoConsulta retorno = new RetornoConsulta(
					TransformacaoIndicadores.transformar(indicadoresService.consultarTopUsers(),
							indicadoresService.consultarTweetsHashTag(), indicadoresService.consultarTweetsHorasDia()));
			return new ResponseEntity<>(retorno, HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(TwitterController.ERROR_404_PARAMETRO_VIEW);
		}
	}

}
