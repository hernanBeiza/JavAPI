package cl.hiperactivo.javapi.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nota")
public class NotaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnota")
    private Integer idNota;
/*
    @Column(name = "idusuario")
    private Integer idUsuario;
*/
    @Column(name="titulo")
    private String titulo;

    @Column(name = "cuerpo")
    private String cuerpo;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "valid")
    private int valid;

    @ManyToOne
    @JoinColumn(name="idusuario")
    //@JsonManagedReference
    @JsonBackReference
    private UsuarioEntity usuarioEntity;

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    @Override
    public String toString() {
        return "NotaEntity{" +
                "idNota=" + idNota +
                ", titulo='" + titulo + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", valid=" + valid +
                '}';
    }
}