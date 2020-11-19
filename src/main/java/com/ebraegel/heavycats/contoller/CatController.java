package com.ebraegel.heavycats.contoller;

import com.ebraegel.heavycats.jpa.repository.CatRepository;
import com.ebraegel.heavycats.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CatController {

    @Autowired
    private CatRepository catRepository;

    @GetMapping("/cats")
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @GetMapping("/cats/{id}")
    public Optional<Cat> get(@PathVariable("id") Long id) {
        return catRepository.findById(id);
    }

    @PostMapping("/cats")
    public Cat create(@Valid @RequestBody Cat cat) {
        return catRepository.save(cat);
    }

    @DeleteMapping("/cats/{id}")
    public void delete(@PathVariable("id") Long id) {
        catRepository.deleteById(id);
    }
}
