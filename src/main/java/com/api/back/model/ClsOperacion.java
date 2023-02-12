package com.api.back.model;


public class ClsOperacion {

	private String operacion;
	private float num1;
	private float num2;
	
	
	
	public ClsOperacion(float num1, float num2,String operacion) {
		super();
		this.operacion = operacion;
		this.num1 = num1;
		this.num2 = num2;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public float getNum1() {
		return num1;
	}
	public void setNum1(float num1) {
		this.num1 = num1;
	}
	public float getNum2() {
		return num2;
	}
	public void setNum2(float num2) {
		this.num2 = num2;
	}
	@Override
	public String toString() {
		return "ClsOperacion [operacion=" + operacion + ", num1=" + num1 + ", num2=" + num2 + "]";
	}
	
	
}
