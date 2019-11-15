package it.nextre.academy.neo4j.service;


import it.nextre.academy.neo4j.model.Film;
import it.nextre.academy.neo4j.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FilmServiceImpl {

    private static AtomicInteger cont = new AtomicInteger();

    @Autowired
    FilmRepository filmRepository;

    public List<Film> findAll(){
        return (List)filmRepository.findAll();
    }
    public Film findOneById(Integer id){
        return filmRepository.findById(id).orElseThrow(()->new RuntimeException("Film non presente"));
    }

    public Film addOne(){
        Film f = new Film(cont.addAndGet(1), "Titolo film 1","pico pallino");
        f= filmRepository.save(f);
        System.out.println(f);
        return f;
    }

}//end class
