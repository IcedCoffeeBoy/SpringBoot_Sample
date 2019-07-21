package DynamicForm;

import Model.Form;
import Model.FormComponent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    @RequestMapping("/forms")
    public Form forms() {
        FormComponent qn1 = new FormComponent("select", "Question 2");
        FormComponent qn2 = new FormComponent("select", "Question 2", "This is very hard");
        return new Form(qn1, qn2);
    }
}
