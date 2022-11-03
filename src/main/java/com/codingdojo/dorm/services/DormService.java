package com.codingdojo.dorm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dorm.models.Dorm;
import com.codingdojo.dorm.repositories.DormRepository;

@Service
public class DormService {

	@Autowired
	private DormRepository dorm;
	
	public List<Dorm> allDorms() {
		return dorm.findAll();
	}
	
	public Dorm findById(Long id) {
		Optional<Dorm> option = dorm.findById(id);
		if (option.isPresent()) {
			return option.get();
		}
		return null;
	}
	
	public Dorm addDorm(Dorm d) {
		return dorm.save(d); 
	}
	
	public Dorm updateDorm(Dorm d) {
		return dorm.save(d);
	}
	
}
