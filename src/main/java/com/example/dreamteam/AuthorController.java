package com.example.dreamteam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    private AuthorModel model;

    // @Autowired
    /**
     * @param model
     */
    public AuthorController(AuthorModel model) {
        this.model = model;
    }

    @GetMapping("/author")
    public ResponseEntity<String> getAuthorName() {
        try {
            String authorName = model.getAuthorName();
            return new ResponseEntity<>(authorName, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public AuthorModel getModel() {
        return model;
    }

    public void setModel(AuthorModel model) {
        this.model = model;
    }
}
