# Student Registration Automation Program

## Overview

The **Student Registration Automation Program** is a user-friendly application designed for managing student records and scores through a graphical user interface (GUI). The program allows both admins and students to log in, with admins having full control over student data, while students can view scores and manage their own account.

## Features

- **Admin Login**:
  - Create, update, and delete student records.
  - Modify student scores.
- **Student Login**:
  - View the scores of all students.
  - Change the student's own password.
- **Admin Credential Management**:
  - Default admin credentials are stored in the `adminusers.txt` file.
  - Users can add or modify admin accounts via this file.

## How It Works

1. **Admin Login**: 
   - Admins must log in using the credentials from the `adminusers.txt` file.
   - After logging in, the admin can create new student records, update existing ones, delete records, and modify student scores.
   
2. **Student Login**:
   - A student can only log in after an admin has added their record.
   - Once logged in, students can view the scores of all students and change their own password.
   
3. **Data Persistence**:
   - Admin credentials are stored in `adminusers.txt`.
   - Student records, including scores, are stored within the system and can be updated or deleted by the admin.

## File Structure

```
student_registration_automation_program/
│
├── Executable File (.jar)/
│   └── StudentRegistrationAutomation.jar    # The executable JAR file to launch the application
│
├── adminusers.txt                           # Stores admin login credentials
├── README.md                                # Project documentation
└── LICENSE                                  # License file
```

## Getting Started

### Prerequisites

- Ensure that **Java** is installed on your system. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

### Running the Program

1. **Download or clone the repository**:

   ```bash
   git clone https://github.com/omerfbaltaci/student_registration_automation_program.git
   ```

2. **Navigate to the `Executable File (.jar)` directory** and open the JAR file:

   ```bash
   java -jar StudentRegistrationAutomation.jar
   ```

3. **Admin Login**:
   - Before logging in, open the `adminusers.txt` file to find the default admin username and password, or add new admin credentials.
   - Log in as an admin to start managing student records.

4. **Student Login**:
   - After at least one student record has been added by the admin, students can log in to view their scores and change their password.

### Example Admin Login

1. Open the `adminusers.txt` file and locate the following credentials:

   ```
   Taner,123
   ```

   This means the **Username** is `Taner` and the **Password** is `123`.

2. Use these credentials to log in as an admin:

   - **Username**: Taner
   - **Password**: 123

### Example Student Login

1. Log in as an admin first to create a new student.
2. After adding the student, use the student’s credentials to log in and view scores.

## Contributing

If you'd like to contribute to this project, feel free to fork the repository and submit a pull request.

### How to Contribute:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make your changes and commit them: `git commit -m 'Add feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Submit a pull request.
