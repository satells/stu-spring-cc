package com.stu.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stu.loja.dao.ProdutoDao;
import com.stu.loja.model.Produto;

@Controller
public class HomeController {

	@Autowired
	private ProdutoDao produtoDao;

	@RequestMapping("/")
	@Cacheable(value = "produtosHome")
	public ModelAndView index() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("produtos", produtos);

		return mv;
	}
}