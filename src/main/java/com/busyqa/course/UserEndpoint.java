package com.busyqa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.busyqa.course.springboot_course_4_soap.GetUserRequest;
import com.busyqa.course.springboot_course_4_soap.GetUserResponse;

@Endpoint
public class UserEndpoint {
	private static final String NAMESPACE_URI = "http://busyqa.com/course/springboot-course-4-soap";

	@Autowired
	private UserService userService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
		GetUserResponse response = new GetUserResponse();
		response.setUser(this.userService.findUser(request.getIdUser()));

		return response;
	}
}
