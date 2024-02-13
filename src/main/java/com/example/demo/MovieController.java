package com.example.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	public MovieRepository mr;

	@PostMapping("/add")
	public <S extends Movie> S save(@RequestBody S entity) {
		return mr.save(entity);
	}

	@GetMapping("/get/page/sort")
	public List<Movie> findAll(Sort sort) {
		return mr.findAll(sort);
	}

	@GetMapping("/get/page")
	public Page<Movie> findAll(Pageable pageable) {
		return mr.findAll(pageable);
	}

	@GetMapping("/get")
	public List<Movie> findAll() {
		return mr.findAll();
	}

	@GetMapping("/get/{id}")
	public Optional<Movie> findById(@PathVariable("id") Integer id) {
		return mr.findById(id);
	}

	@PutMapping("/get/{id}")
	public Movie updateById(@PathVariable("id") Integer id, @RequestBody Movie c) {
		return mr.save(c);
	}

	@DeleteMapping("/get/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		mr.deleteById(id);
	}
	
	
}
