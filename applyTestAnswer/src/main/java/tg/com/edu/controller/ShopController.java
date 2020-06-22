package tg.com.edu.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Autowired
	ShopService shopService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/shop/product/list.do", method = RequestMethod.GET)
	public String productList(Model model) {
		
		
		return "shop/productList";
	}
	
	@RequestMapping(value = "/shop/receipt/view.do", method = RequestMethod.POST)
	public String receiptView(String name1, int price1, int count1
			,String name2, int price2, int count2, Model model) {
		
		shopService.receiptView();
		
		model.addAttribute("name1", name1);
		model.addAttribute("price1", price1);
		model.addAttribute("count1", count1);
		
		model.addAttribute("name2", name2);
		model.addAttribute("price2", price2);
		model.addAttribute("count2", count2);

		return "shop/receiptView";
	}
	
}
