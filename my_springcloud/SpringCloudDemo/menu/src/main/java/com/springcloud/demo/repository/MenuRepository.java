package com.springcloud.demo.repository;

import com.springcloud.demo.entity.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {

}
