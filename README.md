# 🚀 ReqRes API Testing Framework with RestAssured

## 📌 Overview
This project is a **REST API Automation Testing Framework** built using **RestAssured (Java)**, specifically designed for testing **ReqRes API (https://reqres.in/)**.  
It includes test cases for **CRUD operations (GET, POST, PUT, DELETE)** and supports **Data-Driven Testing, CI/CD integration, and Reporting**.

---

## 📌 Features ✅
- **Automated API Testing** using RestAssured (Java).
- **TestNG Framework** for structured test execution.
- **Data-Driven Testing** using JSON.
- **Allure Reports** for visual test execution reports.
- **CI/CD Integration** using GitHub Actions to automate testing with each code push.

---

## 📌 Tech Stack ⚙️
| **Technology**  | **Purpose** |
|----------------|------------|
| **Java**       | Primary programming language |
| **RestAssured** | API Automation |
| **TestNG**     | Test execution & reporting |
| **Maven**      | Dependency management |
| **Allure Reports** | Test reporting |
|**GitHub Actions**|CI/CD Integration|

---

## 📌 Project Structure 📂
```
reqres-api-testing  
|— src  
|   |— main  
|   |   |— utils  
|   |   |   |— ConfigReader.java  # Read config properties  
|   |   |   |— JsonUtil.java  # JSON response handling  
|   |— test  
|   |   |— apiTests  
|   |   |   |— GetUsersTest.java  
|   |   |   |— CreateUserTest.java 
|   |   |   |— RegisterUserTest.java 
|   |   |   |— UpdateUserTest.java 
|   |   |   |— DeleteUserTest.java  
|   |— resources  
|   |   |— testData.json  # Data for API testing  
|   |— reports  
|   |   |— allure-results  # Allure Reports  
|— pom.xml  # Maven dependencies  
|— testng.xml  # TestNG test suite  
|— README.md  # Project documentation  
```

---

## 📌 Setup & Installation 🔧

### **1️⃣ Prerequisites**
- Install **Java 11+**
- Install **Maven**
- Install **IntelliJ IDEA / Eclipse**
- Install **Allure Reports** (for reporting)

### **2️⃣ Clone the Repository**
```sh  
git clone https://github.com/yourusername/reqres-api-testing.git  
cd reqres-api-testing  
```

### **3️⃣ Install Dependencies**
```sh  
mvn clean install  
```

### **4️⃣ Run API Tests**
- Run all test cases:
```sh  
mvn test  
```
- Run a specific test case:
```sh  
mvn test -Dtest=GetUsersTest  
```

### **5️⃣ Generate Allure Report**
```sh  
allure serve target/allure-results  
```

---

## 📌 Future Improvements 🚀
- Add **Parallel Execution** with TestNG.
- Integrate **Performance Testing** with JMeter.
- Implement **Database Testing** to verify API responses.
