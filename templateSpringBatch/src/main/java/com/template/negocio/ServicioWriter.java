/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.template.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.template.dao.impl.CentaxDaoImpl;
import com.template.dto.Config_Agregacion_Hippeis;

/**
 *
 * @author
 */
public class ServicioWriter implements ItemWriter<Config_Agregacion_Hippeis> {

    private static Logger log = Logger.getLogger(ServicioWriter.class);

    @Autowired
    private CentaxDaoImpl centaxDao;

    /**
     * Variable contador de lineas del fichero. Tiene scope singleton
     */
    private Integer contadorPuntosTraspasados;

    /**
     * Se vuelca el contenido del reader a BBDD
     *
     * @param list Se recibe una lista de Objetos. Se envian al Dao para insertar en BBDD
     * @throws Exception
     */
    public void write(List<? extends Config_Agregacion_Hippeis> list) throws Exception {

        try {

            if (contadorPuntosTraspasados == null) {
                contadorPuntosTraspasados = 0;
            }
            contadorPuntosTraspasados = contadorPuntosTraspasados + list.size();

            List<Config_Agregacion_Hippeis> listaHippeis = new ArrayList<Config_Agregacion_Hippeis>();

            log.info("Insertados " + list.size() + " registros de " + contadorPuntosTraspasados);

            if (list != null && !list.isEmpty()) {

                for (Config_Agregacion_Hippeis hippeis : list) {

                    listaHippeis.add(hippeis);

                }

                //Se realiza una insercion de una lista por temas de rendimiento
                insertarLista(listaHippeis);
            }

            //Se limpia el objeto para la siguiente ejecucion. Tiene scope singleton
            listaHippeis.clear();
        } catch (Exception e) {
            log.error("Se ha producido un error insertando");
        }

    }

    /**
     * Insercion de un objeto Config_Agregacion_Hippeis
     *
     * @param hippeis
     */
    private void insertarObjeto(Config_Agregacion_Hippeis hippeis) {

        try {
            centaxDao.insertarBeanHippeis(hippeis);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServicioWriter.class.getName()).log(Level.SEVERE, null, ex);
            log.error("Se ha producido un error al insertar" + ex.getMessage());
        }

    }

    /**
     * Funcion que inserta una lista de objetos Config_Agregacion_Hippeis en BBDD
     *
     * @param lista
     */
    private void insertarLista(List<Config_Agregacion_Hippeis> lista) {

        try {
            HashMap hm = new HashMap();
            hm.put("listaHippeis", lista);
            centaxDao.insertarListaHippeis(hm);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServicioWriter.class.getName()).log(Level.SEVERE, null, ex);
            log.error("Se ha producido un error al insertar" + ex.getMessage());
        }

    }

}
