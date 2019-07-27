package DynamicForm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class StorageService {
    @Autowired
    private HttpServletRequest request;

    public boolean store(MultipartFile file) {
        try {
            System.out.println(file.getOriginalFilename());
            String filePath = request.getServletContext().getRealPath("/");
            System.out.println(filePath);
            File newFile = new File(filePath + new Date().getTime() + "_" + file.getOriginalFilename());
            file.transferTo(newFile);
        } catch (IOException error) {
            System.out.println("Failure to save");
            System.out.println(error.toString());
            return false;
        }
        return true;
    }
}
