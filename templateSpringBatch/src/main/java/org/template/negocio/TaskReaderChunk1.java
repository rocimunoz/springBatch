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
public class TaskReaderChunk1 implements ItemReader<Map> {

    private static Logger log = Logger.getLogger(TaskReaderChunk1.class);

    @Autowired
    @Qualifier("listaEnteros")
    private ConcurrentLinkedQueue<Integer> listaEnteros;

    public void initServicioReader() {

    }

    @Override
    public synchronized Map read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Map res = fromLocalQueue();
        return res;
    }

    public Map fromLocalQueue() {

        log.warn("******* Comienza el Reader : ");

        HashMap res = null;

        try {

            listaEnteros.size();
            if (!listaEnteros.isEmpty()) {

                try {
                   
                    log.info("******* registro " + listaEnteros.size() + " : ");
                    Integer element = listaEnteros.element();
                    if (res== null){
                        res = new HashMap();
                    }
                    res.put("datoProcess", element);
                    listaEnteros.poll();

                } catch (Exception ex) {
                    log.warn("" + ex);
                }
            }

        } catch (Exception e) {

        }
        return res;
    }

}
