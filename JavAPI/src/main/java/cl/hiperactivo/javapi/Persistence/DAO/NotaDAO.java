package cl.hiperactivo.javapi.Persistence.DAO;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Model.Entity.NotaEntity;

import java.util.ArrayList;

public interface NotaDAO {

    ArrayList<NotaEntity> obtener();

    ArrayList<NotaEntity> obtenerConIDUsuario(NotaDTO notaDTO);

    NotaEntity obtenerConID(NotaDTO notaDTO);

    NotaEntity guardar(NotaDTO notaDTO);

    NotaEntity editar(NotaDTO notaDTO);

    boolean eliminar(NotaDTO notaDTO);
}
