package com.springcloud.demo.service;

import com.springcloud.demo.entity.Menu;
import com.springcloud.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu save(Menu menu){
        Menu newMenu = menuRepository.save(menu);
        return newMenu;
    }

    public List<Menu> findAll() {

        return (List<Menu>) menuRepository.findAll();

    }
}
