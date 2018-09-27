package cl.hiperactivo.javapi.Model.DTO;

import cl.hiperactivo.javapi.Model.Entity.NotaEntity;
import cl.hiperactivo.javapi.Model.Entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    private Integer idUsuario;
    private String nombre;
    private int valid;

    private List<NotaDTO> notas;

    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity){
        this.idUsuario = usuarioEntity.getIdUsuario();
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
                ", nombre='" + nombre + '\'' +
                ", notas=" + notas +
                ", valid=" + valid +
                '}';
    }
}
