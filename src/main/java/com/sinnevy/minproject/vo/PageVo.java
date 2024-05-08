package com.sinnevy.minproject.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageVo<T> {

    private Integer page;

    private Integer pageSize;

    private Integer total;

    private List<T> list;

    public PageVo<T> init(Integer page, Integer pageSize, Integer total) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.list = new ArrayList<>();
        return this;

    }



}
