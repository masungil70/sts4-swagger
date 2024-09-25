package org.kosa.hello.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
	private String uid;
	private String pwd;
	private String name; 
}
