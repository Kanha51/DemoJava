package com.example.demo.ui;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ErrorResponseModel {

	private String message;
	private Integer statusCode;
	private Long errorReportingTime;
}
