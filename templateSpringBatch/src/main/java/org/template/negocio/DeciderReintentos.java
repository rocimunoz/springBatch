/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.negocio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rmpinedo
 */
public class DeciderReintentos implements JobExecutionDecider {

    private int reintentos;

    protected Log log = LogFactory.getLog(DeciderReintentos.class);

    public FlowExecutionStatus decide(JobExecution je, StepExecution se) {

        if (reintentos <= 3) {

            reintentos = reintentos + 1;
            return new FlowExecutionStatus("DECISOR_REINTENTOS");

        } else if (reintentos == 3) {
            return new FlowExecutionStatus("DECISOR_FIN");

        } else {
            return new FlowExecutionStatus("DECISOR_FIN");
        }

    }

}
