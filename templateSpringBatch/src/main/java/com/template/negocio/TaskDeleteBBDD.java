/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.template.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.template.dao.impl.CentaxDaoImpl;
import com.template.util.Ftp;
import com.template.util.ZipUtil;

/**
 *
 * @author rmpinedo
 */
/**
 * Step que realiza el borrado de la tabla Centax.Config_Agregacion_Hippeis
 *
 * @author rmpinedo
 */
public class TaskDeleteBBDD implements Tasklet {

    static Logger log = Logger.getLogger(TaskDeleteBBDD.class);

    @Autowired
    private CentaxDaoImpl centaxDao;

    @Override
    public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {

        log.info("================== INICIO BORRADO BBDD  ================== ");

        try {

            centaxDao.deleteBBDD();
            
        } catch (Exception e) {
            log.error("Error borrando la tabla ");
        }

        log.info("================== FIN BORRADO BBDD   ================== \n");

        return RepeatStatus.FINISHED;

    }
}
