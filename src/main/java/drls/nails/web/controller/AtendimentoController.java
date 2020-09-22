package drls.nails.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atendimentos")
public class AtendimentoController {
	
@GetMapping("/cadastrar")
public String cadastrar() {
	return "atendimento/cadastro";
}

@GetMapping("/listar")
public String listar() {
	return "atendimento/lista";
}
	
}
