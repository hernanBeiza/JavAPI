package cl.hiperactivo.javapi.Persistence.DAO.IMP;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Model.DTO.UsuarioDTO;
import cl.hiperactivo.javapi.Model.Entity.NotaEntity;
import cl.hiperactivo.javapi.Model.Entity.UsuarioEntity;
import cl.hiperactivo.javapi.Persistence.DAO.NotaDAO;
import cl.hiperactivo.javapi.Persistence.DAO.UsuarioDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Repository("UsuarioDAO")
public class UsuarioDAOIMP implements UsuarioDAO {

    private static final Logger logger = LogManager.getLogger(UsuarioDAOIMP.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ArrayList<UsuarioEntity> obtener() {
        String query = "SELECT n FROM UsuarioEntity AS n";
        logger.info(query);
        try {
            //Object result = entityManager.createQuery(query).getSingleResult();
            //System.out.println(result.toString());
            return (ArrayList<UsuarioEntity>) entityManager.createQuery(query).getResultList();
        } catch (Exception e){
            logger.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public UsuarioEntity obtenerConID(UsuarioDTO usuarioDTO) {
        String query = "SELECT r FROM UsuarioEntity AS r WHERE r.idUsuario = "+usuarioDTO.getIdUsuario();
        logger.info(query);
        try {
            //Object result = entityManager.createQuery(query).getSingleResult();
            //System.out.println(result.toString());
            return (UsuarioEntity) entityManager.createQuery(query).getSingleResult();
        } catch (Exception e){
            logger.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean guardar(UsuarioDTO usuarioDTO) {
        logger.info("guardar();");
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre(usuarioDTO.getNombre());
        usuarioEntity.setUsuario(usuarioDTO.getUsuario());
        usuarioEntity.setContrasena(usuarioDTO.getContrasena());
        usuarioEntity.setValid(usuarioDTO.getValid());
        try {
            this.entityManager.persist(usuarioEntity);
            return true;
        } catch(Exception e){
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean editar(UsuarioDTO usuarioDTO) {
        logger.info("editar();");
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdUsuario(usuarioDTO.getIdUsuario());
        usuarioEntity.setNombre(usuarioDTO.getNombre());
        usuarioEntity.setUsuario(usuarioDTO.getUsuario());
        usuarioEntity.setContrasena(usuarioDTO.getContrasena());
        usuarioEntity.setValid(usuarioDTO.getValid());
        try {
            this.entityManager.merge(usuarioEntity);
            return true;
        } catch(Exception e){
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(UsuarioDTO usuarioDTO) {
        logger.info("eliminar();");
        UsuarioEntity usuarioEntity = this.obtenerConID(usuarioDTO);
        if(usuarioEntity!=null){
            try {
                this.entityManager.remove(usuarioEntity);
                return true;
            } catch (Exception e){
                logger.error(e.getLocalizedMessage());
                return false;
            }
        } else {
            return false;
        }
    }

}
