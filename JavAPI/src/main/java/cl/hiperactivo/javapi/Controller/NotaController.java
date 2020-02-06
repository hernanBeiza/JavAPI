package cl.hiperactivo.javapi.Controller;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Service.NotaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/nota")
public class NotaController {

    private static final Logger logger = LogManager.getLogger(NotaController.class);

    @Autowired
    private NotaService notaService;

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>obtener() {
        logger.info("GET obtener();");
        Map <String, Object> result = new HashMap<>();
        ArrayList<NotaDTO> notas = this.notaService.obtener();
        if(notas!=null){
            result.put("result",true);
            result.put("notas",notas);
            result.put("mensajes","Se encontraron las notas");
        } else {
            result.put("result",false);
            result.put("notas",null);
            result.put("errores","No se encontraron notas");
        }
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idNota}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>obtenerConID(@PathVariable Integer idNota) {

        logger.info("GET obtenerConID();");
        boolean enviar = true;
        String errores = "Te faltó enviar:\n";
        if(idNota==null){
            errores+="el id de la nota";
            enviar = false;
        }
        Map <String, Object> result = new HashMap<>();
        if(enviar){
            NotaDTO dto = new NotaDTO();
            dto.setIdNota(idNota);
            NotaDTO notaEncontrada = this.notaService.obtenerConID(dto);
            if(notaEncontrada!=null){
                result.put("result",true);
                result.put("nota",notaEncontrada);
                result.put("mensajes","Se encontró nota con ese id");
            } else {
                result.put("result",false);
                result.put("nota",null);
                result.put("errores","No se encontró nota con ese id");
            }
        } else {
            result.put("result",false);
            result.put("errores",errores);
        }
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/{idUsuario}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>obtenerConIDUsuario(@PathVariable Integer idUsuario) {
        logger.info("GET obtenerConIDUsuario();");
        boolean enviar = true;
        String errores = "Te faltó enviar:\n";
        if(idUsuario==null){
            errores+="el id del usuario";
            enviar = false;
        }
        Map <String, Object> result = new HashMap<>();
        if(enviar){
            NotaDTO dto = new NotaDTO();
            dto.setIdUsuario(idUsuario);
            ArrayList<NotaDTO> notas = this.notaService.obtenerConIDUsuario(dto);
            if(notas!=null){
                result.put("result",true);
                result.put("notas",notas);
                result.put("mensajes","Se encontraron notas con ese usuario");
            } else {
                result.put("result",false);
                result.put("notas",null);
                result.put("errores","No se encontraron notas de ese usuario");
            }
        } else {
            result.put("result",false);
            result.put("errores",errores);
        }
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = {"","/"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>guardar(@RequestParam(value="idUsuario", required = false) Integer idUsuario,
                                                     @RequestParam(value="titulo", required = false) String titulo,
                                                     @RequestParam(value="cuerpo", required = false) String cuerpo) {

        logger.info("POST guardar();");
        boolean enviar = true;
        String errores = "Te faltó enviar:\n";
        if(idUsuario==null){
            errores+="Id del usuario";
            enviar = false;
        }

        if(titulo==null){
            errores+="Título de la nota";
            enviar = false;
        }
        if(cuerpo==null){
            errores+="Cuerpo de la nota";
            enviar = false;
        }

        Map <String, Object> result = new HashMap<>();
        if(enviar){
            NotaDTO notaDTO = new NotaDTO();
            notaDTO.setIdUsuario(idUsuario);
            notaDTO.setTitulo(titulo);
            notaDTO.setCuerpo(cuerpo);
            notaDTO.setValid(1);

            NotaDTO nuevaNotaDTO = this.notaService.guardar(notaDTO);
            if(nuevaNotaDTO!=null){
                result.put("result",true);
                result.put("mensajes","Nota guardada con éxito");
                result.put("nota",nuevaNotaDTO);
            } else {
                result.put("result",false);
                result.put("errores","La nota no se pudo guardar");
                result.put("nota",null);
            }
        } else {
            result.put("result",false);
            result.put("errores",errores);
        }
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idNota}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>> editar(@PathVariable Integer idNota,
                                                     @RequestParam(value="idUsuario", required = false) Integer idUsuario,
                                                     @RequestParam(value="titulo", required = false) String titulo,
                                                     @RequestParam(value="cuerpo", required = false) String cuerpo,
                                                     @RequestParam(value="valid", required = false) Integer valid) {
        logger.info("PUT editar();");

        boolean enviar = true;
        String errores = "Te faltó enviar:\n";
        if (idNota == null) {
            errores+="ID de la nota";
            enviar = false;
        }
        if (idUsuario == null) {
            errores+="ID del usuario";
            enviar = false;
        }
        if(titulo==null){
            errores+="Título de la nota";
            enviar = false;
        }
        if(cuerpo==null){
            errores+="Cuerpo de la nota";
            enviar = false;
        }
        if(valid==null){
            errores+="Valid de la nota";
            enviar = false;
        }
        Map<String, Object> result = new HashMap<>();
        if(enviar){
            NotaDTO notaDTO = new NotaDTO();
            notaDTO.setIdUsuario(idUsuario);
            notaDTO.setIdNota(idNota);
            notaDTO.setTitulo(titulo);
            notaDTO.setCuerpo(cuerpo);
            notaDTO.setValid(valid);

            NotaDTO nuevaNotaDTO = this.notaService.editar(notaDTO);
            if(nuevaNotaDTO!=null){
                result.put("result",true);
                result.put("mensajes","Nota editada con éxito");
                result.put("nota",nuevaNotaDTO);
            } else {
                result.put("result",false);
                result.put("errores","La nota no se pudo guardar");
                result.put("nota",null);
            }
        } else {
            result.put("result", false);
            result.put("errores", errores);
        }
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/{idNota}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>eliminar(@PathVariable Integer idNota) {

        logger.info("DELETE eliminar();");
        boolean enviar = true;
        String errores = "Te faltó enviar:\n";
        if (idNota == null) {
            errores+="ID de la nota";
            enviar = false;
        }
        Map <String, Object> result = new HashMap<>();
        if(enviar){
            NotaDTO notaDTO = new NotaDTO();
            notaDTO.setIdNota(idNota);
            if(this.notaService.eliminar(notaDTO)){
                result.put("result",true);
                result.put("mensajes","Nota eliminada con éxito");
            } else {
                result.put("result",false);
                result.put("errores","La nota no se pudo eliminar");
            }
        } else {
            result.put("result",false);
            result.put("errores",errores);
        }
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);

    }

}
