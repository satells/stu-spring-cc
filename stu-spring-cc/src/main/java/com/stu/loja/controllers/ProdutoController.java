package com.stu.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stu.loja.dao.ProdutoDao;
import com.stu.loja.model.Produto;
import com.stu.loja.model.TipoPreco;
import com.stu.loja.validation.ProdutoValidation;

@Controller
//@RequestMapping("produtos")
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	ProdutoDao produtoDao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.addValidators(new ProdutoValidation());

	}

	@RequestMapping("form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("/produtos/form");

		mv.addObject("tipos", TipoPreco.values());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			System.out.println("erro no formulario");
			return form();
		}

		produtoDao.gravar(produto);

		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso.");

//		return new ModelAndView("redirect:produtos");
		return new ModelAndView("redirect:/produtos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/produtos/lista");

		List<Produto> produtos = produtoDao.listar();

		mv.addObject("produtos", produtos);

		return mv;
	}
}