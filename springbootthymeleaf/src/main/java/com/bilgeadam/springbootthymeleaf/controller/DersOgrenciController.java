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
import com.bilgeadam.springbootthymeleaf.model.DersOgrenci;
import com.bilgeadam.springbootthymeleaf.model.Ogrenci;
import com.bilgeadam.springbootthymeleaf.service.DersOgrenciService;
import com.bilgeadam.springbootthymeleaf.service.DersService;
import com.bilgeadam.springbootthymeleaf.service.OgrenciService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(path = "derskayit")
public class DersOgrenciController {
	private DersOgrenciService dersOgrenciService;

	private OgrenciService ogrenciService;

	private DersService dersService;

	@GetMapping(path = "")
	public ModelAndView dersOgrenci() {
		ModelAndView dersOgrenciView = new ModelAndView("dersogrenci/dersogrenci");
		List<DersOgrenci> liste = dersOgrenciService.getAll();
		dersOgrenciView.addObject("dersogrenci_list", liste);
		return dersOgrenciView;
	}

	@GetMapping(path = "detay")
	public ModelAndView detay(@RequestParam(name = "id") Long id) {
		ModelAndView dersOgrenciView = new ModelAndView("dersogrenci/dersogrenci_detay");
		DersOgrenci dersOgrenci = dersOgrenciService.getById(id);
		dersOgrenciView.addObject("dersogrenci", dersOgrenci);
		return dersOgrenciView;
	}

	@GetMapping(path = "guncelle")
	public ModelAndView guncelle(@RequestParam(name = "id") Long id) {
		ModelAndView dersOgrenciView = new ModelAndView("dersogrenci/dersogrenci_guncelle");
		DersOgrenci dersOgrenci = dersOgrenciService.getById(id);
		dersOgrenciView.addObject("dersogrenci", dersOgrenci);
		return dersOgrenciView;
	}

	@PostMapping(path = "guncelle")
	public ModelAndView guncellePost(@ModelAttribute(value = "dersogrenci") DersOgrenci dersOgrenci) {
		dersOgrenciService.save(dersOgrenci);
		return new ModelAndView("redirect:/derskayit");
	}

	@GetMapping(path = "ekle")
	public ModelAndView ekle() {
		ModelAndView dersOgrenciView = new ModelAndView("dersogrenci/dersogrenci_ekle");
		DersOgrenci dersOgrenci = new DersOgrenci();
		dersOgrenciView.addObject("dersogrenci", dersOgrenci);
		List<Ders> ders_list = dersService.getAll();
		dersOgrenciView.addObject("ders_list", ders_list);
		List<Ogrenci> ogrenci_list = ogrenciService.getAll();
		dersOgrenciView.addObject("ogrenci_list", ogrenci_list);

		return dersOgrenciView;
	}

	@PostMapping(path = "ekle")
	public ModelAndView eklePost(@ModelAttribute(name = "dersogrenci") DersOgrenci dersOgrenci) {
		dersOgrenciService.save(dersOgrenci);
		return new ModelAndView("redirect:/derskayit");
	}

	@PostMapping(path = "sil")
	public ModelAndView sil(@ModelAttribute(name = "DERSOGRENCI_ID") Long id) {
		dersOgrenciService.delete(id);
		return new ModelAndView("redirect:/derskayit");

	}
}
