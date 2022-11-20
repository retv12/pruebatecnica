package com.prueba.springbootjpah2.dto;

import java.util.Date;

public class ProductoDto {

    private Integer BRANDID;
    private Integer PRODUCTID;
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
