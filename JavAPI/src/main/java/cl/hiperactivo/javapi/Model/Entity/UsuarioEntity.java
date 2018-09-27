package cl.hiperactivo.javapi.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;

    @Column(name="nombre")
    private String nombre;

    @Column(name = "valid")
    private int valid;
    //Nombre del atributo en NotaEntity, no de la columna
    @OneToMany(mappedBy = "usuarioEntity", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<NotaEntity> notas;

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

    public List<NotaEntity> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaEntity> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", valid=" + valid +
                ", notas=" + notas +
                '}';
    }
}