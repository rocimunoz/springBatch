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

/**
 *
 * @author
 */
public class TaskWriter implements ItemWriter<Map> {

    private static Logger log = Logger.getLogger(TaskReader.class);

   

    @Override
    public void write(List<? extends Map> resultado) throws Exception {

        log.warn("******* Comienza Writer : ");

        try {

            

        } catch (Exception e) {
            log.error("**************************************");
            log.error("** Detectado error " + e);
            log.error("**************************************");
            throw e;
        }
    }

    
   
}
