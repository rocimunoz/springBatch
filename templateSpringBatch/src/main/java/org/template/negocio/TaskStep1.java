/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.negocio;

import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author rmpinedo
 */
public class TaskStep1 implements Tasklet {

    static Logger log = Logger.getLogger(TaskStep1.class);

    @Autowired
    @Qualifier("listaEnteros")
    private ConcurrentLinkedQueue<Integer> listaEnteros;

    @Override
    public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {

        log.info("================== INICIO TAREA STEP 1   ================== ");

        try {

            log.info("Inicializo lista de enteros");
            for (int i = 0; i < 10; i++) {
                listaEnteros.add(i);
            }
            
            

        } catch (Exception e) {
            log.error("El fichero  no se ha podido descargar." + e.getCause().toString());
            throw e;

        } finally {

        }

        log.info("================== FIN TAREA STEP 1   ================== \n");

        return RepeatStatus.FINISHED;

    }
}
