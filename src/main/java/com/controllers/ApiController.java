package com.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.api.back.model.ClsOperacion;
import com.api.back.model.service.ClsRespuestaService;
import com.api.back.model.service.bussines.ClsCalcBusiness;



@RestController
public class ApiController {
	@Autowired
	private ClsCalcBusiness serviceCalc;
	
	@Autowired
	private ClsRespuestaService serviceRespuesta;
	
	@Autowired
	private HttpServletRequest request;
	
	
	 
	@GetMapping(value="hola",produces=MediaType.APPLICATION_JSON_VALUE)
	public String hola(){
		serviceCalc.add(0, 1);
		
		return "Hola esto es una suma " + serviceCalc.add(0, 1);
	}
	@GetMapping(value="holas",produces=MediaType.APPLICATION_JSON_VALUE)
	public ClsOperacion operacions(){
		ClsOperacion clsOper = new ClsOperacion(1.0f,1.0f,"+");
		
		return clsOper;
	}
	@RequestMapping(value = "/api/process",method = RequestMethod.POST,
		    produces=MediaType.APPLICATION_JSON_VALUE)
		public String proces(@RequestBody ClsOperacion data) 
		    throws Exception {

		  System.out.println(data.toString());
		  float resultado = 0;
		  float num1=data.getNum1();
		  float num2=data.getNum2();
		  System.out.println("Addr " +request.getLocalAddr());
		  System.out.println("Name " +request.getLocalName());
		  System.out.println("URL " +request.getRequestURL());
		String status ="OK";
		String mensaje ="";  
		  switch(  data.getOperacion() ) {
			case "*":
				System.out.println("Multiplicacion ");
				resultado=serviceCalc.multiply(num1, num2);
				
			break;
			case "-":
				System.out.println("Resta ");
				resultado=serviceCalc.subtract(num1, num2);
			break;
			case "+":
				System.out.println("Suma ");
				resultado=serviceCalc.add(num1, num2);
			break;
			
			case "/":
				System.out.println("DIV ");
				if(num2==0) {
					status="Error";
					mensaje=serviceCalc.divideByZero(num1, num2);
					resultado=0;
				}
				else
				resultado=serviceCalc.divide(num1, num2);
			break;
		}
		  
		  //return new ResponseEntity<Object>(respuesta, HttpStatus.OK) ;
		  
		  
		  String respuesta = serviceRespuesta.respuesta(resultado,status, mensaje );
		  System.out.println("Service:: "+ respuesta );
		  System.out.println("resultado:: "+ resultado );
				  return respuesta;
		}

	
	/*
	public ClsCalcBusiness getServive() {
		return service;
	}
	public void setServive(ClsCalcBusiness servive) {
		this.service = servive;
	}
	*/
}
