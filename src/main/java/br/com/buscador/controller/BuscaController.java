package br.com.buscador.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.buscador.model.Produto;

@Controller
public class BuscaController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/resultado", method=RequestMethod.POST)
	public String realizaBusca(Produto produto){
		logger.info("Chegou na função de busca\n");
		Produto produto1 = new Produto();
		produto1.setNome(produto.getNome());
		System.out.println("Nome do produto buscado: "+produto1.getNome());
		return "resultado";
	}
}
