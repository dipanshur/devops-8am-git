<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.shoestore.model.Product" %>
<%@ page import="java.util.List" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shoe Store</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
</head>
<body>
<header class="header">
    <div class="container">
        <h1>Shoe Store</h1>
        <p>Your destination for shoes and footwear essentials.</p>
    </div>
</header>
<main class="container">
    <section class="hero">
        <h2>Step into comfort and style</h2>
        <p>Browse our curated selection of shoes, insoles, socks, and more.</p>
    </section>

    <section class="product-grid">
        <% for (Product product : products) { %>
            <article class="product-card">
                <div class="product-image">
                    <%
                        String img = product.getImageUrl();
                        String resolvedImg;
                        if (img == null) {
                            resolvedImg = request.getContextPath() + "/images/placeholder.png";
                        } else if (img.startsWith("http") || img.startsWith("/")) {
                            resolvedImg = img;
                        } else {
                            resolvedImg = request.getContextPath() + "/" + img;
                        }
                    %>
                    <img src="<%= resolvedImg %>" alt="<%= product.getName() %>" />
                </div>
                <div class="product-info">
                    <span class="product-category"><%= product.getCategory() %></span>
                    <h3><%= product.getName() %></h3>
                    <p><%= product.getDescription() %></p>
                    <div class="product-footer">
                        <span class="price">$<%= String.format("%.2f", product.getPrice()) %></span>
                        <button type="button">Add to cart</button>
                    </div>
                </div>
            </article>
        <% } %>
    </section>
</main>
<footer class="footer">
    <p>&copy; 2026 Shoe Store. Walk with confidence.</p>
</footer>
</body>
</html>
