package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class PersonController {

	@RestController
	public class MovieController {

		@Autowired
		public PersonRepository pr;

		@PostMapping("/add")
		public <S extends Person> S save(@RequestBody S entity) {
			return pr.save(entity);
		}

		@GetMapping("/get/page/sort")
		public List<Person> findAll(Sort sort) {
			return pr.findAll(sort);
		}

		@GetMapping("/get/page")
		public Page<Person> findAll(Pageable pageable) {
			return pr.findAll(pageable);
		}

		@GetMapping("/get")
		public List<Person> findAll() {
			return pr.findAll();
		}

		@GetMapping("/get/{id}")
		public Optional<Person> findById(@PathVariable("id") Integer id) {
			return pr.findById(id);
		}

		@PutMapping("/get/{id}")
		public Person updateById(@PathVariable("id") Integer id, @RequestBody Person c) {
			return pr.save(c);
		}

		@DeleteMapping("/get/{id}")
		public void deleteById(@PathVariable("id") Integer id) {
			pr.deleteById(id);
		}
}}
