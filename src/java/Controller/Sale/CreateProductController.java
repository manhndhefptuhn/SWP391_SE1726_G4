/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Sale;

import DAL.PCDAO;
import DAL.ProductDAO;
import Model.PC;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Tien Dat
 */
public class CreateProductController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        boolean status = Boolean.valueOf(request.getParameter("status"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double salePercentage = Double.parseDouble(request.getParameter("salePercentage"));
        int productStatusID = Integer.parseInt(request.getParameter("productStatus"));
        int categoryID = Integer.parseInt(request.getParameter("category"));
                
        ProductDAO pDAO = new ProductDAO();
        Product product = new Product();
        product.setProductName(productName);
        product.setDescription(description);
        product.setStatus(status);
        product.setQuantity(quantity);
        product.setSalePercentage(salePercentage);
        product.setProductStatusID(productStatusID);
        product.setCategoryID(categoryID);
        int productID = pDAO.createProduct(product);

        int cpuID = Integer.parseInt(request.getParameter("cpu"));
        int caseID = Integer.parseInt(request.getParameter("case"));
        int mainboardID = Integer.parseInt(request.getParameter("mainboard"));
        int storageID = Integer.parseInt(request.getParameter("storage"));
        int vgaID = Integer.parseInt(request.getParameter("vga"));
        int ramID = Integer.parseInt(request.getParameter("ram"));
        int psuID = Integer.parseInt(request.getParameter("psu"));
        
        PCDAO pcDAO = new PCDAO();
        PC pc = new PC();
        pc.setProductID(productID);
        pc.setMainboardID(mainboardID);
        pc.setCpuID(cpuID);
        pc.setRamID(ramID);
        pc.setVgaID(vgaID);
        pc.setStorageID(storageID);
        pc.setPsuID(psuID);
        pc.setCaseID(caseID);
        pcDAO.createPC(pc);
        
        
        request.setAttribute("notification", "Product created with ID " + productID);
        request.getRequestDispatcher("productList").forward(request, response);
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
