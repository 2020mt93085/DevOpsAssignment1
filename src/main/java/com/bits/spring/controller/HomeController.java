package com.bits.spring.controller;

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
    public String user(@Validated User user, Model model) {
        System.out.println("Redirected to user's page");
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
        System.out.print("Hello "+user.getUserName()+" your current age is: ");
        System.out.print(period.getYears()+" years "+period.getMonths() +" and "+period.getDays()+" days");
        model.addAttribute("currentDate", formattedDate);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("year", period.getYears());
        model.addAttribute("month", period.getMonths());
        model.addAttribute("day", period.getDays());

        return "user";
    }
}
