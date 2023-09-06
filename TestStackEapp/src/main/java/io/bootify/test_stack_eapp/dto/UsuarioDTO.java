package io.bootify.test_stack_eapp.dto;

import io.bootify.test_stack_eapp.domain.Usuario;

public class UsuarioDTO {

    private Long id;
    private String nombreUsuario;
    private String nombre;
    private String contrasenha;
    private String apellido;
    
    public Long getId() {return id;
}

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getApellido() {
        return apellido;
    }

    // Constructores, getters, setters...
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombreUsuario = usuario.getNombreUsuario();
        this.nombre = usuario.getNombre();
        this.contrasenha = usuario.getContrasenha();
        this.apellido = usuario.getApellido();
    }

    // ...resto de los getters y setters...

}
