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
public class TaskProcess implements ItemProcessor<Map, Map> {

    private static Logger log = Logger.getLogger(TaskReader.class);

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

        //
        try {

            if (res == null) {
                res = new HashMap();
            }

        } catch (Exception e) {
            java.util.logging.Logger.getLogger(TaskProcess.class.getName()).log(Level.SEVERE, null, e);
            String mensaje = e.getMessage() != null ? e.getMessage() : e.toString();
            log.error("Fallo al procesar  ");

        }
        return res;

    }

}
