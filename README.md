# ⚖️ Dynamic Load-Balanced Request Routing System

This project demonstrates a distributed backend system using **Java 21**, **Spring Boot**, **Docker**, and **NGINX** as a load balancer to handle concurrent HTTP requests across multiple server instances.

---

## 🚀 Features

- Built with **Spring Boot 3.5.3**
- Handles concurrent requests using multithreading (`ExecutorService`)
- Simulates realistic backend load
- Containerized using **Docker**
- Load balanced with **NGINX**
- Supports testing across **multiple containers**

---

## 🏗️ Project Structure



---

## 📦 Technologies Used

- Java 21
- Spring Boot 3.5.3
- Maven
- Docker
- NGINX (Reverse Proxy)
- Docker Compose

---

## 📥 Getting Started

### 1️⃣ Build Spring Boot Application

```bash
cd backend
mvn clean package

load-balancer-system/
├── backend/
│ ├── src/ # Spring Boot source code
│ ├── Dockerfile # Dockerfile for backend
│ └── pom.xml # Maven project file
│
└── nginx/
├── nginx.conf # NGINX reverse proxy config
└── docker-compose.yml # Compose to run NGINX container

2️⃣ Build Docker Image
docker build -t loadbalancer-app .
3️⃣ Run Multiple Containers
docker run -d -p 8081:8080 --name instance1 loadbalancer-app
docker run -d -p 8082:8080 --name instance2 loadbalancer-app
docker run -d -p 8083:8080 --name instance3 loadbalancer-app
4️⃣ Start NGINX Load Balancer
cd ../nginx
docker compose up -d
🌐 Access Application
Visit:
http://localhost:8080/process
