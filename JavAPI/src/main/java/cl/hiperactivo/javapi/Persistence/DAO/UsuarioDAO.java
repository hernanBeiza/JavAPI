package cl.hiperactivo.javapi.Persistence.DAO;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Model.DTO.UsuarioDTO;
import cl.hiperactivo.javapi.Model.Entity.NotaEntity;
import cl.hiperactivo.javapi.Model.Entity.UsuarioEntity;

import java.util.ArrayList;

public interface UsuarioDAO {

    ArrayList<UsuarioEntity> obtener();

    UsuarioEntity obtenerConID(UsuarioDTO usuarioDTO);

    boolean guardar(UsuarioDTO usuarioDTO);

    boolean guardarTodo(UsuarioDTO usuarioDTO);

    boolean editar(UsuarioDTO usuarioDTO);

    boolean eliminar(UsuarioDTO usuarioDTO);
}
