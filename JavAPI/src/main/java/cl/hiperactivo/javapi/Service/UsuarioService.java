package cl.hiperactivo.javapi.Service;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Model.DTO.UsuarioDTO;

import java.util.ArrayList;

public interface UsuarioService {

    ArrayList<UsuarioDTO> obtener();

    UsuarioDTO obtenerConID(UsuarioDTO usuarioDTO);

    boolean guardar(UsuarioDTO usuarioDTO);

    boolean editar(UsuarioDTO usuarioDTO);

    boolean eliminar(UsuarioDTO usuarioDTO);
}
