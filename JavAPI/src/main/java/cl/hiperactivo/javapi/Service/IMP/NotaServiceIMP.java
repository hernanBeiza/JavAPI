package cl.hiperactivo.javapi.Service.IMP;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Model.Entity.NotaEntity;
import cl.hiperactivo.javapi.Persistence.DAO.NotaDAO;
import cl.hiperactivo.javapi.Service.NotaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Service
public class NotaServiceIMP implements NotaService {

    private static final Logger logger = LogManager.getLogger(NotaServiceIMP.class);

    @Autowired
    private NotaDAO notaDAO;

    @Override
    public ArrayList<NotaDTO> obtener() {
        logger.info("obtener();");
        ArrayList<NotaEntity> entities = this.notaDAO.obtener();
        if(entities!=null){
            if(entities.size()>0){
                logger.info("Notas encontradas");
                logger.info(entities);
                ArrayList<NotaDTO> encontrados = new ArrayList<NotaDTO>();
                for (NotaEntity entity : entities) {
                    NotaDTO dto = new NotaDTO(entity);
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
    public NotaDTO obtenerConID(NotaDTO notaDTO) {
        NotaEntity notaEntity = this.notaDAO.obtenerConID(notaDTO);
        if(notaEntity!=null){
            NotaDTO nota = new NotaDTO(notaEntity);
            return nota;
        } else {
            return null;
        }
    }

    @Override
    public  ArrayList<NotaDTO> obtenerConIDUsuario(NotaDTO notaDTO) {
        ArrayList<NotaEntity> entities = this.notaDAO.obtenerConIDUsuario(notaDTO);
        if(entities!=null){
            if(entities.size()>0){
                logger.info("Notas encontradas");
                logger.info(entities);
                ArrayList<NotaDTO> encontrados = new ArrayList<NotaDTO>();
                for (NotaEntity entity : entities) {
                    NotaDTO dto = new NotaDTO(entity);
                    encontrados.add(dto);
                }
                return encontrados;
            } else {
                return null;
            }
        } else {
            logger.error("No se encontraron notas");
            return null;
        }    }

    @Override
    public NotaDTO guardar(NotaDTO notaDTO) {
        NotaEntity notaEntity = this.notaDAO.guardar(notaDTO);
        NotaDTO nuevaNotaDTO = new NotaDTO(notaEntity);
        return nuevaNotaDTO;
    }

    @Override
    public NotaDTO editar(NotaDTO notaDTO) {
        NotaEntity notaEntity = this.notaDAO.editar(notaDTO);
        System.out.println(notaEntity);
        if(notaEntity!=null){
            NotaDTO nuevaNotaDTO = new NotaDTO(notaEntity);
            return nuevaNotaDTO;
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminar(NotaDTO notaDTO) {
        return this.notaDAO.eliminar(notaDTO);
    }

}
