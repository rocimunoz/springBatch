/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.template.dao;

import java.util.HashMap;
import com.template.dto.Config_Agregacion_Hippeis;

/**
 *
 * @author rmpinedo
 */
public interface ICentaxDao {

    /**
     * Funcion para insertar un objeto en Config_Agregacion_Hippeis
     *
     * @param hip Objeto con los datos de Hippeis
     * @throws Exception
     */
    public void insertarBeanHippeis(Config_Agregacion_Hippeis hip) throws Exception;

    /**
     * Funcion para insertar una lista de objetos en Config_Agregacion_Hippeis
     *
     * @param hm. HashMap con la lista de objetos
     * @throws Exception
     */
    public void insertarListaHippeis(HashMap hm) throws Exception;

    /**
     * Funcion para borrar la tabla Config_Agregacion_Hippeis al inicio del proceso
     *
     * @return numero de registros borrados
     * @throws Exception
     */
    public int deleteBBDD() throws Exception;

}
