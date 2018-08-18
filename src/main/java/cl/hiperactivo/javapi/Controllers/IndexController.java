package cl.hiperactivo.javapi.Controllers;

import cl.hiperactivo.javapi.JavApiApplication;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")

public class IndexController {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(JavApiApplication.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String,Object>>saludar() {

        logger.info("IndexController: saludar();");

        Map <String, Object> result = new HashMap<>();
        result.put("result",true);
        result.put("mensajes","Bienvenido a la API de Prueba JavAPI");
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);

    }

}
