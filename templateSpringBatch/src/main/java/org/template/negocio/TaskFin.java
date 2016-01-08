package org.template.negocio;


import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


/**
 * Un tasklet es una clase que realiza una acción simple. Permite asi ejecutar
 * y realizar cualquier acción que necesitemos. 
 * Spring Batch provee clases más complejas y potentes que los tasklets, pero
 * son igualmente útiles para realizar algunas acciones.
 */
public class TaskFin implements Tasklet {

    static Logger log = Logger.getLogger(TaskFin.class);
    
 
    
   
   
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

        log.info("Task Fin");
        return RepeatStatus.FINISHED;
    }   

}
