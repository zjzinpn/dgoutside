package com.dgoutside.modules.inclusive.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuxy
 * @since 2020-04-24
 */
@TableName("inclusive_equickloan")
public class InclusiveEquickloan extends Model<InclusiveEquickloan> {

    private static final long serialVersionUID = 1L;

    private String marketcode;
    private String productname;
    private String custname;
    private String housename;
    private String equickloanbalance;
    private String doename;
    private String estateno;
    private String buybackflag;
    private String equickmemo;
    private String indate;


    public String getMarketcode() {
        return marketcode;
    }

    public InclusiveEquickloan setMarketcode(String marketcode) {
        this.marketcode = marketcode;
        return this;
    }

    public String getProductname() {
        return productname;
    }

    public InclusiveEquickloan setProductname(String productname) {
        this.productname = productname;
        return this;
    }

    public String getCustname() {
        return custname;
    }

    public InclusiveEquickloan setCustname(String custname) {
        this.custname = custname;
        return this;
    }

    public String getHousename() {
        return housename;
    }

    public InclusiveEquickloan setHousename(String housename) {
        this.housename = housename;
        return this;
    }

    public String getEquickloanbalance() {
        return equickloanbalance;
    }

    public InclusiveEquickloan setEquickloanbalance(String equickloanbalance) {
        this.equickloanbalance = equickloanbalance;
        return this;
    }

    public String getDoename() {
        return doename;
    }

    public InclusiveEquickloan setDoename(String doename) {
        this.doename = doename;
        return this;
    }

    public String getEstateno() {
        return estateno;
    }

    public InclusiveEquickloan setEstateno(String estateno) {
        this.estateno = estateno;
        return this;
    }

    public String getBuybackflag() {
        return buybackflag;
    }

    public InclusiveEquickloan setBuybackflag(String buybackflag) {
        this.buybackflag = buybackflag;
        return this;
    }

    public String getEquickmemo() {
        return equickmemo;
    }

    public InclusiveEquickloan setEquickmemo(String equickmemo) {
        this.equickmemo = equickmemo;
        return this;
    }

    public String getIndate() {
        return indate;
    }

    public InclusiveEquickloan setIndate(String indate) {
        this.indate = indate;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.custname;
    }

    @Override
    public String toString() {
        return "InclusiveEquickloan{" +
        "marketcode=" + marketcode +
        ", productname=" + productname +
        ", custname=" + custname +
        ", housename=" + housename +
        ", equickloanbalance=" + equickloanbalance +
        ", doename=" + doename +
        ", estateno=" + estateno +
        ", buybackflag=" + buybackflag +
        ", equickmemo=" + equickmemo +
        ", indate=" + indate +
        "}";
    }
}
