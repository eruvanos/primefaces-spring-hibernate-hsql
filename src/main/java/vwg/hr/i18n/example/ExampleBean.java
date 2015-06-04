package vwg.hr.i18n.example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean
public class ExampleBean {

    @ManagedProperty(value = "#{exampleService}")
    private ExampleService exampleService;

    public List<Example> getAllExamples() {
        return exampleService.readAll();
    }


    public void createRandom(){
        exampleService.createRandom();
    }

    public void setExampleService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }
}
