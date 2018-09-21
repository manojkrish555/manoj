package com.kg.emailclientcrud.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kg.emailclientcrud.model.Contact;

import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;

/**
 * Contactcontrolller
 */
@WebServlet("/contacts")
public class Contactcontroller1 extends HttpServlet{
    private static final long serialVersionUID = 1L;
	ArrayList<Contact> contactlist=new ArrayList<Contact>();
    private String mode = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String function = req.getParameter("function");
        System.out.println(function);
        System.out.println("Hello");

        try {
            switch (function) {
            case "delete":
                deletecontact(req, resp);
                break;

            case "edit":
                // System.out.println("case= edit");
                showEditForm(req, resp);
                break;

            case "insert":
                showAddForm(req, resp);
                break;

            case "saveorupdate":
                saveorupdatecontact(req, resp);
                break;

            default:
                listcontact(req, resp);
                break;
            }
        } catch (ServletException | IOException e) {

            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
        private void listcontact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher=req.getRequestDispatcher("contactdisplay.jsp");
        dispatcher.forward(req,resp);
    }
    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showAddForm called");
        RequestDispatcher view = req.getRequestDispatcher("contact.jsp");
        view.forward(req, resp);

    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showEditForm called");
        mode = "update";
        int userid = Integer.parseInt(req.getParameter("userid"));
        System.out.println(userid);

        Contact updatecontact = new Contact();

        for (Contact contact : contactlist) {
            if (contact.getUserid() == userid) {
                updatecontact = contact;
                break;
            }

        }
        req.setAttribute("contact", updatecontact);
        RequestDispatcher view = req.getRequestDispatcher("contact.jsp");
        view.forward(req, resp);
    }

    private void saveorupdatecontact(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("saveorupdateUser called");
        int count = 0;
        int size = contactlist.size();
     
        if (mode != "update") 
        {
            System.out.println("if called");
            int userid = Integer.parseInt(req.getParameter("userid"));
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            Contact newcontact = new Contact(userid,email,phone);
         if(size!=0)
         {
            for (Contact user1 : contactlist) 
            {
                if ((newcontact.userid) != (user1.userid)) 
                {
                    count++;
                    System.out.println(count);

                    if (size == count) 
                    {
                        contactlist.add(newcontact);
                        req.setAttribute("contactlist", contactlist);
                        RequestDispatcher view = req.getRequestDispatcher("contactdisplay.jsp");
                        view.forward(req, resp);
                        break;
                    } 
                    else 
                    {
                        continue;
                    }
                } 
                else 
                {
                    req.setAttribute("contactlist", contactlist);
                    RequestDispatcher view = req.getRequestDispatcher("contactdisplay.jsp");
                    view.forward(req, resp);
                }

            }
          }  
          else
          {
            // req.setAttribute("userList", userList);
            System.out.println("else called");

            contactlist.add(newcontact);
            req.setAttribute("contactlist", contactlist);
            RequestDispatcher view = req.getRequestDispatcher("contactdisplay.jsp");
            view.forward(req, resp);
          }
        }

            // req.setAttribute("userList", userList);
        else 
        {
            System.out.println("edit user called arraylist to be updated here");

            int userid = Integer.parseInt(req.getParameter("userid"));
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");

            Contact updatecontact = new Contact(userid, email,phone);

            for (Contact user : contactlist) {
                if (user.getUserid() == userid) {
                    contactlist.set(contactlist.indexOf(user), updatecontact);
                    mode="";
                    break;
                }

            }
        
            req.setAttribute("contactlist", contactlist);
            RequestDispatcher view = req.getRequestDispatcher("contactdisplay.jsp");
            view.forward(req, resp);

        }

    }

    private void deletecontact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userid = Integer.parseInt(req.getParameter("userid"));
        for (Contact user : contactlist) {
            if (user.getUserid() == userid) {

                System.out.println(user);
                contactlist.remove(contactlist.indexOf(user));
                break;
            }

        }

        req.setAttribute("contactlist", contactlist);
        RequestDispatcher view = req.getRequestDispatcher("contactdisplay.jsp");
        view.forward(req, resp);
    }

}

    
