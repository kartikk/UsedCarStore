package com.usedcarstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usedcarstore.model.Listing;
import com.usedcarstore.service.ListingDAOService;

@RestController
public class WebController {

	@Autowired
	private ListingDAOService daoService;

	@RequestMapping("/search")
	public List<Listing> search(@RequestParam("searchKey") String searchKey) {
		System.out.println(searchKey);
		return daoService.getListings(searchKey);
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello!";
	}

}
