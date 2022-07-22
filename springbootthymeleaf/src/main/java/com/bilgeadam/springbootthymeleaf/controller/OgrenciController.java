package com.bilgeadam.springbootthymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootthymeleaf.model.Ogrenci;
import com.bilgeadam.springbootthymeleaf.service.KonuService;
import com.bilgeadam.springbootthymeleaf.service.OgrenciService;
import com.bilgeadam.springbootthymeleaf.service.OgretmenService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(path = "ogrenci")
public class OgrenciController {
	private OgrenciService ogrenciService;

	private OgretmenService ogretmenService;

	private KonuService konuService;

	@GetMapping(path = "")
	public ModelAndView ogrenci() {
		ModelAndView ogrenciView = new ModelAndView("ogrenci/ogrenci");
		List<Ogrenci> liste = ogrenciService.getAll();
		ogrenciView.addObject("ogrenci_list", liste);
		return ogrenciView;
	}

	@GetMapping(path = "detay")
	public ModelAndView detay(@RequestParam(name = "id") Long id) {
		ModelAndView ogrenciView = new ModelAndView("ogrenci/ogrenci_detay");
		Ogrenci ogrenci = ogrenciService.getById(id);
		ogrenciView.addObject("ogrenci", ogrenci);
		return ogrenciView;
	}

	@GetMapping(path = "guncelle")
	public ModelAndView guncelle(@RequestParam(name = "id") Long id) {
		ModelAndView ogrenciView = new ModelAndView("ogrenci/ogrenci_guncelle");
		Ogrenci ogrenci = ogrenciService.getById(id);
		ogrenciView.addObject("ogrenci", ogrenci);
		return ogrenciView;
	}

	@PostMapping(path = "guncelle")
	public ModelAndView guncellePost(@ModelAttribute(value = "ogrenci") Ogrenci ogrenci) {
		ogrenciService.save(ogrenci);
		return new ModelAndView("redirect:/ogrenci");
	}

	@GetMapping(path = "ekle")
	public ModelAndView ekle() {
		ModelAndView ogrenciView = new ModelAndView("ogrenci/ogrenci_ekle");
		Ogrenci ogrenci = new Ogrenci();
		ogrenciView.addObject("ogrenci", ogrenci);
//		List<Ogretmen> ogretmen_list = ogretmenService.getAll();
//		ogrenciView.addObject("ogretmen_list", ogretmen_list);
//
//		List<Konu> konu_list = konuService.getAll();
//		ogrenciView.addObject("konu_list", konu_list);

		return ogrenciView;
	}

	@PostMapping(path = "ekle")
	public ModelAndView eklePost(@ModelAttribute(name = "ogrenci") Ogrenci ogrenci) {
		ogrenciService.save(ogrenci);
		return new ModelAndView("redirect:/ogrenci");
	}

	@PostMapping(path = "sil")
	public ModelAndView sil(@ModelAttribute(name = "OGR_ID") Long id) {
		ogrenciService.delete(id);
		return new ModelAndView("redirect:/ogrenci");

	}
}
