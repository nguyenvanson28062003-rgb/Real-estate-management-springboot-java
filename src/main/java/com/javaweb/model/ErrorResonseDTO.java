package com.javaweb.model;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class ErrorResonseDTO {
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<String> getDetail() {
		return detail;
	}
	public void setDetail(List<String> detail) {
		this.detail = detail;
	}
	private List<String> detail = new ArrayList<String>();
	
}
