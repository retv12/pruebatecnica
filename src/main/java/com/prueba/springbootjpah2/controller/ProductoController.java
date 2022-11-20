package com.prueba.springbootjpah2.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.springbootjpah2.dto.ProductoDto;
import com.prueba.springbootjpah2.dto.ProductoSalida;
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
    public ResponseEntity<List<ProductoSalida>> getAllProductofind(@RequestBody ProductoDto data) {
        Date FechaInicio = removeTime(data.getFECHA());
        Date FechaFIN = addTime(data.getFECHA());
        Integer HoraDia = getHour(data.getFECHA()) + 5;

        List<Producto> producto = new ArrayList<Producto>();
        List<ProductoSalida> Salida = new ArrayList<ProductoSalida>();

        // Comsumo Repository Con Query
        productoRepository.findByProductoid(
                data.getPRODUCTID(),
                data.getBRANDID(),
                FechaInicio,
                FechaFIN)
                .forEach(producto::add);

        for (int i = 0; i < producto.size(); i++) {
            Integer Ini = getHour(producto.get(i).getSTARTDATE());
            Integer Fin = getHour(producto.get(i).getENDDATE());
            if (RangoHoras(Ini, Fin, HoraDia)) {
                ProductoSalida item = new ProductoSalida();
                item.setBRANDID(producto.get(i).getBRANDID());
                item.setPRODUCTID(producto.get(i).getPRODUCTID());
                item.setPRICE(producto.get(i).getPRICE());
                item.setPRICELIST(producto.get(i).getPRICELIST());
                item.setSTARTDATE(producto.get(i).getSTARTDATE());
                item.setENDDATE(producto.get(i).getENDDATE());
                item.setPRIORITY(producto.get(i).getPRIORITY());
                Salida.add(item);
            }
        }

        if (producto.isEmpty()) {
            return new ResponseEntity<>(Salida, HttpStatus.NO_CONTENT);
        }

        System.out.println("Cantidad " + Salida.size());

        // Filtro si tengo mas de un producto
        if (Salida.size() == 2) {
            List<ProductoSalida> filteredList = Salida.stream()
                    .filter(article -> article.getPRIORITY().equals(1)).collect(Collectors.toList());
            Salida = null;
            Salida = filteredList;
        }
        return new ResponseEntity<>(Salida, HttpStatus.OK);
    }

    private static Date removeTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private static Date addTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private static Integer getHour(Date date) {
        SimpleDateFormat formatMinutes = new SimpleDateFormat("HH");
        String getHours = formatMinutes.format(date);
        // Revisar configuracion regional de time zone
        return Integer.valueOf(getHours);
    }

    private Boolean RangoHoras(Integer Ini, Integer Fin, Integer Evaluar) {
        Boolean result = false;
        List<Integer> hora = new ArrayList<Integer>();
        for (int x = Ini; x < Fin; x++) {
            hora.add(x);
        }
        if (hora.contains(Evaluar)) {
            result = true;
        }
        return result;
    }
}
