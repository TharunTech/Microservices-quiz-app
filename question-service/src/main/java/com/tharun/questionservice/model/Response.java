package com.tharun.questionservice.model;

import java.util.Objects;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

@Data
@RequestMapping
public class Response {
	private Integer id;
	private String response;
	
	public Response(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", response=" + response + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}


	
	
	

}
