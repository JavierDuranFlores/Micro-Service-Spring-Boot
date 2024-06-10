package com.javier.user.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javier.user.exception.BadRequestException;
import com.javier.user.exception.NoFoundException;
import com.javier.user.model.BookModel;
import com.javier.user.model.dto.ErrorDTO;
import com.javier.user.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service("userServiceImpl")
public class UserServiceImpl implements BookService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<BookModel> getBook(Integer idBook) {
        try {
        	System.out.println("entrooo: " + idBook );
        	Map<String, Integer> pathVariables = new HashMap<String, Integer>();
            pathVariables.put("id", idBook);
            System.out.println(pathVariables);
            ResponseEntity<BookModel> response = restTemplate.exchange("http://service-book/books/{id}", HttpMethod.GET, null, BookModel.class, pathVariables);
            System.out.println(response);
            BookModel book = response.getBody();
        return new ResponseEntity<>(book, response.getStatusCode());
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode()== HttpStatus.NOT_FOUND) {
                Map<String, String> values = extractValues(e.getMessage());
                throw new NoFoundException(values.get("code"), values.get("mensaje"));
            }
            return new ResponseEntity<>(null, e.getStatusCode());
        }
    }

    @Override
    public ResponseEntity<BookModel> saveBook(BookModel bookModel) {
        try {
        	System.out.println("entroo");
            HttpEntity<BookModel> body = new HttpEntity<>(bookModel);
            ResponseEntity<BookModel> response = restTemplate.exchange("http://service-book/books", HttpMethod.POST, body, BookModel.class);
            BookModel book = response.getBody();
            return new ResponseEntity<>(book, response.getStatusCode());
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode()== HttpStatus.NOT_FOUND) {
                Map<String, String> values = extractValues(e.getMessage());
                throw new NoFoundException(values.get("code"), values.get("mensaje"));
            } else if (e.getStatusCode()== HttpStatus.BAD_REQUEST) {

                Map<String, String> values = extractValues(e.getMessage());
                throw new BadRequestException(values.get("code"), values.get("mensaje"));
            }
            return new ResponseEntity<>(null, e.getStatusCode());
        }
       
    }

    @Override
    public ResponseEntity<BookModel> updateBook(BookModel bookModel, Integer idBook) {
        try {
            Map<String, String> pathVariables = new HashMap<String, String>();
            pathVariables.put("id", idBook.toString());
            HttpEntity<BookModel> body = new HttpEntity<>(bookModel);
            ResponseEntity<BookModel> response = restTemplate.exchange("http://service-book/books/{id}", HttpMethod.PUT, body, BookModel.class, pathVariables);
            BookModel book = response.getBody();
            return new ResponseEntity<>(book, response.getStatusCode());
        } catch (HttpClientErrorException e) {
            System.out.println("Client: " + e);

            if (e.getStatusCode()== HttpStatus.NOT_FOUND) {
                Map<String, String> values = extractValues(e.getMessage());
                throw new NoFoundException(values.get("code"), values.get("mensaje"));
            } else if (e.getStatusCode()== HttpStatus.BAD_REQUEST) {
                Map<String, String> values = extractValues(e.getMessage());
                throw new BadRequestException(values.get("code"), values.get("mensaje"));
            }
            return new ResponseEntity<>(null, e.getStatusCode());
        }
    }

    @Override
    public ResponseEntity<BookModel> deleteBook(Integer idBook) {
        try {
            Map<String, String> pathVariables = new HashMap<String, String>();
            pathVariables.put("id", idBook.toString());
            ResponseEntity<BookModel> response = restTemplate.exchange("http://service-book/books/{id}", HttpMethod.DELETE, null, BookModel.class, pathVariables);
            BookModel book = response.getBody();
            return new ResponseEntity<>(book, response.getStatusCode());
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode()== HttpStatus.NOT_FOUND) {
                Map<String, String> values = extractValues(e.getMessage());
                throw new NoFoundException(values.get("code"), values.get("mensaje"));
            }
            return new ResponseEntity<>(null, e.getStatusCode());
        }
    }

    public static Map<String, String> extractValues(String jsonString) {
        try {
            // Extraer la parte JSON de la cadena
            String jsonPart = jsonString.split(" : ")[1];

            // Eliminar comillas adicionales si es necesario
            if (jsonPart.startsWith("\"") && jsonPart.endsWith("\"")) {
                jsonPart = jsonPart.substring(1, jsonPart.length() - 1);
            }

            // Crear un objeto ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Parsear la cadena JSON a un JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonPart);

            // Extraer los valores de code y mensaje
            String code = rootNode.path("code").asText();
            String mensaje = rootNode.path("mensaje").asText();

            // Almacenar los valores en un mapa
            Map<String, String> values = new HashMap<>();
            values.put("code", code);
            values.put("mensaje", mensaje);

            return values;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
