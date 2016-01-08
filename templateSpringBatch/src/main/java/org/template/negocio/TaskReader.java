/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.negocio;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;



//@Service
public class TaskReader implements ItemReader<Map> {

    private static Logger log = Logger.getLogger(TaskReader.class);

  

   

    public void initServicioReader() {

    }

    //private TransactionTemplate transactionTemplate;
    @Override
    public synchronized  Map read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Map res = fromLocalQueue();
        return res;
    }

    
    public Map fromLocalQueue() {

        log.warn("******* Comienza el Reader : ");

        HashMap res = null;
     

        try {
            
       
           

        } catch (Exception ex) {
            log.warn("" + ex);
        }
        return res;
    }

   

}
