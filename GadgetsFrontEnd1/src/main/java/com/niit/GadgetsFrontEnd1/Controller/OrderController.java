package com.niit.GadgetsFrontEnd1.Controller;

 

import java.util.List;

 

import javax.servlet.http.HttpSession;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AnonymousAuthenticationToken;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Gadgets.Dao.BillingDao;
import com.niit.Gadgets.Dao.CartDao;
import com.niit.Gadgets.Dao.CartItemsDao;
import com.niit.Gadgets.Dao.OrderDao;
import com.niit.Gadgets.Dao.OrderItemsDao;
import com.niit.Gadgets.Dao.PayDao;
import com.niit.Gadgets.Dao.ProductDao;
import com.niit.Gadgets.Dao.ShippingDao;
import com.niit.Gadgets.Dao.UserDao;
import com.niit.Gadgets.Model.Billing;
import com.niit.Gadgets.Model.Cart;
import com.niit.Gadgets.Model.CartItems;
import com.niit.Gadgets.Model.Order;
import com.niit.Gadgets.Model.OrderItems;
import com.niit.Gadgets.Model.Pay;
import com.niit.Gadgets.Model.Product;
import com.niit.Gadgets.Model.Shipping;
import com.niit.Gadgets.Model.User;

 

 

@Controller

public class OrderController {

 
@Autowired

Cart cart;

@Autowired

CartDao cartDao;

@Autowired

CartItems cartItems;

@Autowired

CartItemsDao cartItemsDao;

@Autowired

Billing billing;

@Autowired

BillingDao billingDao;

@Autowired

Shipping shipping;

@Autowired

ShippingDao shippingDao;

@Autowired

Pay pay;

@Autowired

PayDao payDao;

@Autowired

Order order;

@Autowired

OrderDao orderDao;

@Autowired

OrderItems orderItems;

@Autowired

OrderItemsDao orderItemsDao;

@Autowired

Product product;

@Autowired

ProductDao productDao;

@Autowired

User user;

@Autowired

UserDao userDao;

@Autowired

List<CartItems> cartItems1;

//@Autowired
//
//    private JavaMailSender mailSender;

String o;

@RequestMapping("/Buyall")

public String orderall(Model model,HttpSession session) {

Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

if (!(authentication instanceof AnonymousAuthenticationToken)) {

String currusername = authentication.getName();

user = userDao.getEmail(currusername);

cart = user.getCart();

// session.setAttribute("products", product1);

cartItems1= cartItemsDao.getlist(cart.getCart_Id());

billing = billingDao.getUser(user.getUserId());

List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUserId());

model.addAttribute("billing", billing);

model.addAttribute("user", user);

model.addAttribute("shippingAddresies", shippingAddresies);

model.addAttribute("shippingAddress", new Shipping());

session.setAttribute("p", product);

}

return "addressorder";

} 

 

@RequestMapping("/Buy/{ProductId}/{Cartitem_Id}")

public String order(@PathVariable("ProductId") String id, Model model,HttpSession session) {

Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

if (!(authentication instanceof AnonymousAuthenticationToken)) {

String currusername = authentication.getName();

user = userDao.getEmail(currusername);

cart = user.getCart();

cartItems1=null;

product = productDao.getProduct(id);

billing = billingDao.getUser(user.getUserId());

System.out.println(billing.getBillingAddress());

// for(Billing b: billing)

// {

// System.out.println(b.getBillId());

// System.out.println(b.getCountry());

// }

List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUserId());

user.setBilling(billing);

model.addAttribute("billing", billing);

model.addAttribute("user", user);

model.addAttribute("shippingAddresies", shippingAddresies);

model.addAttribute("shippingAddress", new Shipping());

session.setAttribute("p", product);

return "Billing";

} else {

return "redirect:/";

}

 

}

 

@RequestMapping("/orderConfirm")

public String payment(@ModelAttribute("shippingAddress") Shipping sh, Model model) {

// if(cartItems==null || cartItems.isEmpty())

// {

// System.out.println("sorry");

// }

sh.setUser(user);

shipping = sh;

shippingDao.saveorupdate(sh);

model.addAttribute("billing", billing); 

model.addAttribute("shippingAddress", shipping);

model.addAttribute("prot", product);

model.addAttribute("cartItems",cartItems1);

model.addAttribute("cart",cart);

return "OrderConfirmation";

}

 

@RequestMapping("/previous")

public String previous(Model model) {

List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUserId());

model.addAttribute("shippingAddresies", shippingAddresies);

model.addAttribute("billing", billing);

model.addAttribute("shippingAddress", shipping);

model.addAttribute("product", product);

return "Billing";
}


@RequestMapping("/pay")
public String payment()
{
	return "Payment";
	
}


@RequestMapping("/payment")

public String payment(@RequestParam("payb2") String str, Model model) {

  System.out.println(1324);

int a;

System.out.println(str);

if(str.equals(o))

{

return "redirect:/orderconfirmation" ;

}

return "redirect:/orderconfirmation";

}

//System.out.println(1324);
//int a;
//System.out.println(str);
//if(str.equals(o))
//
//{
//    return"redirect:/orderconfirmation";	
//}

@RequestMapping("/orderconfirmation")

public String orderconformation(HttpSession session) {

System.out.println(32);

order.setBilling(billing);

order.setShipping(shipping);

order.setPay(pay);

order.setUser(user);

System.out.println(524);

// cartItems1= cartItemsDao.getlist(cart.getCart_Id());

if (cartItems1 == null) 

{

order.setGrand_Total(product.getProductPrice());

orderDao.saveorupdate(order);

orderItems.setOrder(order);

orderItems.setProduct_Id(product.getProductId());

orderItemsDao.saveorupdate(orderItems);

cart.setGrand_total(cart.getGrand_total() - cartItems.getPrice());

cart.setTotal_items(cart.getTotal_items() - 1);

session.setAttribute("items", cart.getTotal_items());

cartDao.saveorupdate(cart);

//cartItemsDao.deleteCt(cartItemsDao.getlistall(cart.getCart_Id(),product.getProductId()).getCartItems_Id());

System.out.println(324);

}

else

{ 

System.out.println(656);

order.setGrand_Total(cart.getGrand_total());

orderDao.saveorupdate(order);

for(CartItems c:cartItems1)

{

System.out.println(3444);

orderItems.setOrder(order);

orderItems.setProduct_Id(c.getProduct().getProductId());

System.out.println(3443);

orderItemsDao.saveorupdate(orderItems);

cartItemsDao.delete(c);

}

cart.setGrand_total(0.0);

cart.setTotal_items(0);

System.out.println(346);

session.setAttribute("items", cart.getTotal_items());

cartDao.saveorupdate(cart);

}

// cartItems=null;

// cartItems1=null;

// product=null;

order=new Order();

orderItems=new OrderItems();

System.out.println(565);

return "thankyou";

}

 

//@RequestMapping(value="/SendMail")
//
//public void SendMail() {
//
//System.out.println(21312);
//
//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//if (!(authentication instanceof AnonymousAuthenticationToken)) {
//
//String currusername = authentication.getName();
//
//user = userDao.getEmail(currusername);      
//
//Otpgenerator otp=new Otpgenerator();
//
//String o=otp.Otpga();
//
//o=otp.Otpga();
//
//String recipientAddress = user.getUseEmail_id();
//
//String subject="OTP";
//
////String subject = request.getParameter("subject");
//
//String message = "your one time password is "+o+" ";
//
// 
//
////prints debug info
//
//System.out.println("To:" + recipientAddress);
//
//System.out.println("Subject: " + subject);
//
//System.out.println("Message: " + message);
//
// 
//
//    
//
//System.out.println("OTP:"+ otp);
//
////creates a simple e-mail object
//
//SimpleMailMessage email = new SimpleMailMessage();
//
//email.setTo(recipientAddress);
//
//email.setSubject(subject);
//
//email.setText(message);
//
////email.setSubject(otp);
//
// //sends the e-mail
//
//mailSender.send(email);
//
// 
//
// 
//
//// forwards to the view named "Result"
//
////return "Result";
//
//}
//
//}

}
