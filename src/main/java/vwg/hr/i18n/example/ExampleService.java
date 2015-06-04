package vwg.hr.i18n.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class ExampleService {


    @Autowired
    private ExampleDao exampleDao;
    @Autowired
    private ExampleRepository exampleRepository;

    public List<Example> readAll() {
//        return exampleDao.readAll();
        return new LinkedList<Example>((Collection<? extends Example>) exampleRepository.findAll());
    }

    public void createRandom(){
        exampleDao.createRandom();
    }





}
