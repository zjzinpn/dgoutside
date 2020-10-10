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
@TableName("inclusive_housename")
public class InclusiveHousename extends Model<InclusiveHousename> {

    private static final long serialVersionUID = 1L;

    private String housename;


    public String getHousename() {
        return housename;
    }

    public InclusiveHousename setHousename(String housename) {
        this.housename = housename;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.housename;
    }

    @Override
    public String toString() {
        return "InclusiveHousename{" +
        "housename=" + housename +
        "}";
    }
}
