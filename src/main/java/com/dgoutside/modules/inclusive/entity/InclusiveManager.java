package com.dgoutside.modules.inclusive.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuxy
 * @since 2020-04-28
 */
@TableName("inclusive_manager")
public class InclusiveManager extends Model<InclusiveManager> {

    private static final long serialVersionUID = 1L;

    private String branchname;
    private String branchcode;
    private String networkname;
    private String networkcode;
    private String name;
    private String marketcode;


    public String getBranchname() {
        return branchname;
    }

    public InclusiveManager setBranchname(String branchname) {
        this.branchname = branchname;
        return this;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public InclusiveManager setBranchcode(String branchcode) {
        this.branchcode = branchcode;
        return this;
    }

    public String getNetworkname() {
        return networkname;
    }

    public InclusiveManager setNetworkname(String networkname) {
        this.networkname = networkname;
        return this;
    }

    public String getNetworkcode() {
        return networkcode;
    }

    public InclusiveManager setNetworkcode(String networkcode) {
        this.networkcode = networkcode;
        return this;
    }

    public String getName() {
        return name;
    }

    public InclusiveManager setName(String name) {
        this.name = name;
        return this;
    }

    public String getMarketcode() {
        return marketcode;
    }

    public InclusiveManager setMarketcode(String marketcode) {
        this.marketcode = marketcode;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.marketcode;
    }

    @Override
    public String toString() {
        return "InclusiveManager{" +
        "branchname=" + branchname +
        ", branchcode=" + branchcode +
        ", networkname=" + networkname +
        ", networkcode=" + networkcode +
        ", name=" + name +
        ", marketcode=" + marketcode +
        "}";
    }
}
