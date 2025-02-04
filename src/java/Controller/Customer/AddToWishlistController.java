/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Customer;

import DAL.WishlistDAO;
import Model.User;
import Model.Wishlist;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Zarius
 */
public class AddToWishlistController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        try {
            WishlistDAO wlDAO = new WishlistDAO();

            int productID = Integer.parseInt(request.getParameter("productID"));
            User u = (User) session.getAttribute("user");

            Wishlist wl = wlDAO.getWishlist(u.getUser_ID(), productID);

            int row, totalWishlistProduct;
            //if not exist the product in wishlist
            if (wl == null) {
                //add the product to wishlist
                row = wlDAO.addToWishlist(u.getUser_ID(), productID);
                if (row >= 1) {
                    //add success
                    session.setAttribute("notification", "Add to wishlist successfully");
                    totalWishlistProduct = wlDAO.getTotalWishlistProduct(u.getUser_ID());
                    session.setAttribute("totalWishlistProduct", totalWishlistProduct);
                    response.sendRedirect(extractPath(request.getHeader("Referer")));
                } else {
                    throw new Exception();
                }
            } else {
                //already exist in wishlist
                session.setAttribute("wrongNotification", "This product is already in wishlist!");
                //back to previous page
                response.sendRedirect(extractPath(request.getHeader("Referer")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("wrongNotification", "An error occurred. Please try again.");
            response.sendRedirect(extractPath(request.getHeader("Referer")));
        }

    }

    //extract the path of url
    //"https://www.example.com/user/profile?id=123"; -> user/profile?id=123
    private String extractPath(String url) {
        try {
            URI uri = new URI(url);
            String path = uri.getPath() + (uri.getQuery() != null ? "?" + uri.getQuery() : "");
            if (path.substring(path.lastIndexOf('/') + 1).equals("login")) {
                return "home";
            } else {
                return path.substring(path.lastIndexOf('/') + 1); // Remove the preceding slash

            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
