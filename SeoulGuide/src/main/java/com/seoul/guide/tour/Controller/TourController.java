package com.seoul.guide.tour.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.seoul.guide.tour.DTO.TourDTO;
import com.seoul.guide.tour.Service.TourService;

@Controller
public class TourController {
		
	@Autowired
	private TourService tourservice;
	
	@RequestMapping(value = "tourlist", method = RequestMethod.GET)
	public ModelAndView tour() {
		ModelAndView mav = new ModelAndView();		
		try {
			mav.addObject("tourlist", tourservice.gettourList());
			mav.setViewName("tour/tour");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = "tourdetailsearch", method = RequestMethod.POST)
	public ModelAndView searchDetailTour(@RequestParam("menu_icon") String[] menu_icon, @RequestParam("tourist_subtitle") String tourist_subtitle) {
		ModelAndView mav = new ModelAndView();
		try {

			List<TourDTO> tourlist = tourservice.detailSearch(menu_icon, tourist_subtitle);
			mav.addObject("tourlist", tourlist);
			mav.setViewName("tour/tour");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="toursearch", method = RequestMethod.POST)
	public ModelAndView searchTour(@RequestParam("word") String word) {
		ModelAndView mav = new ModelAndView();
		try {
			List<TourDTO> tourlist = tourservice.Search(word);
			mav.addObject("tourlist", tourlist);
			mav.setViewName("tour/tour");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String tourdetail(Model model, Integer id) {
		try {
			TourDTO tourDTO = tourservice.detail(id);
			model.addAttribute("tourdetail", tourDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "tour/tourdetail";
	}

}
