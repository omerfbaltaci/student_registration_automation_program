# Student Registration Automation Program

## Overview

The **Student Registration Automation Program** is a user-friendly application designed for managing student records and scores through a graphical user interface (GUI). The program allows both admins and students to log in, with admins having full control over student data, while students can view scores and manage their own account.

## Features

- **Admin Login**:
  - Create, update, and delete student records.
  - Modify student scores.
  - Temporarily save new scores in `tempstudentinfo.txt` and finalize changes by updating `studentinfo.txt`.
- **Student Login**:
  - View the scores of all students.
  - Change the student's own password.
- **Admin Credential Management**:
  - Default admin credentials are stored in the `adminusers.txt` file.
  - Users can add or modify admin accounts via this file.

## File Management

- **adminusers.txt**: Stores admin usernames and passwords in the format `Username,Password` (e.g., `Taner,123`).
- **users.txt**: Stores student usernames and passwords in the same format as `adminusers.txt`.
- **studentinfo.txt**: Contains the registered student names and their scores in the format `student_name,x,x,x,x,x`, where each `x` represents a score of one lecture in order.
- **tempstudentinfo.txt**: Used for temporarily saving changes to student scores. When the admin finalizes updates, `studentinfo.txt` is overwritten by `tempstudentinfo.txt`.

## How It Works

1. **Admin Login**: 
   - Admins must log in using the credentials from the `adminusers.txt` file.
   - After logging in, the admin can create new student records, update existing ones, delete records, and modify student scores.
   - Any changes to student scores are first saved in `tempstudentinfo.txt`. When the admin clicks "Update," the changes are finalized by renaming `tempstudentinfo.txt` to `studentinfo.txt`.
   
2. **Student Login**:
   - A student can only log in after an admin has added their record.
   - Once logged in, students can view the scores of all students and change their own password.
   
3. **Data Persistence**:
   - Admin credentials are stored in `adminusers.txt`.
   - Student credentials are stored in `users.txt`.
   - Student records, including scores, are stored in `studentinfo.txt`. Admins can temporarily modify scores in `tempstudentinfo.txt` before finalizing the changes.

## File Structure

```
student_registration_automation_program/
│
├── Executable File (.jar)/
│   └── StudentRegistrationAutomation.jar    # The executable JAR file to launch the application
│
├── adminusers.txt                           # Stores admin login credentials
├── users.txt                                # Stores student login credentials
├── studentinfo.txt                          # Stores student records and their scores
├── tempstudentinfo.txt                      # Temporary file used when updating student scores
├── README.md                                # Project documentation
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
2. After adding the student, use the student’s credentials from `users.txt` to log in and view scores.

## Contributing

If you'd like to contribute to this project, feel free to fork the repository and submit a pull request.

### How to Contribute:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make your changes and commit them: `git commit -m 'Add feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Submit a pull request.

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

This version incorporates the details of the text files (`users.txt`, `studentinfo.txt`, and `tempstudentinfo.txt`) and how they interact with the program. Let me know if everything looks good!
