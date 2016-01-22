/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.negocio.util;

import java.util.Map;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.JsonLineMapper;
import org.template.dto.BeanINE;

/**
 *
 * @author rmpinedo
 */
public class BeanJsonLineMapper implements LineMapper<BeanINE> {

    private JsonLineMapper delegate;

    @Override
    public BeanINE mapLine(String line, int lineNumber) throws Exception {

        Map<String, Object> beanINEasMap = delegate.mapLine(line, lineNumber);

        BeanINE bean = new BeanINE();
                //product.setId((String)beanINEasMap.get("id"));
        //product.setName((String)productAsMap.get("name"));
        //product.setDescription((String)productAsMap.get("description"));
        //product.setPrice(new Float((Double)productAsMap.get("price")));

        return bean;

    }

    public void setDelegate(JsonLineMapper delegate) {
        this.delegate = delegate;
    }

}
