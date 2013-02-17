package com.studentProfile.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class ImageBytesResult implements Result {

private static final long serialVersionUID = 1L;

@Override
public void execute(ActionInvocation invocation) throws Exception {
	MyFriendsGetPicAction action = (MyFriendsGetPicAction) invocation.getAction();
HttpServletResponse response = ServletActionContext.getResponse();

response.setContentType(action.getContentType());
response.setContentLength(action.getContentLength());
response.getOutputStream().write(action.getImageInBytes());
response.getOutputStream().flush();
}

}