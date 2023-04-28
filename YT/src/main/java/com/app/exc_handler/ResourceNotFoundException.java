package com.app.exc_handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class ResourceNotFoundException extends RuntimeException{
	
String resourceName;
String fieldName;
long fieeldValue;
public ResourceNotFoundException(String resourceName, String fieldName, long fieeldValue) {
	super(String.format("%s not found with %s : %s", resourceName,fieldName, fieeldValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieeldValue = fieeldValue;
}

}
