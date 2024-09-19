This project is an eCommerce application built with Java using Spring Boot. It includes functionalities for managing products and categories, using RESTful APIs and a web interface. The application demonstrates best practices in modern Java development and can serve as a useful starting point for similar projects.

Features
Product Management: Create, update, and manage products.
Category Management: Manage product categories.
API Documentation: Interactive API documentation using Springdoc OpenAPI.
Web Interface: A user-friendly web interface built with Thymeleaf and Bootstrap.
Database: Uses H2 database for development and MySQL for production.
Technologies Used
Java: Programming language.
Spring Boot: Framework for building production-ready applications.
Spring Data JPA: For data access and ORM.
Thymeleaf: Server-side Java template engine for rendering web pages.
Bootstrap: Front-end framework for styling.
Springdoc OpenAPI: For generating API documentation.
Docker: Containerization of the application.
MySQL: Database management system.
H2: In-memory database for development purposes.
Project Setup
Prerequisites
Java 17: Ensure you have Java 17 installed.
Maven: For building the project.
Docker: For containerization.

Example Endpoints
Add Product

Endpoint: POST /product/add

Request Body:

json
{
    "name": "Product Name",
    "imageURL": "http://example.com/image.jpg",
    "price": 99.99,
    "description": "Product Description",
    "categoryId": 1
}

Update Category

Endpoint: POST /category/update/{categoryID}

Request Body:

json
{
    "name": "Updated Category Name"
}

Contribution
Feel free to fork this repository, make changes, and submit pull requests. Contributions and feedback are welcome!
