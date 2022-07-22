package com.bilgeadam.springbootthymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootthymeleaf.model.Ders;
import com.bilgeadam.springbootthymeleaf.model.Konu;
import com.bilgeadam.springbootthymeleaf.model.Ogretmen;
import com.bilgeadam.springbootthymeleaf.service.DersService;
import com.bilgeadam.springbootthymeleaf.service.KonuService;
import com.bilgeadam.springbootthymeleaf.service.OgretmenService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(path = "ders")
public class DersController {

	private DersService dersService;

	private OgretmenService ogretmenService;

	private KonuService konuService;

	@GetMapping(path = "")
	public ModelAndView ders() {
		ModelAndView dersView = new ModelAndView("ders/ders");
		List<Ders> liste = dersService.getAll();
		dersView.addObject("ders_list", liste);
		return dersView;
	}

	@GetMapping(path = "detay")
	public ModelAndView detay(@RequestParam(name = "id") Long id) {
		ModelAndView dersView = new ModelAndView("ders/ders_detay");
		Ders ders = dersService.getById(id);
		dersView.addObject("ders", ders);
		return dersView;
	}

	@GetMapping(path = "guncelle")
	public ModelAndView guncelle(@RequestParam(name = "id") Long id) {
		ModelAndView dersView = new ModelAndView("ders/ders_guncelle");
		Ders ders = dersService.getById(id);
		dersView.addObject("ders", ders);
		return dersView;
	}

	@PostMapping(path = "guncelle")
	public ModelAndView guncellePost(@ModelAttribute(value = "ders") Ders ders) {
		dersService.save(ders);
		return new ModelAndView("redirect:/ders");
	}

	@GetMapping(path = "ekle")
	public ModelAndView ekle() {
		ModelAndView dersView = new ModelAndView("ders/ders_ekle");
		Ders ders = new Ders();
		dersView.addObject("ders", ders);
		List<Ogretmen> ogretmen_list = ogretmenService.getAll();
		dersView.addObject("ogretmen_list", ogretmen_list);

		List<Konu> konu_list = konuService.getAll();
		dersView.addObject("konu_list", konu_list);

		return dersView;
	}

	@PostMapping(path = "ekle")
	public ModelAndView eklePost(@ModelAttribute(name = "ders") Ders ders) {
		dersService.save(ders);
		return new ModelAndView("redirect:/ders");
	}

	@PostMapping(path = "sil")
	public ModelAndView sil(@ModelAttribute(name = "DERS_ID") Long id) {
		dersService.delete(id);
		return new ModelAndView("redirect:/ders");

	}

}
