package vwg.hr.i18n.example;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ExampleDao extends AbstractDao {

    @Transactional
    public void createRandom(){
        Example example = new Example();
        example.setName(Math.random() + "");
        em.persist(example);
    }

}
