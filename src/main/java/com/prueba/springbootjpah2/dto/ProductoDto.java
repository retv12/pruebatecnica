package com.prueba.springbootjpah2.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductoDto {

    private Integer BRANDID;
    private Integer PRODUCTID;
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone =
    // "Europe/Rome")
    private Date FECHA;

    public ProductoDto() {
    }

    public Integer getBRANDID() {
        return BRANDID;
    }

    public void setBRANDID(Integer bRANDID) {
        BRANDID = bRANDID;
    }

    public Integer getPRODUCTID() {
        return PRODUCTID;
    }

    public void setPRODUCTID(Integer pRODUCTID) {
        PRODUCTID = pRODUCTID;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date fECHA) {
        FECHA = fECHA;
    }

}
