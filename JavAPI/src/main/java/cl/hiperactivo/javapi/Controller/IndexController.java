package cl.hiperactivo.javapi.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/")
public class IndexController {

    private static final Logger logger = LogManager.getLogger(IndexController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>saludar() {

        logger.info("IndexController: GET saludar();");
        /*
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
        */
        Map <String, Object> result = new HashMap<>();
        result.put("result",true);
        result.put("mensajes","Bienvenido a la API de Prueba JavAPI");
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
    }

    /*
    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>obtener() {

        //logger.info("IndexController: GET obtener();");

        Map <String, Object> result = new HashMap<>();
        result.put("result",true);
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/postear", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>postear() {

        //logger.info("IndexController: POST postear();");

        Map <String, Object> result = new HashMap<>();
        result.put("result",true);
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/actualizar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>> actualizar(@RequestParam(value="idusuario",required=true) Integer idUsuario,
                                                         HttpSession session) {

        //logger.info("IndexController: PUT actualizar();");
        System.out.println(idUsuario);

        Map<String, Object> result = new HashMap<>();
        if (idUsuario != null) {

            result.put("result", true);
            result.put("mensajes", "Enviaste todos los parámetros =)");

        } else {
            result.put("result", false);
            result.put("errores", "Faltó enviar el idUsuario");
        }
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>eliminar() {

        //logger.info("IndexController: DELETE eliminar();");

        Map <String, Object> result = new HashMap<>();
        result.put("result",true);
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);

    }
    */

}
