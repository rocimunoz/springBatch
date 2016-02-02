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
import com.template.dao.impl.ApellidosDaoImpl;
import com.template.dto.Apellidos;

/**
 *
 * @author
 */
public class ServicioWriter implements ItemWriter<Apellidos> {

    private static Logger log = Logger.getLogger(ServicioWriter.class);

    @Autowired
    private ApellidosDaoImpl apellidosDao;

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
    public void write(List<? extends Apellidos> list) throws Exception {

        try {

            if (contadorPuntosTraspasados == null) {
                contadorPuntosTraspasados = 0;
            }
            contadorPuntosTraspasados = contadorPuntosTraspasados + list.size();

            List<Apellidos> listaHippeis = new ArrayList<Apellidos>();

            log.info("Insertados " + list.size() + " registros de " + contadorPuntosTraspasados);

            if (list != null && !list.isEmpty()) {

                for (Apellidos hippeis : list) {

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
     * Insercion de un objeto Apellidos
     *
     * @param hippeis
     */
    private void insertarObjeto(Apellidos hippeis) {

        try {
            apellidosDao.insertarBeanApellidos(hippeis);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServicioWriter.class.getName()).log(Level.SEVERE, null, ex);
            log.error("Se ha producido un error al insertar" + ex.getMessage());
        }

    }

    /**
     * Funcion que inserta una lista de objetos Apellidos en BBDD
     *
     * @param lista
     */
    private void insertarLista(List<Apellidos> lista) {

        try {
            HashMap hm = new HashMap();
            hm.put("listaApellidos", lista);
            apellidosDao.insertarListaApellidos(hm);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServicioWriter.class.getName()).log(Level.SEVERE, null, ex);
            log.error("Se ha producido un error al insertar" + ex.getMessage());
        }

    }

}
