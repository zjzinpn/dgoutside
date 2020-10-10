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
@TableName("inclusive_corploan")
public class InclusiveCorploan extends Model<InclusiveCorploan> {

    private static final long serialVersionUID = 1L;

    private String marketcode;
    private String productname;
    private String corpname;
    private String loantype;
    private String corploanbalance;
    private String loanstyle;
    private String plandate;
    private String corpmemo;
    private String indate;


    public String getMarketcode() {
        return marketcode;
    }

    public InclusiveCorploan setMarketcode(String marketcode) {
        this.marketcode = marketcode;
        return this;
    }

    public String getProductname() {
        return productname;
    }

    public InclusiveCorploan setProductname(String productname) {
        this.productname = productname;
        return this;
    }

    public String getCorpname() {
        return corpname;
    }

    public InclusiveCorploan setCorpname(String corpname) {
        this.corpname = corpname;
        return this;
    }

    public String getLoantype() {
        return loantype;
    }

    public InclusiveCorploan setLoantype(String loantype) {
        this.loantype = loantype;
        return this;
    }

    public String getCorploanbalance() {
        return corploanbalance;
    }

    public InclusiveCorploan setCorploanbalance(String corploanbalance) {
        this.corploanbalance = corploanbalance;
        return this;
    }

    public String getLoanstyle() {
        return loanstyle;
    }

    public InclusiveCorploan setLoanstyle(String loanstyle) {
        this.loanstyle = loanstyle;
        return this;
    }

    public String getPlandate() {
        return plandate;
    }

    public InclusiveCorploan setPlandate(String plandate) {
        this.plandate = plandate;
        return this;
    }

    public String getCorpmemo() {
        return corpmemo;
    }

    public InclusiveCorploan setCorpmemo(String corpmemo) {
        this.corpmemo = corpmemo;
        return this;
    }

    public String getIndate() {
        return indate;
    }

    public InclusiveCorploan setIndate(String indate) {
        this.indate = indate;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.corpname;
    }

    @Override
    public String toString() {
        return "InclusiveCorploan{" +
        "marketcode=" + marketcode +
        ", productname=" + productname +
        ", corpname=" + corpname +
        ", loantype=" + loantype +
        ", corploanbalance=" + corploanbalance +
        ", loanstyle=" + loanstyle +
        ", plandate=" + plandate +
        ", corpmemo=" + corpmemo +
        ", indate=" + indate +
        "}";
    }
}
