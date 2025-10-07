package com.mkj.app.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* Custom Exception Response Template*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	
	
	private String errorMsg;
	private String issueSrc;
	private LocalDateTime now;

}
