package com.linjr.utils;

import com.linjr.vo.resp.PageVO;
import com.github.pagehelper.Page;

import java.util.List;

public class PageUtil {

    private PageUtil() {

    }

    public static <T> PageVO getPage(List<T> list) {
        PageVO<T> pageVO = new PageVO<>();

        if (list instanceof Page) {
            Page page = (Page) list;
            pageVO.setTotalRows(page.getTotal());
            pageVO.setList(page.getResult());
            pageVO.setTotalPages(page.getPages());
            pageVO.setPageSize(page.getPageSize());
            pageVO.setPageNum(page.getPageNum());
            pageVO.setCurPageSize(page.size());
        }
        return pageVO;
    }

}
