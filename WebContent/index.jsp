<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

```
<title>Student Registration</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Inter', 'Segoe UI', Arial, sans-serif;
    }

    body {
        min-height: 100vh;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 30px 16px;
    }

    .page-wrap {
        width: 100%;
        max-width: 650px;
    }

    .card {
        background: #ffffff;
        border-radius: 20px;
        box-shadow:
            0 10px 25px rgba(0, 0, 0, 0.08),
            0 25px 60px rgba(30, 20, 80, 0.20);
        overflow: hidden;
    }

    .card-header {
        text-align: center;
        padding: 38px 40px 25px;
    }

    .icon {
        width: 64px;
        height: 64px;
        margin: 0 auto 18px;

        display: flex;
        align-items: center;
        justify-content: center;

        border-radius: 50%;

        background: linear-gradient(135deg, #5b6cff, #8b5cf6);

        color: #ffffff;
        font-size: 28px;
        font-weight: 800;

        box-shadow: 0 8px 22px rgba(91, 108, 255, 0.30);
    }

    .card-header h1 {
        color: #111827;
        font-size: 25px;
        font-weight: 800;
        margin-bottom: 8px;
    }

    .card-header p {
        color: #6b7280;
        font-size: 14px;
    }

    .form-container {
        padding: 10px 40px 36px;
    }

    .form-group {
        margin-bottom: 18px;
    }

    .form-group label {
        display: block;
        margin-bottom: 7px;

        color: #374151;
        font-size: 14px;
        font-weight: 600;
    }

    .form-group input {
        width: 100%;
        padding: 13px 14px;

        border: 1px solid #dfe1e7;
        border-radius: 10px;

        background: #fafafa;

        color: #111827;
        font-size: 14px;

        outline: none;

        transition: all 0.2s ease;
    }

    .form-group input::placeholder {
        color: #9ca3af;
    }

    .form-group input:focus {
        background: #ffffff;
        border-color: #6d5dfc;

        box-shadow:
            0 0 0 3px rgba(109, 93, 252, 0.12);
    }

    .form-row {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 16px;
    }

    .register-btn {
        width: 100%;
        margin-top: 8px;

        padding: 14px;

        border: none;
        border-radius: 10px;

        background: linear-gradient(135deg, #5b6cff 0%, #8b5cf6 100%);

        color: #ffffff;

        font-size: 15px;
        font-weight: 700;

        cursor: pointer;

        box-shadow: 0 8px 20px rgba(91, 108, 255, 0.25);

        transition: all 0.2s ease;
    }

    .register-btn:hover {
        transform: translateY(-1px);

        box-shadow:
            0 10px 25px rgba(91, 108, 255, 0.35);
    }

    .register-btn:active {
        transform: translateY(0);
    }

    .view-link {
        display: block;

        margin-top: 20px;

        text-align: center;

        color: #5b5fe8;

        font-size: 14px;
        font-weight: 600;

        text-decoration: none;
    }

    .view-link:hover {
        text-decoration: underline;
    }

    .footer-text {
        text-align: center;

        margin-top: 18px;

        color: #9ca3af;

        font-size: 12px;
    }

    @media (max-width: 600px) {

        .card-header {
            padding: 30px 22px 20px;
        }

        .form-container {
            padding: 10px 22px 30px;
        }

        .form-row {
            grid-template-columns: 1fr;
            gap: 0;
        }

        .card-header h1 {
            font-size: 22px;
        }
    }
</style>
```

</head>

<body>

```
<div class="page-wrap">

    <div class="card">

        <div class="card-header">

            <div class="icon">
                +
            </div>

            <h1>Register Student</h1>

            <p>
                Enter the student's details to register them in the system
            </p>

        </div>

        <div class="form-container">

            <!--
                IMPORTANT:
                These field names must remain exactly as they are.
                RegistrationController expects:
                fullname, address, age, qual, percent, yop
            -->

            <form action="registrationController" method="post">

                <div class="form-group">
                    <label for="fullname">
                        Full Name
                    </label>

                    <input
                        type="text"
                        id="fullname"
                        name="fullname"
                        placeholder="Enter full name"
                        required>
                </div>


                <div class="form-group">
                    <label for="address">
                        Address
                    </label>

                    <input
                        type="text"
                        id="address"
                        name="address"
                        placeholder="Enter address"
                        required>
                </div>


                <div class="form-row">

                    <div class="form-group">
                        <label for="age">
                            Age
                        </label>

                        <input
                            type="number"
                            id="age"
                            name="age"
                            placeholder="Enter age"
                            min="1"
                            max="100"
                            required>
                    </div>


                    <div class="form-group">
                        <label for="qual">
                            Qualification
                        </label>

                        <input
                            type="text"
                            id="qual"
                            name="qual"
                            placeholder="e.g. BCS"
                            required>
                    </div>

                </div>


                <div class="form-row">

                    <div class="form-group">
                        <label for="percent">
                            Percentage
                        </label>

                        <input
                            type="number"
                            id="percent"
                            name="percent"
                            placeholder="e.g. 70"
                            min="0"
                            max="100"
                            step="0.01"
                            required>
                    </div>


                    <div class="form-group">
                        <label for="yop">
                            Year of Passout
                        </label>

                        <input
                            type="number"
                            id="yop"
                            name="yop"
                            placeholder="e.g. 2026"
                            min="1900"
                            max="2100"
                            required>
                    </div>

                </div>


                <button
                    type="submit"
                    class="register-btn">

                    Register Student

                </button>

            </form>


            <a
                href="viewStudents"
                class="view-link">

                View All Registered Students

            </a>


            <div class="footer-text">
                Student Management System
            </div>

        </div>

    </div>

</div>
```

</body>
</html>

