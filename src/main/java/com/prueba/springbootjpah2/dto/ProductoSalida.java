package com.prueba.springbootjpah2.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductoSalida {

    private Integer BRANDID;
    private Integer PRODUCTID;
    private BigDecimal PRICE;
    private Integer PRICELIST;
    private Date STARTDATE;
    private Date ENDDATE;
    private Integer PRIORITY;

    public ProductoSalida() {
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

    public BigDecimal getPRICE() {
        return PRICE;
    }

    public void setPRICE(BigDecimal pRICE) {
        PRICE = pRICE;
    }

    public Integer getPRICELIST() {
        return PRICELIST;
    }

    public void setPRICELIST(Integer pRICELIST) {
        PRICELIST = pRICELIST;
    }

    public Date getSTARTDATE() {
        return STARTDATE;
    }

    public void setSTARTDATE(Date sTARTDATE) {
        STARTDATE = sTARTDATE;
    }

    public Date getENDDATE() {
        return ENDDATE;
    }

    public void setENDDATE(Date eNDDATE) {
        ENDDATE = eNDDATE;
    }

    public Integer getPRIORITY() {
        return PRIORITY;
    }

    public void setPRIORITY(Integer pRIORITY) {
        PRIORITY = pRIORITY;
    }

    @Override
    public String toString() {
        return "ProductoSalida [BRANDID=" + BRANDID + ", PRODUCTID=" + PRODUCTID + ", PRICE=" + PRICE + ", PRICELIST="
                + PRICELIST + ", STARTDATE=" + STARTDATE + ", ENDDATE=" + ENDDATE + ", PRIORITY=" + PRIORITY + "]";
    }
}
