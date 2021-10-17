package com.stu.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stu.loja.model.CarrinhoCompras;
import com.stu.loja.model.DadosPagamento;

@Controller
@RequestMapping("/pagamento")

public class PagamentoController {

	@Autowired
	private CarrinhoCompras carrinho;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/finalizar", method = RequestMethod.POST)
	public Callable<ModelAndView> finalizar(RedirectAttributes model) {
		return () -> {
			try {
				System.out.println("Finalizar");
				String response = restTemplate.postForObject("http://book-payment.herokuapp.com/payment", new DadosPagamento(carrinho.getTotal()), String.class);

				System.out.println(response);

				model.addFlashAttribute("sucesso", response);
				return new ModelAndView("redirect:/produtos");

			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				model.addFlashAttribute("sucesso", "Valor maior que o permitido.");
				return new ModelAndView("redirect:/produtos");
			}
		};
	}

}
