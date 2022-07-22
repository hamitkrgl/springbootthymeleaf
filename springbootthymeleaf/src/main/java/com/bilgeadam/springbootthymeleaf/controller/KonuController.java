package com.bilgeadam.springbootthymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootthymeleaf.model.Konu;
import com.bilgeadam.springbootthymeleaf.service.KonuService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(path = "konu")
public class KonuController {

	private KonuService konuService;

	@GetMapping(path = "")
	public ModelAndView konu() {
		ModelAndView konuView = new ModelAndView("konu/konu");
		List<Konu> liste = konuService.getAll();
		konuView.addObject("konu_list", liste);
		return konuView;
	}

	@GetMapping(path = "detay")
	public ModelAndView detay(@RequestParam(name = "id") Long id) {
		ModelAndView konuView = new ModelAndView("konu/konu_detay");
		Konu konu = konuService.getById(id);
		konuView.addObject("konu", konu);
		return konuView;
	}

	@GetMapping(path = "guncelle")
	public ModelAndView guncelle(@RequestParam(name = "id") Long id) {
		ModelAndView konuView = new ModelAndView("konu/konu_guncelle");
		Konu konu = konuService.getById(id);
		konuView.addObject("konu", konu);
		return konuView;
	}

	@PostMapping(path = "guncelle")
	public ModelAndView guncellePost(@ModelAttribute(value = "konu") Konu konu) {
		konuService.save(konu);
		return new ModelAndView("redirect:/konu");
	}

	@GetMapping(path = "ekle")
	public ModelAndView ekle() {
		ModelAndView konuView = new ModelAndView("konu/konu_ekle");
		Konu konu = new Konu();
		konuView.addObject("konu", konu);
		return konuView;
	}

	@PostMapping(path = "ekle")
	public ModelAndView eklePost(@ModelAttribute(name = "konu") Konu konu) {
		konuService.save(konu);
		return new ModelAndView("redirect:/konu");
	}

	@PostMapping(path = "sil")
	public ModelAndView sil(@ModelAttribute(name = "KONU_ID") Long id) {
		konuService.delete(id);
		return new ModelAndView("redirect:/konu");

	}

}
