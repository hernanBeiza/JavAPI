package cl.hiperactivo.javapi.Persistence.DAO;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Model.Entity.NotaEntity;

import java.util.ArrayList;

public interface NotaDAO {

    ArrayList<NotaEntity> obtener();

    NotaEntity obtenerConID(NotaDTO notaDTO);

    boolean guardar(NotaDTO notaDTO);

    boolean editar(NotaDTO notaDTO);

    boolean eliminar(NotaDTO notaDTO);
}
