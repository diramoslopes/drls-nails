package drls.nails.web.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import drls.nails.domain.Cliente;
import drls.nails.service.ClienteService;
import drls.nails.util.PaginacaoUtil;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(ModelMap model, @RequestParam("page") Optional<Integer> page) {
		
		int paginaAtual = page.orElse(1);
		
		PaginacaoUtil<Cliente> pageCliente = clienteService.buscaPorPagina(paginaAtual);
		
		model.addAttribute("pageCliente", pageCliente);
		return "cliente/lista";
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "cliente/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attrs) {
		
		if(result.hasErrors()) {
			return "cliente/cadastro";
		}
		
		clienteService.salvar(cliente);
		attrs.addFlashAttribute("success", "Cliente inserido com sucesso");
		return "redirect:/clientes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", clienteService.buscarPorId(id));
		return "cliente/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attrs) {
		
		if(result.hasErrors()) {
			return "cliente/cadastro";
		}
		
		clienteService.editar(cliente);
		attrs.addFlashAttribute("success", "Cliente editado com sucesso");
		return "redirect:/clientes/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attrs) {
		
		if(clienteService.clienteTemAtendimento(id)) {
			attrs.addFlashAttribute("fail", "Cliente não removido. Possui atendimento(s) vinculado(s).");
		} else {
			clienteService.excluir(id);
			attrs.addFlashAttribute("success", "Cliente removido com sucesso!");
		}
		
		return "redirect:/clientes/listar";
	}

	@GetMapping("/buscar/nome")
	public String buscarPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("clientes", clienteService.buscarPorNome(nome));
		return "/cliente/lista";
	}
}