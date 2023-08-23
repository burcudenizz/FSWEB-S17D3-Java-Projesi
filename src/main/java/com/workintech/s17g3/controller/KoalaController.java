package com.workintech.s17g3.controller;

import com.workintech.s17g3.entity.Kangaroo;
import com.workintech.s17g3.entity.Koala;
import com.workintech.s17g3.exceptions.AnimalValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalaMap;

    @PostConstruct
    public void init(){
        koalaMap=new HashMap<>();
    }


    @GetMapping("/")
    public List<Koala> getAll() {
        return koalaMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala getById(@PathVariable int id) {
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExist(koalaMap,id);
        return koalaMap.get(id);
    }

    @PostMapping("/")
    public Koala save(@RequestBody Koala koala){
        AnimalValidator.isIdValid(koala.getId());
        AnimalValidator.isAnimalValid(koala);
        AnimalValidator.isKoalaValid(koala);

        koalaMap.put(koala.getId(), koala);
        return koalaMap.get(koala.getId());

    }



    @PutMapping("/{id}")

    public Koala update(Integer id,Koala koala){
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExist(koalaMap,id);
        AnimalValidator.isAnimalValid(koala);
        AnimalValidator.isKoalaValid(koala);

        koalaMap.put(id,koala);
        return koalaMap.get(koala.getId());

    }


    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable int id,@RequestBody Koala koala){
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdExist(koalaMap,id);
        Koala willDeleted = koalaMap.get(id);
        koalaMap.remove(koala.getId());
        return willDeleted;

    }




}
