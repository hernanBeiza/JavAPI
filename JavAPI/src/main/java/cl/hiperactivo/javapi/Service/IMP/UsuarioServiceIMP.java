package cl.hiperactivo.javapi.Service.IMP;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Model.DTO.UsuarioDTO;
import cl.hiperactivo.javapi.Model.Entity.NotaEntity;
import cl.hiperactivo.javapi.Model.Entity.UsuarioEntity;
import cl.hiperactivo.javapi.Persistence.DAO.NotaDAO;
import cl.hiperactivo.javapi.Persistence.DAO.UsuarioDAO;
import cl.hiperactivo.javapi.Service.NotaService;
import cl.hiperactivo.javapi.Service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Service
public class UsuarioServiceIMP implements UsuarioService {

    private static final Logger logger = LogManager.getLogger(UsuarioServiceIMP.class);

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public ArrayList<UsuarioDTO> obtener() {
        logger.info("obtener();");
        ArrayList<UsuarioEntity> entities = this.usuarioDAO.obtener();
        if(entities!=null){
            if(entities.size()>0){
                logger.info("Notas encontradas");
                logger.info(entities);
                ArrayList<UsuarioDTO> encontrados = new ArrayList<UsuarioDTO>();
                for (UsuarioEntity entity : entities) {
                    UsuarioDTO dto = new UsuarioDTO(entity);
                    encontrados.add(dto);
                }
                return encontrados;
            } else {
                return null;
            }
        } else {
            logger.error("No se encontraron notas");
            return null;
        }
    }

    @Override
    public UsuarioDTO obtenerConID(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = this.usuarioDAO.obtenerConID(usuarioDTO);
        if(usuarioEntity!=null){
            UsuarioDTO usuario = new UsuarioDTO(usuarioEntity);
            return usuario;
        } else {
            return null;
        }
    }

    @Override
    public boolean guardar(UsuarioDTO usuarioDTO) {
        return this.usuarioDAO.guardar(usuarioDTO);
    }

    @Override
    public boolean editar(UsuarioDTO usuarioDTO) {
        return this.usuarioDAO.editar(usuarioDTO);
    }

    @Override
    public boolean eliminar(UsuarioDTO usuarioDTO) {
        return this.usuarioDAO.eliminar(usuarioDTO);
    }

}
