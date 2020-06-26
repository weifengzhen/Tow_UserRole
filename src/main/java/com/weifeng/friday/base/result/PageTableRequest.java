package com.weifeng.friday.base.result;

import lombok.Data;

import java.io.Serializable;


/**
 * 分页公共类
 */
@Data
public class PageTableRequest implements Serializable {

    private Integer page;    //当前页
    private Integer limit;   //条数
    private Integer offset;

    public void countOffset(){
        if(null == this.page || null == this.limit){
            this.offset = 0;
            return;
        }
        this.offset = (this.page - 1) * limit;
    }


}
