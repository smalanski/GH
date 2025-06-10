# Invoice Management System - Project Structure

## Overview
This document outlines the project structure for the Invoice Management System, which follows a three-tier architecture:
- Frontend (React)
- Backend (Spring Boot Java)
- Storage (Database)

## Project Directory Structure

```
invoice-management-system/
├── frontend/                             # React frontend application
│   ├── public/                           # Public assets
│   │   ├── index.html                    # HTML entry point
│   │   ├── favicon.ico                   # Application icon
│   │   └── assets/                       # Static assets (images, fonts)
│   ├── src/                              # Source files
│   │   ├── components/                   # Reusable React components
│   │   │   ├── common/                   # Common UI components
│   │   │   │   ├── Button.jsx            # Custom button component
│   │   │   │   ├── Input.jsx             # Form input component
│   │   │   │   ├── Modal.jsx             # Modal dialog component
│   │   │   │   └── Notification.jsx      # Notification component
│   │   │   ├── layout/                   # Layout components
│   │   │   │   ├── Header.jsx            # Application header
│   │   │   │   ├── Sidebar.jsx           # Navigation sidebar
│   │   │   │   └── Footer.jsx            # Application footer
│   │   │   ├── invoice/                  # Invoice-specific components
│   │   │   │   ├── InvoiceList.jsx       # Invoice listing component
│   │   │   │   ├── InvoiceDetail.jsx     # Invoice detailed view
│   │   │   │   ├── LineItemList.jsx      # List of invoice line items
│   │   │   │   └── LineItemForm.jsx      # Form for changing line items
│   │   │   └── request/                  # Request-specific components
│   │   │       ├── ChangeRequestForm.jsx # Line item change request form
│   │   │       ├── RefundRequestForm.jsx # Full refund request form
│   │   │       └── RequestStatus.jsx     # Request status tracker
│   │   ├── pages/                        # Application pages
│   │   │   ├── Dashboard.jsx             # User dashboard
│   │   │   ├── InvoiceListPage.jsx       # Page for invoice listing
│   │   │   ├── InvoiceDetailPage.jsx     # Page for invoice details
│   │   │   ├── RequestFormPage.jsx       # Page for request forms
│   │   │   ├── RequestStatusPage.jsx     # Page for request tracking
│   │   │   └── AdminPages/               # Administrator pages
│   │   │       ├── AdminDashboard.jsx    # Admin dashboard
│   │   │       ├── RequestManagement.jsx # Request management interface
│   │   │       └── RefundProcessing.jsx  # Refund processing page
│   │   ├── services/                     # API services
│   │   │   ├── auth.service.js           # Authentication service
│   │   │   ├── invoice.service.js        # Invoice data service
│   │   │   └── request.service.js        # Change/refund request service
│   │   ├── utils/                        # Utility functions
│   │   │   ├── formatters.js             # Data formatting utilities
│   │   │   ├── validators.js             # Form validation functions
│   │   │   └── constants.js              # Application constants
│   │   ├── context/                      # React context providers
│   │   │   ├── AuthContext.jsx           # Authentication context
│   │   │   └── NotificationContext.jsx   # Notification system context
│   │   ├── hooks/                        # Custom React hooks
│   │   │   ├── useAuth.js                # Authentication hook
│   │   │   └── useForm.js                # Form handling hook
│   │   ├── App.jsx                       # Main application component
│   │   ├── index.jsx                     # React entry point
│   │   └── routes.jsx                    # Application routing
│   ├── package.json                      # Frontend dependencies
│   ├── .env                              # Environment variables
│   ├── .eslintrc                         # ESLint configuration
│   └── README.md                         # Frontend documentation
│
├── backend/                              # Spring Boot backend application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/invoice/
│   │   │   │   ├── api/                  # REST API controllers
│   │   │   │   │   ├── InvoiceController.java     # Invoice endpoints
│   │   │   │   │   ├── RequestController.java     # Request endpoints
│   │   │   │   │   ├── AdminController.java       # Admin endpoints
│   │   │   │   │   └── AuthController.java        # Auth endpoints
│   │   │   │   ├── config/               # Application configuration
│   │   │   │   │   ├── SecurityConfig.java        # Security settings
│   │   │   │   │   ├── DatabaseConfig.java        # Database config
│   │   │   │   │   └── WebConfig.java             # Web configuration
│   │   │   │   ├── model/                # Data models
│   │   │   │   │   ├── Invoice.java               # Invoice entity
│   │   │   │   │   ├── LineItem.java              # Line item entity
│   │   │   │   │   ├── ChangeRequest.java         # Change request entity
│   │   │   │   │   ├── RefundRequest.java         # Refund request entity
│   │   │   │   │   └── User.java                  # User entity
│   │   │   │   ├── repository/           # Data repositories
│   │   │   │   │   ├── InvoiceRepository.java     # Invoice data access
│   │   │   │   │   ├── LineItemRepository.java    # Line item data access
│   │   │   │   │   ├── RequestRepository.java     # Request data access
│   │   │   │   │   └── UserRepository.java        # User data access
│   │   │   │   ├── service/              # Business logic services
│   │   │   │   │   ├── InvoiceService.java        # Invoice operations
│   │   │   │   │   ├── RequestService.java        # Request processing
│   │   │   │   │   ├── NotificationService.java   # Notification handling
│   │   │   │   │   └── UserService.java           # User management
│   │   │   │   ├── dto/                  # Data Transfer Objects
│   │   │   │   │   ├── InvoiceDTO.java            # Invoice data transfer
│   │   │   │   │   ├── RequestDTO.java            # Request data transfer
│   │   │   │   │   └── UserDTO.java               # User data transfer
│   │   │   │   ├── exception/            # Custom exceptions
│   │   │   │   │   ├── ResourceNotFoundException.java
│   │   │   │   │   ├── UnauthorizedException.java
│   │   │   │   │   └── BadRequestException.java
│   │   │   │   ├── util/                 # Utility classes
│   │   │   │   │   ├── JwtUtil.java               # JWT handling
│   │   │   │   │   └── ValidationUtil.java        # Validation helpers
│   │   │   │   └── Application.java      # Application entry point
│   │   │   └── resources/
│   │   │       ├── application.properties # Application configuration
│   │   │       ├── application-dev.properties    # Dev environment config
│   │   │       └── application-prod.properties   # Production config
│   │   └── test/                         # Unit and integration tests
│   │       └── java/com/invoice/
│   │           ├── api/                  # Controller tests
│   │           ├── service/              # Service tests
│   │           └── repository/           # Repository tests
│   ├── pom.xml                           # Maven dependencies
│   └── README.md                         # Backend documentation
│
├── database/                             # Database scripts and schema
│   ├── schema/
│   │   ├── tables/                       # Table definitions
│   │   │   ├── invoice.sql               # Invoice table
│   │   │   ├── line_item.sql             # Line item table
│   │   │   ├── change_request.sql        # Change request table
│   │   │   ├── refund_request.sql        # Refund request table
│   │   │   └── users.sql                 # User table
│   │   ├── views/                        # Database views
│   │   │   ├── invoice_summary.sql       # Invoice summary view
│   │   │   └── request_status.sql        # Request status view
│   │   ├── indexes/                      # Database indexes
│   │   │   └── indexes.sql               # Index definitions
│   │   └── init.sql                      # Database initialization
│   ├── migrations/                       # Database migrations
│   │   ├── V1__initial_schema.sql        # Initial schema migration
│   │   └── V2__add_request_tracking.sql  # Additional features migration
│   └── README.md                         # Database documentation
│
├── docs/                                 # Project documentation
│   ├── api/                              # API documentation
│   │   └── openapi.yaml                  # OpenAPI specification
│   ├── architecture/                     # Architecture diagrams
│   │   └── component-diagram.png         # System component diagram
│   └── user-guides/                      # User guides
│       ├── admin-guide.md                # Administrator guide
│       └── user-guide.md                 # End-user guide
│
├── docker/                               # Docker configuration
│   ├── frontend/                         # Frontend container
│   │   └── Dockerfile                    # Frontend build instructions
│   ├── backend/                          # Backend container
│   │   └── Dockerfile                    # Backend build instructions
│   ├── database/                         # Database container
│   │   └── Dockerfile                    # Database setup instructions
│   └── docker-compose.yml                # Multi-container definition
│
├── .gitignore                            # Git exclusions
├── README.md                             # Project overview
└── LICENSE                               # Project license
```

## Key Components

### Frontend Components
- **Invoice Listing & Viewing**: Components for displaying and interacting with invoices
- **Line Item Management**: Forms and interfaces for selecting and requesting changes to line items
- **Refund Request System**: Components for submitting and tracking refund requests
- **Status Tracking**: Interfaces for monitoring request statuses
- **Admin Dashboard**: Interface for administrators to manage requests

### Backend Services
- **Invoice Service**: Manages invoice data and operations
- **Request Service**: Processes change and refund requests
- **Notification Service**: Handles user notifications for status updates
- **Authentication/Authorization**: Manages user authentication and permissions

### Database Structure
- **Invoices & Line Items**: Stores invoice data and line item details
- **Request Records**: Maintains change and refund request information
- **User Data**: Stores user account information and roles
- **Audit Logs**: Tracks all system transactions

## Development Guidelines

### Code Organization
- Follow component-based architecture in the frontend
- Implement service-oriented architecture in the backend
- Maintain separation of concerns across all layers

### Security Considerations
- Implement JWT for authentication
- Use HTTPS for all communications
- Apply role-based access control
- Validate all user inputs
- Implement audit logging for sensitive operations

### Performance Optimization
- Implement pagination for large data sets
- Use caching where appropriate
- Optimize database queries with proper indexing
- Implement efficient state management in the frontend

This structure provides a solid foundation for building the Invoice Management System according to the specified requirements, with clear separation of concerns and organized components for each tier of the application.
