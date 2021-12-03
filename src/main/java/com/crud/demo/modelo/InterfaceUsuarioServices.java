package com.crud.demo.modelo;

import java.util.List;
import java.util.Optional;
/**
 * Se encarga de crear entidades de tipo UsuarioService para recopilación
 * de los datos de la vista.
 */
public interface InterfaceUsuarioServices {
/**
 * Estructura de la función que será heredada.
 * @return Lista de usuarios.
 */
    public List<Usuario> listar();
/**
 * Estructura de la función que será heredada.
 * @param id id del usuario que será seleccionado.
 * @return Valor opcional que puede o no ser devuelto.
 */
    public Optional<Usuario> listarId(int id);
/**
 * Estructura de la función que será heredada.
 * @param user Objeto de tipo Usuario.
 * @return Bandera de verificación.
 */
    public int save(Usuario user);
/**
 * Estructura de la función que será heredada.
 * @param id id del usuario que será seleccionado.
 */
    public void delete(int id);
/**
 * Estructura de la función que será heredada.
 * @param lista Lista de id´s de varios usuarios.
 */
    public void deleteAll(List<Integer> lista);

}
