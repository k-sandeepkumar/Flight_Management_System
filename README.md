# Flight Management System

## 🚀 Project Overview
The **Flight Management System** is a web-based CRUD (Create, Read, Update, Delete) application designed to manage airline operations efficiently.

## 📌 Features
- Create, Read, Update, and Delete (CRUD) operations for flights
- Passenger booking management
- API Documentation with Swagger UI

## 🛠️ Technologies Used
- **Backend:** Java, Spring Boot
- **Frontend:** HTML, CSS, JavaScript
- **Database:** MySQL
- **API Documentation:** Swagger

## 🔗 Project Links
- **GitHub Repository:** [Flight Management System](https://github.com/k-sandeepkumar/Flight_Management_System.git)
- **Swagger API Documentation:** [Swagger UI](http://localhost:8080/swagger-ui/index.html)

## 🚀 Setup Instructions
### Prerequisites
- Java 17+
- Spring Boot
- MySQL Database
- Maven

### Steps to Extract and Run the Project on Your PC
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/k-sandeepkumar/Flight_Management_System.git
   cd Flight_Management_System
   ```
   Alternatively, you can download the ZIP file from GitHub and extract it manually.

2. **Configure Database:**
   - Open `src/main/resources/application.properties`.
   - Update the database credentials (`spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`).
   
3. **Install Dependencies & Build the Project:**
   ```bash
   mvn clean install
   ```

4. **Run the Application:**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API Documentation:**
   - Open [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) in your browser.

## 📜 License
This project is licensed under the [MIT License](LICENSE).

## 🤝 Contributing
Contributions are welcome! Feel free to open an issue or submit a pull request.

## 📞 Contact
For any queries, reach out via GitHub Issues.
