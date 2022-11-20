package com.prueba.springbootjpah2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.springbootjpah2.dto.ProductoDto;
import com.prueba.springbootjpah2.model.Producto;
import com.prueba.springbootjpah2.repository.ProductoRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("/producto/test")
    public String test() {
        return "Hello World";
    }

    @GetMapping("/producto/")
    public ResponseEntity<List<Producto>> getAllProducto() {
        List<Producto> producto = new ArrayList<Producto>();
        productoRepository.findAll().forEach(producto::add);
        if (producto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/producto/")
    public ResponseEntity<List<Producto>> getAllProductofind(@RequestBody ProductoDto data) {
        Boolean error = false;

        List<Producto> producto = new ArrayList<Producto>();

        productoRepository.findByProductoid(
                data.getPRODUCTID(),
                data.getBRANDID(),
                data.getFECHA())
                .forEach(producto::add);
        if (producto.isEmpty()) {
            return new ResponseEntity<>(producto, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(productoRepository.findAll(), HttpStatus.OK);
    }
}
