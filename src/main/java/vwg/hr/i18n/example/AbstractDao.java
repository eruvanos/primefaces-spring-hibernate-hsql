package vwg.hr.i18n.example;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao {
    @PersistenceContext
    protected EntityManager em;
}
