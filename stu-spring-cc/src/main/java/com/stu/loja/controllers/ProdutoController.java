package com.stu.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stu.loja.dao.ProdutoDao;
import com.stu.loja.model.Produto;
import com.stu.loja.model.TipoPreco;

@Controller
@RequestMapping("produtos")
public class ProdutoController {
	@Autowired
	ProdutoDao produtoDao;

	@RequestMapping("form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("/produtos/form");

		mv.addObject("tipos", TipoPreco.values());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView grava(Produto produto, RedirectAttributes redirectAttributes) {

		produtoDao.gravar(produto);

		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso.");

		return new ModelAndView("redirect:produtos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/produtos/lista");

		List<Produto> produtos = produtoDao.listar();

		mv.addObject("produtos", produtos);

		return mv;
	}
}