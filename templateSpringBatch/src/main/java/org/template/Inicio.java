/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 *
 * @author rmpinedo
 */
public class Inicio {

    static Logger log = Logger.getLogger(Inicio.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml", "classpath:META-INF/applicationDataSources.xml");
            ctx.start();

            JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");

            Job job = (Job) ctx.getBean("templateSpring");

            JobParametersBuilder builder = new JobParametersBuilder();
            JobExecution jobExecution = jobLauncher.run(job, builder.toJobParameters());
            
            //Hora en que comienza el job
            jobExecution.getCreateTime();
           
            long end = System.currentTimeMillis();
            
            //Hora finalizacion del job
            jobExecution.getEndTime();
             log.info("---- Fin proceso ");
            
            //Ultima vez que se hizo un commit
            jobExecution.getLastUpdated();
            

        } catch (Exception e) {
            log.error("---- Error proceso " + e.toString());

        }

    }
}
