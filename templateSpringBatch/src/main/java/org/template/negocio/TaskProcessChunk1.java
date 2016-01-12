/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.negocio;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;

/**
 *
 * @author
 */
public class TaskProcessChunk1 implements ItemProcessor<Map, Map> {

    private static Logger log = Logger.getLogger(TaskReaderChunk1.class);

    private ExecutionContext executionContext;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {

        executionContext = stepExecution.getJobExecution().getExecutionContext();
    }

    @Override
    public Map process(Map mapBalances) throws Exception {

        return tratamientoProcess(mapBalances);
    }

    private Map tratamientoProcess(Map map) throws Exception {

        log.warn("******* Comienza el Processs : ");
        HashMap res = new HashMap();
        Integer iDato = (Integer) map.get("datoProcess");

        try {

            if (esPar(iDato)) {
                res.put("datoWriter", iDato * 100);

            } else {
                res.put("datoWriter", iDato);
            }

        } catch (Exception e) {
            java.util.logging.Logger.getLogger(TaskProcessChunk1.class.getName()).log(Level.SEVERE, null, e);
            String mensaje = e.getMessage() != null ? e.getMessage() : e.toString();
            log.error("Fallo al procesar  ");

        }
        return res;

    }

    private Boolean esPar(Integer x) {
        if (x != null) {
            if (x / 2 == 0) {
                return true;
            } else {
                return false;
            }
        }
        return null;
    }

}
