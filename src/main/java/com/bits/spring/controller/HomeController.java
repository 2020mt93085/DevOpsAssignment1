package com.bits.spring.controller;

import com.bits.spring.model.LoginRequest;
import com.bits.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.time.*;
import java.util.Date;
import java.util.Locale;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Controller
public class HomeController {

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        try {
            System.out.println("Home Page Requested, locale = " + locale);
            Date date = new Date();
            //DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
            DateFormat dateFormat = DateFormat.getDateInstance();

            String formattedDate = dateFormat.format(date);

            model.addAttribute("message", "Welcome to Bits Pillani");
           // model.addAttribute("serverTime", formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        return "home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated LoginRequest loginReq, Model model) {
    	String password = loginReq.getPassword();
    	String userName = loginReq.getUserName();
    	User user = null;
    	try{
    		FileInputStream fi = new FileInputStream(new File(userName+".txt"));
    		ObjectInputStream oi = new ObjectInputStream(fi);
    		
    		user = (User)  oi.readObject();
    		oi.close();
    		fi.close();
    	}catch (FileNotFoundException e) {
			System.out.println("File "+ userName+".txt not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (Throwable th) {
			// TODO Auto-generated catch block
			th.printStackTrace();
		}
    	
    	if(user == null) {
    		System.out.println("User is not registered");
    		model.addAttribute("errorMsg", "User is not registered");
    		return "register";
    	}else if(user.isPasswordValid(password)) {
    		System.out.println("User is authorized");
    		Date currentDate = new Date();
    		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
    		DateFormat dateFormat = DateFormat.getDateInstance();
    		String formattedDate = dateFormat.format(currentDate);
    		Date date = user.getDob();
    		//Converting obtained Date object to LocalDate object
    		Instant instant = date.toInstant();
    		ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
    		LocalDate givenDate = zone.toLocalDate();
    		//Calculating the difference between given date to current date.
    		Period period = Period.between(givenDate, LocalDate.now());
    		System.out.println("Hello "+user.getUserName()+" your current age is: ");
    		System.out.println(period.getYears()+" years "+period.getMonths() +" and "+period.getDays()+" days");
    		model.addAttribute("currentDate", formattedDate);
    		model.addAttribute("userName", user.getUserName());
    		model.addAttribute("year", period.getYears());
    		model.addAttribute("month", period.getMonths());
    		model.addAttribute("day", period.getDays());

    		return "user";
    	}else {
    		System.out.println("Invalid userName or Password");
    		model.addAttribute("errorMsg", "Invalid userName or Password");
    		return "home";
    	}
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated User user, Model model) {
        System.out.println("Got registration request for user: ["+user.toString()+"]");
        try {
        	FileOutputStream f = new FileOutputStream(new File(user.getUserName()+".txt"));
        	ObjectOutputStream o = new ObjectOutputStream(f);	
        	
        	o.writeObject(user);
        	o.close();
        	f.close();
        	System.out.println("Created User having name: "+user.getUserName());
        	model.addAttribute("successMsg", "Congratulatuion! Your account has been created.");
        	
        } catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (Throwable th) {
			// TODO Auto-generated catch block
			th.printStackTrace();
		}
        return "home";
    }
    
    @RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
    public String registrationPage() {
        try {
            System.out.println("Request to show registration page ");
            Date date = new Date();
            //DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
            DateFormat dateFormat = DateFormat.getDateInstance();

            String formattedDate = dateFormat.format(date);

//            model.addAttribute("message", "Welcome to Registration page");
           // model.addAttribute("serverTime", formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        return "register";
    }
}
