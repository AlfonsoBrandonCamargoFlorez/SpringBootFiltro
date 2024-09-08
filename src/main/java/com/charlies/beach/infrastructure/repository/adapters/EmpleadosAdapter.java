package com.charlies.beach.infrastructure.repository.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlies.beach.application.service.IEmpleados;
import com.charlies.beach.domain.entities.Empleados;

@Service
public class EmpleadosAdapter implements IEmpleados{

    @Override
    public Optional<Empleados> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Empleados save(Empleados empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Empleados> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Empleados update(Long id, Empleados empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


}
