package com.charlies.beach.infrastructure.repository.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlies.beach.application.service.IMenus;
import com.charlies.beach.domain.entities.Menus;

@Service
public class MenusAdapter  implements IMenus{

    @Override
    public Optional<Menus> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Menus save(Menus menus) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Menus> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Menus update(Long id, Menus menus) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


}
