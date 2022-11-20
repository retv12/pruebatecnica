package com.prueba.springbootjpah2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.springbootjpah2.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM Producto p WHERE p.PRODUCTID = :PRODUCTID and p.BRANDID = :BRANDID and STARTDATE BETWEEN :FECHAI AND :FECHAF ", nativeQuery = true)
    List<Producto> findByProductoid(
            @Param("PRODUCTID") Integer PRODUCTID,
            @Param("BRANDID") Integer BRANDID,
            @Param("FECHAI") java.util.Date FECHAI,
            @Param("FECHAF") java.util.Date FECHAF);
}
