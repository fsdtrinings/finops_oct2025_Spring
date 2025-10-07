package com.mkj.app.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

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
	
	
	/* added new field for field level exception
	 *  key : field Name
	 *  value : error msg
	 * */
	
	Map<String, String> errorFieldInfo;

}
