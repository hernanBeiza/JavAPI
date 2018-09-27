package cl.hiperactivo.javapi.Controller;

import cl.hiperactivo.javapi.Model.DTO.NotaDTO;
import cl.hiperactivo.javapi.Model.DTO.UsuarioDTO;
import cl.hiperactivo.javapi.Service.NotaService;
import cl.hiperactivo.javapi.Service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private static final Logger logger = LogManager.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>obtener() {
        logger.info("GET obtener();");
        Map <String, Object> result = new HashMap<>();
        ArrayList<UsuarioDTO> usuarios = this.usuarioService.obtener();
        if(usuarios!=null){
            result.put("result",true);
            result.put("usuarios",usuarios);
            result.put("mensajes","Se encontraron los usuarios");
        } else {
            result.put("result",false);
            result.put("notas",null);
            result.put("errores","No se encontraron usuarios");
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
            UsuarioDTO dto = new UsuarioDTO();
            dto.setIdUsuario(idNota);
            UsuarioDTO usuarioEncontrado = this.usuarioService.obtenerConID(dto);
            if(usuarioEncontrado!=null){
                result.put("result",true);
                result.put("usuario",usuarioEncontrado);
                result.put("mensajes","Se encontró usuario con ese id");
            } else {
                result.put("result",false);
                result.put("usuario",null);
                result.put("errores","No se encontró usuario con ese id");
            }
        } else {
            result.put("result",false);
            result.put("errores",errores);
        }
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = {"","/"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>guardar(@RequestParam(value="titulo", required = false) String titulo,
                                                     @RequestParam(value="cuerpo", required = false) String cuerpo) {

        logger.info("POST guardar();");
        boolean enviar = true;
        String errores = "Te faltó enviar:\n";
        if(titulo==null){
            errores+="Nombre";
            enviar = false;
        }

        Map <String, Object> result = new HashMap<>();
        if(enviar){
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombre(titulo);
            usuarioDTO.setValid(1);
            if(this.usuarioService.guardar(usuarioDTO)){
                result.put("result",true);
                result.put("mensajes","Usuario guardado con éxito");
            } else {
                result.put("result",false);
                result.put("errores","El usuario no se pudo guardar");
            }
        } else {
            result.put("result",false);
            result.put("errores",errores);
        }
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>> editar(@PathVariable Integer idUsuario,
                                                     @RequestParam(value="titulo", required = false) String nombre,
                                                     @RequestParam(value="valid", required = false) Integer valid) {
        logger.info("PUT editar();");

        boolean enviar = true;
        String errores = "Te faltó enviar:\n";
        if (idUsuario == null) {
            errores+="ID del usuario";
            enviar = false;
        }
        if(nombre==null){
            errores+="Nombre";
            enviar = false;
        }
        if(valid==null){
            errores+="Valid";
            enviar = false;
        }
        Map<String, Object> result = new HashMap<>();
        if(enviar){
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdUsuario(idUsuario);
            usuarioDTO.setNombre(nombre);
            usuarioDTO.setValid(valid);
            if(this.usuarioService.editar(usuarioDTO)){
                result.put("result",true);
                result.put("mensajes","Usuario editada con éxito");
            } else {
                result.put("result",false);
                result.put("errores","El usuario no se pudo editar");
            }
        } else {
            result.put("result", false);
            result.put("errores", errores);
        }
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>eliminar(@PathVariable Integer idUsuario) {

        logger.info("DELETE eliminar();");
        boolean enviar = true;
        String errores = "Te faltó enviar:\n";
        if (idUsuario == null) {
            errores+="ID delusuarioa";
            enviar = false;
        }
        Map <String, Object> result = new HashMap<>();
        if(enviar){
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdUsuario(idUsuario);
            if(this.usuarioService.eliminar(usuarioDTO)){
                result.put("result",true);
                result.put("mensajes","Usuario eliminado con éxito");
            } else {
                result.put("result",false);
                result.put("errores","El usuario no se pudo eliminar");
            }
        } else {
            result.put("result",false);
            result.put("errores",errores);
        }
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);

    }

}