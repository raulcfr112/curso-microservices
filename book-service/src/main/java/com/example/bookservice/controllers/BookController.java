package com.example.bookservice.controllers;

import com.example.bookservice.model.Book;
import com.example.bookservice.proxy.CambioProxy;
import com.example.bookservice.repositorys.BookRespository;
import com.example.bookservice.response.Cambio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private CambioProxy proxy;

    @Autowired
    private BookRespository respository;

    @Operation(summary = "Find a specific book by your ID")
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        var book = respository.getById(id);
        if (book == null) throw new RuntimeException("Book not found");


        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment("Book port:" + port + "Cambio port " + cambio.getEnvironment());
        book.setPrice((cambio.getConvertedValue()));
        return book;
    }

}
