<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Registration Successful</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap"
          rel="stylesheet">

    <style>

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Inter', 'Segoe UI', Arial, sans-serif;
        }

        body {
            min-height: 100vh;

            background: linear-gradient(
                135deg,
                #667eea 0%,
                #764ba2 100%
            );

            display: flex;
            align-items: center;
            justify-content: center;

            padding: 30px 16px;
        }

        .container {
            width: 100%;
            max-width: 700px;
        }

        .card {
            background: #ffffff;

            border-radius: 22px;

            overflow: hidden;

            box-shadow:
                0 12px 30px rgba(0, 0, 0, 0.10),
                0 30px 70px rgba(30, 20, 80, 0.22);
        }

        .success-section {
            text-align: center;

            padding: 42px 35px 28px;
        }

        .success-icon {
            width: 70px;
            height: 70px;

            margin: 0 auto 18px;

            border-radius: 50%;

            display: flex;
            align-items: center;
            justify-content: center;

            background: linear-gradient(
                135deg,
                #5b6cff,
                #8b5cf6
            );

            color: white;

            font-size: 32px;
            font-weight: 800;

            box-shadow:
                0 10px 25px rgba(91, 108, 255, 0.30);
        }

        .success-section h1 {
            color: #111827;

            font-size: 27px;
            font-weight: 800;

            margin-bottom: 8px;
        }

        .success-section p {
            color: #6b7280;

            font-size: 14px;

            line-height: 1.6;
        }

        .details {
            margin: 5px 35px 30px;

            border: 1px solid #e5e7eb;

            border-radius: 14px;

            overflow: hidden;
        }

        .detail-row {
            display: flex;

            justify-content: space-between;
            align-items: center;

            padding: 15px 18px;

            border-bottom: 1px solid #eeeeee;

            gap: 20px;
        }

        .detail-row:last-child {
            border-bottom: none;
        }

        .label {
            color: #6b7280;

            font-size: 13px;
            font-weight: 600;
        }

        .value {
            color: #111827;

            font-size: 14px;
            font-weight: 700;

            text-align: right;
            word-break: break-word;
        }

        .actions {
            display: grid;

            grid-template-columns: 1fr 1fr;

            gap: 12px;

            padding: 0 35px 35px;
        }

        .btn {
            display: flex;

            align-items: center;
            justify-content: center;

            padding: 13px 16px;

            border-radius: 10px;

            text-decoration: none;

            font-size: 14px;
            font-weight: 700;

            transition: all 0.2s ease;
        }

        .primary-btn {
            background: linear-gradient(
                135deg,
                #5b6cff,
                #8b5cf6
            );

            color: white;

            box-shadow:
                0 7px 18px rgba(91, 108, 255, 0.22);
        }

        .primary-btn:hover {
            transform: translateY(-1px);

            box-shadow:
                0 10px 24px rgba(91, 108, 255, 0.32);
        }

        .secondary-btn {
            background: #f3f4f6;

            color: #374151;
        }

        .secondary-btn:hover {
            background: #e5e7eb;
        }

        .footer {
            text-align: center;

            padding: 0 20px 25px;

            color: #9ca3af;

            font-size: 12px;
        }

        @media (max-width: 600px) {

            .success-section {
                padding: 32px 22px 24px;
            }

            .success-section h1 {
                font-size: 23px;
            }

            .details {
                margin-left: 22px;
                margin-right: 22px;
            }

            .actions {
                grid-template-columns: 1fr;

                padding-left: 22px;
                padding-right: 22px;
                padding-bottom: 28px;
            }

            .detail-row {
                align-items: flex-start;

                flex-direction: column;

                gap: 5px;
            }

            .value {
                text-align: left;
            }
        }

    </style>

</head>

<body>

<%
    String name = request.getParameter("fullname");
    String addr = request.getParameter("address");
    String age = request.getParameter("age");
    String qual = request.getParameter("qual");
    String percent = request.getParameter("percent");
    String year = request.getParameter("yop");

    if (name == null) name = "";
    if (addr == null) addr = "";
    if (age == null) age = "";
    if (qual == null) qual = "";
    if (percent == null) percent = "";
    if (year == null) year = "";
%>

<div class="container">

    <div class="card">

        <div class="success-section">

            <div class="success-icon">
                ✓
            </div>

            <h1>
                Registration Successful
            </h1>

            <p>
                The student has been successfully registered
                in the Student Management System.
            </p>

        </div>


        <div class="details">

            <div class="detail-row">
                <span class="label">Full Name</span>
                <span class="value"><%= name %></span>
            </div>

            <div class="detail-row">
                <span class="label">Address</span>
                <span class="value"><%= addr %></span>
            </div>

            <div class="detail-row">
                <span class="label">Age</span>
                <span class="value"><%= age %></span>
            </div>

            <div class="detail-row">
                <span class="label">Qualification</span>
                <span class="value"><%= qual %></span>
            </div>

            <div class="detail-row">
                <span class="label">Percentage</span>
                <span class="value"><%= percent %>%</span>
            </div>

            <div class="detail-row">
                <span class="label">Year of Passout</span>
                <span class="value"><%= year %></span>
            </div>

        </div>


        <div class="actions">

            <a href="index.jsp"
               class="btn secondary-btn">
                Register Another Student
            </a>

            <a href="viewStudents"
               class="btn primary-btn">
                View All Students
            </a>

        </div>


        <div class="footer">
            Student Management System
        </div>

    </div>

</div>

</body>
</html>
