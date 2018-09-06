package cl.hiperactivo.javapi.Service;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;

import java.util.ArrayList;

public interface NotaService {

    ArrayList<NotaDTO> obtener();

    NotaDTO obtenerConID(NotaDTO notaDTO);

    boolean guardar(NotaDTO notaDTO);

    boolean editar(NotaDTO notaDTO);

    boolean eliminar(NotaDTO notaDTO);
}
