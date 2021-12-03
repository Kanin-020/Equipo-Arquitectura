package com.crud.demo.modelo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Se encarga de realizar las operaciones del CRUD con los
 * usuarios disponibles en la base de datos.
 */
@Service
public class UsuarioService implements InterfaceUsuarioServices {

    @Autowired
    private InterfaceUsuario data;
/**
 * Se encarga de llamar al método findAll del atributo data.
 * @return Lista de usuarios.
 */
    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) data.findAll();
    }
/**
 * Se encarga de llamar al método findById del atributo data.
 * @param id id del usuarario que será utilizado.
 * @return Puede devolver o no un valor de usuario.
 */
    @Override
    public Optional<Usuario> listarId(int id) {
        return data.findById(id);
    }
/**
 * Se encarga de recibir un usuario y validar que la información
 * de este sea correcta.
 * @param user Objeto de tipo usuario del cual obtiene los datos del usuario.
 * @return 1 si el valor se guardó, 0 de otra manera.
 */
    @Override
    public int save(Usuario user) {
        int respuesta = 0;

        Usuario usuario = data.save(user);

        if (usuario != null) {
            respuesta = 1;
        }
        return respuesta;
    }
/**
 * Se encarga de borrar un usuario utilizando su id como referencia.
 * @param id id del usuario que será borrado.
 */
    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
/**
 * Se encarga de borrar varios usuarios utilizando su id como referencia.
 * @param list Lista con los id de los usuarios que será eliminados.
 */
    @Override
    public void deleteAll(List<Integer> list) {
        int i;
        for (i = 0; i < list.size(); i++) {
            data.deleteById(list.get(i));
        }
    }

}
