package com.example.session3.controller;

import com.example.session3.model.Author;
import com.example.session3.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getAuthorById(@PathVariable("id") int id){
        Author author = authorService.getAuthorById(id);
        if (author == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tác giả với ID là:" + id);
        }
        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable("id") int id, @RequestBody Author request){
        Author updated = authorService.updateAuthor(id, request);
        if (updated == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tác giả có ID là: " + id);
        }
        return ResponseEntity.ok(updated);
    }

}
