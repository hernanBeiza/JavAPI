package cl.hiperactivo.javapi;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class JavApiApplication extends SpringBootServletInitializer {

    private static final Logger logger = LogManager.getLogger(JavApiApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(JavApiApplication.class, args);

        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");

        System.out.println("Hola");

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

    }

}
