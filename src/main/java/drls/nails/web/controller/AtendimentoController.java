package drls.nails.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import drls.nails.domain.Atendimento;
import drls.nails.domain.Cliente;
import drls.nails.domain.Prestacao;
import drls.nails.service.AtendimentoService;
import drls.nails.service.ClienteService;

@Controller
@RequestMapping("/atendimentos")
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService atendimentoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("atendimentos", atendimentoService.buscarTodos());
		return "atendimento/lista";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Atendimento atendimento) {
		return "atendimento/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Atendimento atendimento, BindingResult result, RedirectAttributes attrs) {
		
		if(result.hasErrors()) {
			return "atendimento/cadastro";
		}
		
		atendimentoService.salvar(atendimento);
		attrs.addFlashAttribute("success", "Atendimento salvo com sucesso.");
		return "redirect:/atendimentos/cadastrar";
	}
	
	@ModelAttribute("prestacoes")
	public Prestacao[] getPrestacoes() {
		return Prestacao.values();
	}
	
	@ModelAttribute("clientes")
	public List<Cliente> listaDeClientes() {
		return clienteService.buscarTodos();
	}
	
}
