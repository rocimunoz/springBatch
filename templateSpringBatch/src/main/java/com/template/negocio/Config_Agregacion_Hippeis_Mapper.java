/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.template.negocio;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
import com.template.dto.Config_Agregacion_Hippeis;

/**
 *
 * @author rmpinedo
 */
public class Config_Agregacion_Hippeis_Mapper implements FieldSetMapper<Config_Agregacion_Hippeis> {
    
    private static Logger log = Logger.getLogger(Config_Agregacion_Hippeis_Mapper.class);
    
    
    
    /**
     * Funcion para convertir cada linea en un objeto de tipo Config_Agregacion_Hippeis
     * @param fs contiene los campos de una linea
     * @return Devuelve el objeto 
     * @throws BindException 
     */
    public Config_Agregacion_Hippeis mapFieldSet(FieldSet fs) throws BindException {
        
        Config_Agregacion_Hippeis hippeis = new Config_Agregacion_Hippeis();
        
        try {
            
            if (fs.getFieldCount() == 28) {
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                
                DecimalFormat formatter = new DecimalFormat("#0.000");
                
                if (fs != null) {
                    
                    if (fs.readString("ID_COND_AGRE") != null && !fs.readString("ID_COND_AGRE").equals("")) {
                        hippeis.setId_cond_agre(Long.parseLong(fs.readString("ID_COND_AGRE")));
                    } else {
                        hippeis.setId_cond_agre(null);
                    }
                    
                    if (fs.readString("GUID_AGREGA") != null && !fs.readString("GUID_AGREGA").equals("")) {
                        hippeis.setGuid_agrega(Long.parseLong(fs.readString("GUID_AGREGA")));
                    } else {
                        hippeis.setGuid_agrega(null);
                    }
                    
                    hippeis.setId_var_mv_pf(fs.readString("ID_VAR_MV_PF"));
                    
                    if (fs.readString("F_DESDE") != null && !fs.readString("F_DESDE").equals("")) {
                        hippeis.setF_desde(fs.readDate("F_DESDE", "dd/MM/yyyy"));
                    } else {
                        hippeis.setF_desde(null);
                    }
                    
                    hippeis.setF_hasta(fs.readDate("F_HASTA", "dd/MM/yyyy"));
                    
                    if (fs.readString("F_HASTA") != null && !fs.readString("F_HASTA").equals("")) {
                        hippeis.setF_hasta(fs.readDate("F_HASTA", "dd/MM/yyyy"));
                    } else {
                        hippeis.setF_hasta(null);
                    }
                    
                    if (fs.readString("ID_DISTRIBUIDORA") != null && !fs.readString("ID_DISTRIBUIDORA").equals("")) {
                        hippeis.setId_distribuidora(Long.parseLong(fs.readString("ID_DISTRIBUIDORA")));
                    } else {
                        hippeis.setId_distribuidora(null);
                    }
                    
                    if (fs.readString("ID_COMERCIALIZADORA") != null && !fs.readString("ID_COMERCIALIZADORA").equals("")) {
                        hippeis.setId_comercializadora(Long.parseLong(fs.readString("ID_COMERCIALIZADORA")));
                    } else {
                        hippeis.setId_comercializadora(null);
                    }
                    
                    hippeis.setAutoproductor(fs.readString("AUTOPRODUCTOR"));
                    
                    if (fs.readString("ID_TIPO_NTT") != null && !fs.readString("ID_TIPO_NTT").equals("")) {
                        hippeis.setId_tipo_ntt(Integer.parseInt(fs.readString("ID_TIPO_NTT")));
                    } else {
                        hippeis.setId_tipo_ntt(null);
                    }
                    
                    if (fs.readString("ID_TARIFA_ACCESO") != null && !fs.readString("ID_TARIFA_ACCESO").equals("")) {
                        hippeis.setId_tarifa_acceso(Integer.parseInt(fs.readString("ID_TARIFA_ACCESO")));
                    } else {
                        hippeis.setId_tarifa_acceso(null);
                    }
                    
                    if (fs.readString("ID_DH_ACCESO") != null && !fs.readString("ID_DH_ACCESO").equals("")) {
                        hippeis.setId_dh_acceso(Integer.parseInt(fs.readString("ID_DH_ACCESO")));
                    } else {
                        hippeis.setId_dh_acceso(null);
                    }
                    
                    if (fs.readString("ID_PROVINCIA") != null && !fs.readString("ID_PROVINCIA").equals("")) {
                        hippeis.setId_provincia(Integer.parseInt(fs.readString("ID_PROVINCIA")));
                    } else {
                        hippeis.setId_provincia(null);
                    }
                    
                    hippeis.setCups_pf(fs.readString("CUPS_PF"));
                    hippeis.setCups_pm(fs.readString("CUPS_PM"));
                    hippeis.setDescripcion_pf(fs.readString("DESCRIPCION_PF"));
                    
                    if (fs.readString("GUID_PF") != null && !fs.readString("GUID_PF").equals("")) {
                        hippeis.setGuid_pf(Long.parseLong(fs.readString("GUID_PF")));
                    } else {
                        hippeis.setGuid_pf(null);
                    }
                    
                    if (fs.readString("GUID_PM") != null && !fs.readString("GUID_PM").equals("")) {
                        hippeis.setGuid_pm(Long.parseLong(fs.readString("GUID_PM")));
                    } else {
                        hippeis.setGuid_pm(null);
                    }
                    
                    if (fs.readString("PC_P1") != null && !fs.readString("PC_P1").equals("")) {
                        try {
                            Double valor = Double.parseDouble(fs.readString("PC_P1").replace(',', '.'));
                            //Double dPcP1 = new Double(formatter.format(valor));
                            hippeis.setPc_p1(valor);
                            
                        } catch (Exception e) {
                            log.error("Error en PC_P1" + e.getMessage());
                        }
                        
                    } else {
                        hippeis.setPc_p1(null);
                    }
                    
                    if (fs.readString("PC_P2") != null && !fs.readString("PC_P2").equals("")) {
                        Double valor = Double.parseDouble(fs.readString("PC_P2").replace(',', '.'));
                        //Double dPcP1 = new Double(formatter.format(valor));
                        hippeis.setPc_p2(valor);
                    } else {
                        hippeis.setPc_p2(null);
                    }
                    
                    if (fs.readString("PC_P3") != null && !fs.readString("PC_P3").equals("")) {
                        Double valor = Double.parseDouble(fs.readString("PC_P3").replace(',', '.'));
                        //Double dPcP1 = new Double(formatter.format(valor));
                        hippeis.setPc_p3(valor);
                    } else {
                        hippeis.setPc_p3(null);
                    }
                    
                    if (fs.readString("PC_P4") != null && !fs.readString("PC_P4").equals("")) {
                        Double valor = Double.parseDouble(fs.readString("PC_P4").replace(',', '.'));
                        //Double dPcP1 = new Double(formatter.format(valor));
                        hippeis.setPc_p4(valor);
                    } else {
                        hippeis.setPc_p4(null);
                    }
                    
                    if (fs.readString("PC_P5") != null && !fs.readString("PC_P5").equals("")) {
                        Double valor = Double.parseDouble(fs.readString("PC_P5").replace(',', '.'));
                        //Double dPcP1 = new Double(formatter.format(valor));
                        hippeis.setPc_p5(valor);
                    } else {
                        hippeis.setPc_p5(null);
                    }
                    
                    if (fs.readString("PC_P6") != null && !fs.readString("PC_P6").equals("")) {
                        
                        Double valor = Double.parseDouble(fs.readString("PC_P6").replace(',', '.'));
                        //Double dPcP1 = new Double(formatter.format(valor));
                        hippeis.setPc_p6(valor);
                    } else {
                        hippeis.setPc_p6(null);
                    }
                    
                    if (fs.readString("TIPO_FRONTERA") != null && !fs.readString("TIPO_FRONTERA").equals("")) {
                        hippeis.setTipo_frontera(Integer.parseInt(fs.readString("TIPO_FRONTERA")));
                    } else {
                        hippeis.setTipo_frontera(null);
                    }
                    
                    if (fs.readString("ID_LINEA") != null && !fs.readString("ID_LINEA").equals("")) {
                        hippeis.setId_linea(Integer.parseInt(fs.readString("ID_LINEA")));
                    } else {
                        hippeis.setId_linea(null);
                    }
                    
                    if (fs.readString("ID_DH_EQUIPO") != null && !fs.readString("ID_DH_EQUIPO").equals("")) {
                        hippeis.setId_dh_equipo(Integer.parseInt(fs.readString("ID_DH_EQUIPO")));
                    } else {
                        hippeis.setId_dh_equipo(null);
                    }
                    
                    if (fs.readString("FECHA_GBD") != null && !fs.readString("FECHA_GBD").equals("")) {
                        hippeis.setFecha_gbd(fs.readDate("FECHA_GBD", "dd/MM/yyyy"));
                    } else {
                        hippeis.setFecha_gbd(null);
                    }
                    
                }
                
            } else {
                log.warn("No se ha insertado la linea por tener " + fs.getFieldCount() + " campos");
            }
            
        } catch (Exception e) {
            log.error("Error en el mapeo de la linea ");
        }
        
        return hippeis;
    }
    
}
