package drls.nails.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		if(atendimento.getId() == null) {
			atendimentoService.salvar(atendimento);
		} else {
			atendimentoService.editar(atendimento);
		}
		
		attrs.addFlashAttribute("success", "Atendimento salvo com sucesso.");
		return "redirect:/atendimentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("atendimento", atendimentoService.buscarPorId(id));
		
		return "atendimento/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attrs) {
		
		atendimentoService.excluir(id);
		attrs.addFlashAttribute("success", "Atendimento excluido com sucesso!");
		
		return "redirect:/atendimentos/listar";
	}
	
	@GetMapping("/buscar/cliente")
	public String getPorCliente(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("atendimentos", atendimentoService.buscarPorCliente(id));
		return "atendimento/lista";
	}
	
	@GetMapping("/buscar/data")
	public String getPorData(@RequestParam("data") @DateTimeFormat(iso = ISO.DATE) LocalDate data, ModelMap model) {
		
		model.addAttribute("atendimentos", atendimentoService.buscarPorData(data));
		
		return "atendimento/lista";
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