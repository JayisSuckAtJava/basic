package com.example.basic.excepiton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 인자가 없는 생성자
@AllArgsConstructor // 인자가 있는 생성자.
public class CustomException extends RuntimeException {
	private String message;
}
