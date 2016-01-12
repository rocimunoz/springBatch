/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.negocio;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.template.dto.BeanExample;

/**
 *
 * @author
 */
public class TaskWriterChunk2 implements ItemWriter<BeanExample> {

    private static Logger log = Logger.getLogger(TaskWriterChunk2.class);

   

   

    @Override
    public void write(List<? extends BeanExample> list) throws Exception {
        log.warn("******* Comienza Writer : ");

        try {

            for (BeanExample bean : list) {
                
                log.info("Nombre: " + bean.getNombre());
                log.info("Apellido: " + bean.getApellido());
                log.info("Dni: " + bean.getDni());
                log.info("Edad: " + bean.getEdad());
                
            }
            

        } catch (Exception e) {
            log.error("**************************************");
            log.error("** Detectado error " + e);
            log.error("**************************************");
            throw e;
        }
    }

    
   
}
