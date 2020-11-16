package com.ebraegel.heavycats.contoller;

import com.ebraegel.heavycats.jpa.repository.CatRepository;
import com.ebraegel.heavycats.jpa.repository.WeightRepository;
import com.ebraegel.heavycats.model.Weight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ebraegel.heavycats.jpa.exception.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class WeightController {
    @Autowired
    private WeightRepository weightRepository;

    @Autowired
    private CatRepository catRepository;

    @GetMapping(path="/cats/{catId}/weights")
    public List<Weight> getAllByCatId(@PathVariable("catId") Long catId) {
        return weightRepository.findByCatId(catId);
    }

    @GetMapping(path="/cats/{catId}/weights/{weightId}")
    public Optional<Weight> getByCatId(@PathVariable("catId") Long catId, @PathVariable("weightId") Long weightId) {
        return weightRepository.findByIdAndCatId(weightId, catId);
    }

    @PostMapping("/cats/{catId}/weights")
    public Weight create(@PathVariable (value = "catId") Long catId,
                                 @Valid @RequestBody Weight weight) {
        return catRepository.findById(catId).map(cat -> {
            weight.setCat(cat);
            return weightRepository.save(weight);
        }).orElseThrow(() -> new ResourceNotFoundException("CatId " + catId + " not found"));
    }
}
