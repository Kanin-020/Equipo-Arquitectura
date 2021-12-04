package com.crud.demo.controlador;

import java.util.List;
import java.util.Optional;

import com.crud.demo.modelo.InterfaceUsuarioServices;
import com.crud.demo.modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Es la clase encargada de manejar la relación entre la vista y el modelo,
 * contiene llamadas a todos los métodos y los aplica en la vista.
 */
@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private InterfaceUsuarioServices servicio;

    /**
     * Se encarga de desplegar todos los usuarios registrados en la vista de la
     * tabla.
     *
     * @param modelo Objeto de tipo Model del cual se obtienen los métodos.
     * @return Dirección url.
     */
    @GetMapping("/listar")
    public String listar(Model modelo) {
        List<Usuario> usuarios = servicio.listar();
        modelo.addAttribute("usuarios", usuarios);
        return "index";
    }

    /**
     * Se encarga de abrir un formulario en el que se podrán meter los datos de
     * los usuarios.
     *
     * @param modelo Objeto de tipo Model del cual se obtienen los métodos.
     * @return Dirección url
     */
    @GetMapping("/new")
    public String agregar(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "form";
    }

    /**
     * Se encarga de mandar los datos del formulario al modelo.
     *
     * @param usuario Objeto de tipo Usuario el cual contiene los datos de un
     * usuario.
     * @param modelo Objeto de tipo Model del cual se obtienen los métodos.
     * @return Dirección url.
     */
    @PostMapping("/save")
    public String guardar(@Validated Usuario usuario, Model modelo) {
        servicio.save(usuario);
        return "redirect:/listar";
    }

    /**
     * Se encarga de desplegar un formulario para actualizar la información de
     * un usuario.
     *
     * @param id Id del usuario de tipo entero.
     * @param modelo Objeto de tipo Model del cual se obtienen los métodos.
     * @return Dirección url.
     */
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model modelo) {
        Optional<Usuario> usuario = servicio.listarId(id);
        modelo.addAttribute("usuario", usuario);
        return "form";
    }

    /**
     * Se encarga de llamar al método para borrar dentro de la lógica de la
     * aplicación.
     *
     * @param id Id del usuario de tipo entero.
     * @param modelo Objeto de tipo Model del cual se obtienen los métodos.
     * @return Dirección url.
     */
    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model modelo) {
        servicio.delete(id);
        return "redirect:/listar";
    }

    /**
     * Se encarga de llamar al método para borrar varios elementos dentro de la
     * lógica de la aplicación.
     *
     * @param lista Objeto de tipo List donde se guardan los id de varios
     * usuarios.
     * @param modelo Objeto de tipo Model del cual se obtienen los métodos.
     * @return Dirección url.
     */
    @GetMapping("/eliminarVarios/{lista}")
    public String deleteAll(@PathVariable List<Integer> lista, Model modelo) {
        List<Integer> listaUsuario = lista;
        modelo.addAttribute("lista", listaUsuario);
        servicio.deleteAll(listaUsuario);
        return "redirect:/listar";
    }

}
