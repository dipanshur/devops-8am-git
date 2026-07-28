<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Redirect root URL to the products servlet so static resources are still
    // served by the container (e.g., /styles.css).
    response.sendRedirect(request.getContextPath() + "/products");
%>
