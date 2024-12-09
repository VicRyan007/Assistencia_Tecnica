package com.example.assistencia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.assistencia.model.OrdemDeServico;
import com.example.assistencia.model.Status;
import com.example.assistencia.model.TipoServico;
import com.example.assistencia.service.AparelhoService;
import com.example.assistencia.service.OrdemDeServicoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ordens")
public class OrdemDeServicoController {

    private final OrdemDeServicoService service;
    private final AparelhoService aparelhoService;

    public OrdemDeServicoController(OrdemDeServicoService service, AparelhoService aparelhoService) {
        this.service = service;
        this.aparelhoService = aparelhoService;
    }

    // Listar todas as ordens de serviço
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ordens", service.listarTodos());
        return "ordens/lista";
    }

    // Formulário para criar uma nova ordem de serviço
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("ordem", new OrdemDeServico());
        model.addAttribute("aparelhos", aparelhoService.listarTodos()); // Lista para o select de aparelhos
        model.addAttribute("tiposServico", TipoServico.values()); // Valores da enum TipoServico
        model.addAttribute("statusLista", Status.values()); // Valores da enum Status
        return "ordens/formulario";
    }


    // Formulário para editar uma ordem de serviço existente
    @GetMapping("/{id}")
    public String editar(@PathVariable Long id, Model model) {
        OrdemDeServico ordem = service.buscarPorId(id);
        if (ordem == null) {
            throw new IllegalArgumentException("Ordem de serviço não encontrada!");
        }
        model.addAttribute("ordem", ordem);
        model.addAttribute("aparelhos", aparelhoService.listarTodos());
        model.addAttribute("tiposServico", TipoServico.values());
        model.addAttribute("statusLista", Status.values());
        return "ordens/formulario";
    }


    // Salvar ou atualizar uma ordem de serviço
    @PostMapping
    public String salvar(@Valid @ModelAttribute OrdemDeServico ordem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ordem", ordem);
            model.addAttribute("aparelhos", aparelhoService.listarTodos());
            model.addAttribute("tiposServico", TipoServico.values());
            model.addAttribute("statusLista", Status.values());
            model.addAttribute("errors", result.getAllErrors());
            return "ordens/formulario"; // Retorna com os erros para exibição no frontend
        }
        service.salvar(ordem);
        return "redirect:/ordens";
    }


    // Excluir uma ordem de serviço
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/ordens";
    }
}
