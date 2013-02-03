package com.studentProfile.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction extends ActionSupport{
	public String index(){
		System.out.println("I am in ForwardAction");
		return Action.SUCCESS;
	}
}
