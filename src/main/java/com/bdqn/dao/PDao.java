package com.bdqn.dao;

import com.bdqn.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PDao {
    //查询热门商品信息
    List<Product> hots();

    //查询最新商品信息
    List<Product> nets();

    //查询指定的商品
    Product pInfo(@Param("pid") int pid);

    //分页查询商品信息
    List<Product> pageInfo();

}
