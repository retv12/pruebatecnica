package com.prueba.springbootjpah2.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IDREG;

    @Column(name = "BRANDID")
    private Integer BRANDID;

    @Column(name = "STARTDATE")
    @CreationTimestamp
    private Date STARTDATE;

    @Column(name = "ENDDATE")
    @CreationTimestamp
    private Date ENDDATE;

    @Column(name = "PRICELIST")
    private Integer PRICELIST;

    @Column(name = "PRODUCTID")
    private Integer PRODUCTID;

    @Column(name = "PRIORITY")
    private Integer PRIORITY;

    @Column(name = "PRICE")
    private BigDecimal PRICE;

    @Column(name = "CURR")
    private String CURR;

    public long getIDREG() {
        return IDREG;
    }

    public void setIDREG(long iDREG) {
        IDREG = iDREG;
    }

    public Integer getBRANDID() {
        return BRANDID;
    }

    public void setBRANDID(Integer bRANDID) {
        BRANDID = bRANDID;
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

    public Integer getPRICELIST() {
        return PRICELIST;
    }

    public void setPRICELIST(Integer pRICELIST) {
        PRICELIST = pRICELIST;
    }

    public Integer getPRODUCTID() {
        return PRODUCTID;
    }

    public void setPRODUCTID(Integer pRODUCTID) {
        PRODUCTID = pRODUCTID;
    }

    public Integer getPRIORITY() {
        return PRIORITY;
    }

    public void setPRIORITY(Integer pRIORITY) {
        PRIORITY = pRIORITY;
    }

    public BigDecimal getPRICE() {
        return PRICE;
    }

    public void setPRICE(BigDecimal pRICE) {
        PRICE = pRICE;
    }

    public String getCURR() {
        return CURR;
    }

    public void setCURR(String cURR) {
        CURR = cURR;
    }

    @Override
    public String toString() {
        return "Producto [IDREG=" + IDREG + ", BRANDID=" + BRANDID + ", STARTDATE=" + STARTDATE + ", ENDDATE=" + ENDDATE
                + ", PRICELIST=" + PRICELIST + ", PRODUCTID=" + PRODUCTID + ", PRIORITY=" + PRIORITY + ", PRICE="
                + PRICE + ", CURR=" + CURR + "]";
    }
}
