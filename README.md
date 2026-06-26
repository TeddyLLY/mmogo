# mmogo

A full-stack Java CRUD demonstration project integrating Spring Boot and MongoDB, showcasing various database access approaches (MongoJDBC, MongoRepository, and MongoTemplate).

---

## 🌐 Demo Website

Experience the live demo here: **[mmogo.nekosaur.com](http://mmogo.nekosaur.com)**

---

## 🛠️ Tech Stack & Ecosystem

### Backend
* **Language:** Java 17 LTS
* **Framework:** Spring Boot, Spring MVC
* **Data Access:** Spring Data MongoDB
* **Build Tool:** Maven

### Frontend
* **Template Engine:** Thymeleaf
* **Styling & Scripting:** Bootstrap, jQuery

### Database & Dev Tools
* **Database:** MongoDB 6.0.6
* **GUI Clients:** MongoDB Compass, Postman (API Testing)
* **Infrastructure:** Docker, VirtualBox
* **IDE & Version Control:** IntelliJ IDEA, Git

---

## 🚀 API & Feature Operations

The project demonstrates two primary ways to interact with MongoDB:

### 1. Native Driver / JDBC Approach (API Only)
* **Endpoint:** `http://127.0.0.1:8085/crud`
* **Usage:** Best operated via Postman. A Postman Collection (Export/Import version v2.1) is provided in the repository for quick testing.

### 2. Spring Data Approach (Web UI)
* **Endpoint:** `http://127.0.0.1:8085` (or the Live Demo link)
* **Usage:** Built-in web UI powered by **Thymeleaf**, implementing database operations via **MongoRepository** and **MongoTemplate**.

---

## 📖 User Manual

For detailed step-by-step setup and operations, please refer to the internal documentation:
```bash
~/mmogo/src/main/.script/mongo/user_manual
~/mmogo/src/main/.script/mongo/*