package com.workintech.s17g3.controller;

import com.workintech.s17g3.entity.Kangaroo;
import com.workintech.s17g3.exceptions.AnimalException;
import com.workintech.s17g3.exceptions.AnimalValidator;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangarooMap;

    @PostConstruct
    public void init() {
        kangarooMap = new HashMap<>();

    }

    @GetMapping("/")
    public List<Kangaroo> getAll() {
        return kangarooMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo getById(@PathVariable int id) {
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExist(kangarooMap,id);
        return kangarooMap.get(id);
    }

    @PostMapping("/")
    public Kangaroo save(@RequestBody Kangaroo kangaroo){
        AnimalValidator.isIdValid(kangaroo.getId());
        AnimalValidator.isAnimalValid(kangaroo);
        AnimalValidator.isKangarooValid(kangaroo);

        kangarooMap.put(kangaroo.getId(), kangaroo);
        return kangarooMap.get(kangaroo.getId());

    }



    @PutMapping("/{id}")

    public Kangaroo update(Integer id,Kangaroo kangaroo){
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExist(kangarooMap,id);
        AnimalValidator.isAnimalValid(kangaroo);
        AnimalValidator.isKangarooValid(kangaroo);

        kangarooMap.put(id,kangaroo);
        return kangarooMap.get(kangaroo.getId());

    }


    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable int id,@RequestBody Kangaroo kangaroo){
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdExist(kangarooMap,id);
        Kangaroo willDeleted = kangarooMap.get(id);
        kangarooMap.remove(kangaroo.getId());
        return willDeleted;

    }


}
