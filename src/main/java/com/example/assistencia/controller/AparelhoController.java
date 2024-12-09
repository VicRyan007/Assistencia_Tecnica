package com.example.assistencia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.assistencia.model.Aparelho;
import com.example.assistencia.service.AparelhoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/aparelhos")
public class AparelhoController {

    private final AparelhoService service;

    public AparelhoController(AparelhoService service) {
        this.service = service;
    }

    // Listar todos os aparelhos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("aparelhos", service.listarTodos());
        return "aparelhos/lista";
    }

    // Formulário para criar um novo aparelho
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("aparelho", new Aparelho());
        return "aparelhos/formulario";
    }

    // Formulário para editar um aparelho existente
    @GetMapping("/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Aparelho aparelho = service.buscarPorId(id);
        if (aparelho == null) {
            throw new IllegalArgumentException("Aparelho não encontrado!");
        }
        model.addAttribute("aparelho", aparelho);
        return "aparelhos/formulario";
    }

    // Salvar ou atualizar aparelho
    @PostMapping
    public String salvar(@Valid @ModelAttribute Aparelho aparelho, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("aparelho", aparelho);
            return "aparelhos/formulario";
        }

        service.salvar(aparelho); // Se ID existir, ele será atualizado. Caso contrário, será criado.
        return "redirect:/aparelhos";
    }

    // Excluir aparelho
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/aparelhos";
    }
}
