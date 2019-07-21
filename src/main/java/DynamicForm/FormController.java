package DynamicForm;

import DynamicForm.Model.FormComponent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    @RequestMapping("/forms/{id}")
    public FormComponent forms(@PathVariable("id") int id, FormService formService) {

        FormComponent qn1 = new FormComponent("select", String.format("Question %d",formService.getId()));
        FormComponent qn2 = new FormComponent("select", "Question 2", "This is very hard");
        return id == 1 ? qn1 : qn2;
    }
}
