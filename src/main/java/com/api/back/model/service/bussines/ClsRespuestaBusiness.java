package com.api.back.model.service.bussines;

import org.springframework.stereotype.Service;

import com.api.back.model.service.ClsCalcService;
import com.api.back.model.service.ClsRespuestaService;

import org.json.JSONObject;
/**
 * Created by asantos
 */
@Service
public class ClsRespuestaBusiness implements ClsRespuestaService {
   
       @Override
    public String respuesta(float resultado, String status, String mensaje) {
    	System.out.println("entro respuesta");
    	//falta colocar tipodeRespuesta OK; ERROR:
    	JSONObject respuesta = new JSONObject();
    	respuesta.put("status", status);
    	respuesta.put("respuesta", resultado);
     	respuesta.put("mensaje", mensaje); 	
    	return respuesta.toString();
    }


    /*
    @Override
	public float percentage(float n1, float n2) {
		
		result =  divide( multiply( n1 , n2 ), 100);
	
        return result;
	}
	*/
    
   
}
