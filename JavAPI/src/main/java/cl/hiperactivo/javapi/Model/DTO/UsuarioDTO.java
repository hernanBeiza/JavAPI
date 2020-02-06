package cl.hiperactivo.javapi.Model.DTO;

import cl.hiperactivo.javapi.Model.Entity.NotaEntity;
import cl.hiperactivo.javapi.Model.Entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    private Integer idUsuario;
    private String usuario;
    private String contrasena;
    private String nombre;
    private int valid;

    private List<NotaDTO> notas;

    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity){
        this.idUsuario = usuarioEntity.getIdUsuario();
        this.usuario = usuarioEntity.getUsuario();
        this.contrasena = usuarioEntity.getContrasena();
        this.nombre = usuarioEntity.getNombre();

        this.notas = new ArrayList<NotaDTO>();
        for (NotaEntity entity : usuarioEntity.getNotas()) {
            NotaDTO notaDTO = new NotaDTO(entity);
            this.notas.add(notaDTO);
        }
        this.valid = usuarioEntity.getValid();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public List<NotaDTO> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaDTO> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "idUsuario=" + idUsuario +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", nombre='" + nombre + '\'' +
                ", valid=" + valid +
                ", notas=" + notas +
                '}';
    }
}
