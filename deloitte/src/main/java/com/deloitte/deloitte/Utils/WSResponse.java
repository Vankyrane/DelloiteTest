package com.deloitte.deloitte.Utils;

//Web Service Response class for returning operation status and result set for better understanding the errors while testing APIS through POSTMAN
public class WSResponse {
	private int operationStatus;
	private Object resultSet;
	public int getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(int operationStatus) {
		this.operationStatus = operationStatus;
	}
	public Object getResultSet() {
		return resultSet;
	}
	public void setResultSet(Object resultSet) {
		this.resultSet = resultSet;
	}
	@Override
	public String toString() {
		return "WSResponse [operationStatus=" + operationStatus + ", resultSet=" + resultSet + "]";
	}
	
	
}
