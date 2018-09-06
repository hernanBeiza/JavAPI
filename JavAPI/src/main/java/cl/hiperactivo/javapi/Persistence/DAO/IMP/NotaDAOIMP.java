package cl.hiperactivo.javapi.Persistence.DAO.IMP;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Model.Entity.NotaEntity;
import cl.hiperactivo.javapi.Persistence.DAO.NotaDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Repository("NotaDAO")
public class NotaDAOIMP implements NotaDAO {

    private static final Logger logger = LogManager.getLogger(NotaDAOIMP.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ArrayList<NotaEntity> obtener() {
        String query = "SELECT n FROM NotaEntity AS n";
        logger.info(query);
        try {
            //Object result = entityManager.createQuery(query).getSingleResult();
            //System.out.println(result.toString());
            return (ArrayList<NotaEntity>) entityManager.createQuery(query).getResultList();
        } catch (Exception e){
            logger.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public NotaEntity obtenerConID(NotaDTO notaDTO) {
        String query = "SELECT r FROM NotaEntity AS r WHERE r.idNota = "+notaDTO.getIdNota();
        logger.info(query);
        try {
            //Object result = entityManager.createQuery(query).getSingleResult();
            //System.out.println(result.toString());
            //return (NotaEntity) entityManager.find(NotaEntity.class,notaDTO.getIdNota());
            return (NotaEntity) entityManager.createQuery(query).getSingleResult();
        } catch (Exception e){
            logger.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean guardar(NotaDTO notaDTO) {
        return false;
    }

    @Override
    public boolean editar(NotaDTO notaDTO) {
        return false;
    }

    @Override
    public boolean eliminar(NotaDTO notaDTO) {
        return false;
    }

}
