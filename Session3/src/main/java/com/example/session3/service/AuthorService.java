package com.example.session3.service;

import com.example.session3.model.Author;
import com.example.session3.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id){
        return authorRepository.findById(id);
    }

    public Author updateAuthor(int id, Author request){
        Author author = authorRepository.findById(id);
        if(author == null){
            return null;
        }
        author.setName(request.getName());
        author.setEmail(request.getEmail());

        return author;
    }
}