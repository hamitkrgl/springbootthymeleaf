package com.bilgeadam.springbootthymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootthymeleaf.model.Ogretmen;
import com.bilgeadam.springbootthymeleaf.service.OgretmenService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(path = "ogretmen")
public class OgretmenController {

	private OgretmenService ogretmenService;

	@GetMapping(path = "")
	public ModelAndView ogretmen() {
		ModelAndView ogretmenView = new ModelAndView("ogretmen/ogretmen");
		List<Ogretmen> liste = ogretmenService.getAll();
		ogretmenView.addObject("ogretmen_list", liste);
		return ogretmenView;
	}

	@GetMapping(path = "detay")
	public ModelAndView detay(@RequestParam(name = "id") Long id) {
		ModelAndView ogretmenView = new ModelAndView("ogretmen/ogretmen_detay");
		Ogretmen ogretmen = ogretmenService.getById(id);
		ogretmenView.addObject("ogretmen", ogretmen);
		return ogretmenView;
	}

	@GetMapping(path = "guncelle")
	public ModelAndView guncelle(@RequestParam(name = "id") Long id) {
		ModelAndView ogretmenView = new ModelAndView("ogretmen/ogretmen_guncelle");
		Ogretmen ogretmen = ogretmenService.getById(id);
		ogretmenView.addObject("ogretmen", ogretmen);
		return ogretmenView;
	}

	@PostMapping(path = "guncelle")
	public ModelAndView guncellePost(@ModelAttribute(value = "ogretmen") Ogretmen ogretmen) {
		ogretmenService.save(ogretmen);
		return new ModelAndView("redirect:/ogretmen");
	}

	@GetMapping(path = "ekle")
	public ModelAndView ekle() {
		ModelAndView ogretmenView = new ModelAndView("ogretmen/ogretmen_ekle");
		Ogretmen ogretmen = new Ogretmen();
		ogretmenView.addObject("ogretmen", ogretmen);
		return ogretmenView;
	}

	@PostMapping(path = "ekle")
	public ModelAndView eklePost(@ModelAttribute(name = "ogretmen") Ogretmen ogretmen) {
		ogretmenService.save(ogretmen);
		return new ModelAndView("redirect:/ogretmen");
	}

	@PostMapping(path = "sil")
	public ModelAndView sil(@ModelAttribute(name = "OGR_ID") Long id) {
		ogretmenService.delete(id);
		return new ModelAndView("redirect:/ogretmen");

	}
}
