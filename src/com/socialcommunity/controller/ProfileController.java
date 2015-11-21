package com.socialcommunity.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.socialcommunity.domain.Person;
import com.socialcommunity.domain.Post;
import com.socialcommunity.service.PersonService;
import com.socialcommunity.service.PostService;


@Controller
public class ProfileController {
	
protected static Logger logger = Logger.getLogger("ProfileController");
	
	@Resource(name="personService")
	private PersonService personService;
	
	
	@Resource(name="postService")
	private PostService postService;
	
	private Person person;
	
	private Post Post;
	
	
	  @RequestMapping(value = "/lendingPage/{username}", method = RequestMethod.GET)
	  public String profilePage(@PathVariable("username")String username,HttpSession session) throws HibernateException, NoSuchAlgorithmException
	  {
	    	
	    username=(String) session.getAttribute("username");
	    

	    	
		return "profile";
		 
	  }

	  @RequestMapping(value = "/lendingPage/{username}/post",method = RequestMethod.POST)
	  public @ResponseBody()
	  Post add(HttpServletRequest request, HttpServletResponse response,HttpSession session)
	    throws Exception {

	   Post post = new Post();

	   String username=(String) session.getAttribute("username");
	   String post1 = request.getParameter("post_date");
	   
	  Date date=new Date();
	  
	  
	  String date1=""+date.getTime();
	   
	  post.setPost(post1);
	   post.setPost_date(date1);
	   post.setUsername(username);
	   
	   
	   System.out.println(date);
	   
	   postService.addPost(post);
	   
	   return post;
	  }

	  
	  
}