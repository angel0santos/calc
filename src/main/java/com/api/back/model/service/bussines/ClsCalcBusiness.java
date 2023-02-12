package com.api.back.model.service.bussines;

import org.springframework.stereotype.Service;

import com.api.back.model.service.ClsCalcService;

import org.json.JSONObject;
/**
 * Created by asantos
 */
@Service
public class ClsCalcBusiness implements ClsCalcService {
   
    private float result;

    @Override
    public float add(float n1, float n2){
        result = n1 + n2;
        return result;
    }
    @Override
    public float subtract(float n1, float n2){
        result = n1 - n2;
        return result;
    }
    @Override
    public float divide(float n1, float n2){
        result = n1 / n2;
        return result;
    }
    @Override
    public String divideByZero(float n1, float n2){
        
        return "No se puede dividir por cero";
    }


    @Override
	public float multiply(float n1, float n2) {
		
		result = n1 * n2;
        return result;
	}

    
   
}
