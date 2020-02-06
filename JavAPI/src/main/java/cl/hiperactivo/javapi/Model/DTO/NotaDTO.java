package cl.hiperactivo.javapi.Model.DTO;

import cl.hiperactivo.javapi.Model.Entity.NotaEntity;

public class NotaDTO {

    private Integer idNota;
    private Integer idUsuario;
    private String titulo;
    private String cuerpo;
    private String timestamp;
    private int valid;

    public NotaDTO() { }

    public NotaDTO(NotaEntity notaEntity){
        if(notaEntity!=null){
            this.idNota = notaEntity.getIdNota();
            this.idUsuario = notaEntity.getUsuarioEntity().getIdUsuario();
            this.titulo = notaEntity.getTitulo();
            this.cuerpo = notaEntity.getCuerpo();
            this.timestamp = notaEntity.getTimestamp();
            this.valid = notaEntity.getValid();
        }
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    @Override
    public String toString() {
        return "NotaDTO{" +
                "idNota=" + idNota +
                ", idUsuario=" + idUsuario +
                ", titulo='" + titulo + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", valid=" + valid +
                '}';
    }

}
