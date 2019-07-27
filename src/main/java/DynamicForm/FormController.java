package DynamicForm;

import DynamicForm.Model.FormComponent;
import DynamicForm.Services.FormService;
import DynamicForm.Services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/forms")
public class FormController {
    @Autowired
    private FormService formService;

    @Autowired
    private StorageService storageService;

    @RequestMapping("/get/{id}")
    public FormComponent[] getform(@PathVariable("id") int id) {
        FormComponent qn1 = new FormComponent("select", String.format("Question %d", formService.getId(id)));
        FormComponent qn2 = new FormComponent("select", "Question 2", "This is very hard");
        return new FormComponent[]{qn1, qn2};
    }

    @PostMapping("/post/{id}")
    public String postForm(
            @PathVariable("id") int id,
            @RequestParam("file") MultipartFile file
    ) {
        System.out.println("POST Request!");
        boolean result = storageService.store(file);
        if (result) {
            return "Submitted";
        } else {
            return "failed";
        }
    }
}
