package com.crud.demo.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Se encarga de crear entidades de tipo usuario para
 * poder manejar los usuarios en la base datos.
 */
@Repository
public interface InterfaceUsuario extends CrudRepository<Usuario, Integer> {
};
