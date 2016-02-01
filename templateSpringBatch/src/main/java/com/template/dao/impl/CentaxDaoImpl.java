/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.template.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;
import com.template.dao.ICentaxDao;
import com.template.dto.Config_Agregacion_Hippeis;

/**
 *
 * @author rmpinedo
 */
@Service("ICentaxDao")
public class CentaxDaoImpl extends SqlMapClientDaoSupport implements ICentaxDao {

    @Autowired
    public CentaxDaoImpl(@Qualifier("sqlMapClient") SqlMapClient s) {
        setSqlMapClient(s);
    }

    public void insertarBeanHippeis(Config_Agregacion_Hippeis config) throws Exception {
        SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();
        sqlMapClientTemplate.insert("insert-Hippeis", config);

    }

    public int deleteBBDD() throws Exception {

        int count = 0;
        SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();
        count = sqlMapClientTemplate.delete("delete-Hippeis");
        
        return count;
    }

    public void insertarListaHippeis(HashMap hm) throws Exception {
        SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();

        sqlMapClientTemplate.insert("insert-ListHippeis", hm);
    }
}
