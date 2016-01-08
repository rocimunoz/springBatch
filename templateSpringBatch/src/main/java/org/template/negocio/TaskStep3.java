/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;


/**
 *
 * @author rmpinedo
 */
public class TaskStep3 implements Tasklet {

    static Logger log = Logger.getLogger(TaskStep3.class);

   

   

    @Override
    public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {

        log.info("================== INICIO TAREA STEP 3   ================== ");
        
        try {

        log.info("Soy el step 3");

        } catch (Exception e) {
            log.error("El fichero  no se ha podido descargar." +  e.getCause().toString());
            throw e;
            
        } finally {
            //Desconecto del FTP
           

        }

        log.info("================== FIN TAREA STEP 3   ================== \n");

        return RepeatStatus.FINISHED;

    }
}
