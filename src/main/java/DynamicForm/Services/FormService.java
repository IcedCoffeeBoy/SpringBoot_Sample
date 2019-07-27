package DynamicForm.Services;

import org.springframework.stereotype.Service;

@Service
public class FormService {
    int id = 123;

    public int getId(int index) {
        return id + index;
    }

}
