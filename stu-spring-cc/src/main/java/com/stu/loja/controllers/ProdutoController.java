package com.stu.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stu.loja.dao.ProdutoDao;
import com.stu.loja.infra.FileSaver;
import com.stu.loja.model.Produto;
import com.stu.loja.model.TipoPreco;
import com.stu.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	ProdutoDao produtoDao;
	@Autowired
	FileSaver fileSaver;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.addValidators(new ProdutoValidation());

	}

	@RequestMapping("form")
	public ModelAndView form(Produto produto) {
		ModelAndView mv = new ModelAndView("/produtos/form");

		mv.addObject("tipos", TipoPreco.values());

		return mv;
	}

	@RequestMapping("form2")
	public ModelAndView form2() {
		ModelAndView mv = new ModelAndView("/produtos/form2");

		mv.addObject("tipos", TipoPreco.values());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	@CacheEvict(value = "produtosHome", allEntries = true)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		String sumarioPath = fileSaver.write("arquivos-sumarios2", sumario);

		produto.setSumarioPath(sumarioPath);
		System.out.println(sumario.getOriginalFilename());
		if (result.hasErrors()) {
			System.out.println("erro no formulario");
			return form(produto);
		}

		produtoDao.gravar(produto);

		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso.");

		return new ModelAndView("redirect:/produtos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/produtos/lista");

		List<Produto> produtos = produtoDao.listar();

		mv.addObject("produtos", produtos);

		return mv;
	}

	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDao.find(id);
		mv.addObject("produto", produto);
		return mv;
	}
}