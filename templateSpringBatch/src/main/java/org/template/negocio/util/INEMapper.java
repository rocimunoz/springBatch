/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.negocio.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
import org.template.dto.BeanExample;

/**
 *
 * @author rmpinedo
 */
public class INEMapper implements FieldSetMapper<BeanExample> {

    private static Logger log = Logger.getLogger(INEMapper.class);

    /**
     * Funcion para convertir cada linea en un objeto de tipo BeanExample
     *
     * @param fs contiene los campos de una linea
     * @return Devuelve el objeto
     * @throws BindException
     */
   

    @Override
    public BeanExample mapFieldSet(FieldSet fs) throws BindException {
        BeanExample beanDatos = new BeanExample();

        try {

            if (fs.getFieldCount() == 4) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                DecimalFormat formatter = new DecimalFormat("#0.000");

                if (fs != null) {

                    if (fs.readString("NOMBRE") != null && !fs.readString("NOMBRE").equals("")) {
                        beanDatos.setNombre(fs.readString("NOMBRE"));

                    } else {
                        beanDatos.setNombre(null);
                    }

                    if (fs.readString("APELLIDO") != null && !fs.readString("APELLIDO").equals("")) {
                        beanDatos.setApellido(fs.readString("APELLIDO"));

                    } else {
                        beanDatos.setApellido(null);
                    }
                    
                    if (fs.readString("DNI") != null && !fs.readString("DNI").equals("")) {
                        beanDatos.setDni(Long.parseLong(fs.readString("DNI")));
                    } else {
                        beanDatos.setDni(null);
                    }
                    
                    if (fs.readString("EDAD") != null && !fs.readString("EDAD").equals("")) {
                        beanDatos.setEdad(Integer.parseInt(fs.readString("EDAD")));
                    } else {
                        beanDatos.setEdad(null);
                    }

                }

            } else {
                log.warn("No se ha insertado la linea por tener " + fs.getFieldCount() + " campos");
            }

        } catch (Exception e) {
            log.error("Error en el mapeo de la linea ");
        }

        return beanDatos;
    }

   

}
