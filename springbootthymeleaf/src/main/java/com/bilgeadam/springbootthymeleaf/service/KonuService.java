package com.bilgeadam.springbootthymeleaf.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.bilgeadam.springbootthymeleaf.model.Konu;
import com.bilgeadam.springbootthymeleaf.repo.KonuRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KonuService {
	private KonuRepo konuRepo;

	public List<Konu> getAll() {

		List<Konu> temp = konuRepo.findAll(Sort.by(Order.asc("ID")));
		List<Konu> list = new LinkedList<Konu>(temp);
		return list;

	}

	public Konu getById(Long id) {
		return konuRepo.findById(id).get();
	}

	public Konu find(String isim) {
		return konuRepo.findKonuByNAME(isim);
	}

	public List<Konu> findNameLike(String expression) {
		return konuRepo.findAllByNAMELike("%" + expression + "%", Sort.by(Order.desc("ID")));
//		return ogretmenRepo.findAllByNAMELikeOrderByNAMEDesc("%" + expression + "%");
		// return ogretmenRepo.findByOgretmenName("%" + expression + "%");
	}

	public Konu save(Konu konu) {
		return konuRepo.save(konu);
	}

//
	public Konu update(Konu konu) {
		return konuRepo.save(konu);
	}

	public boolean delete(Long id) {
		try {
			konuRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
