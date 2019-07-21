package DynamicForm.Model;

public class FormComponent {
    public String type;
    public String label;
    public String description;

    public FormComponent(String type, String label, String description) {
        this.type = type;
        this.label = label;
        this.description = description;

    }

    public FormComponent(String type, String label) {
        this.type = type;
        this.label = label;
    }

}
