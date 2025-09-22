package com.pieceofyou.user.service.constants;


public class Constants {
    public static final String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    public static final String verificationSeparator = "////";
    public static final String verificationEmailBody = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Email Verification</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f7fc;
                        color: #333;
                        margin: 0;
                        padding: 0;
                    }
                    .email-container {
                        max-width: 600px;
                        margin: 0 auto;
                        padding: 20px;
                        background-color: #fff;
                        border-radius: 8px;
                        box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
                    }
                    .header {
                        text-align: center;
                        margin-bottom: 30px;
                    }
                    .header h1 {
                        font-size: 32px;
                        color: #2C3E50;
                    }
                    .content {
                        font-size: 16px;
                        line-height: 1.5;
                        color: #555;
                    }
                    .content p {
                        margin: 10px 0;
                    }
                    .cta-button {
                        display: inline-block;
                        padding: 12px 25px;
                        background-color: #3498db;
                        color: #fff;
                        text-decoration: none;
                        border-radius: 30px;
                        font-weight: bold;
                        text-align: center;
                        margin: 20px 0;
                    }
                    .footer {
                        font-size: 14px;
                        text-align: center;
                        color: #999;
                        margin-top: 30px;
                    }
                    .footer a {
                        color: #3498db;
                        text-decoration: none;
                    }
                </style>
            </head>
            <body>
                <div class="email-container">
                    <div class="header">
                        <h1>Welcome to Our Platform!</h1>
                    </div>
                    <div class="content">
                        <p>Hello <strong>%s</strong>,</p>
                        <p>Thank you for signing up! To complete your registration, please click the button below to verify your email address:</p>
                        <p><a href="%s/auth/verify?id=%s&key=%s" class="cta-button">Verify Your Email</a></p>
                        <p>If you did not create an account with us, you can ignore this email.</p>
                        <p>Best regards,<br>Your VR ur Job Buddy Team</p>
                    </div>
                    <div class="footer">
                        <p>&copy; 2025 VR ur Job Buddy Team | <a href="http://yourcompany.com/privacy-policy">Privacy Policy</a></p>
                    </div>
                </div>
            </body>
            </html>
            """;
    public static final String verificationSuccessfulEmailBody = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Email Verification Success</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f7fc;
                        color: #333;
                        margin: 0;
                        padding: 0;
                    }
                    .email-container {
                        max-width: 600px;
                        margin: 0 auto;
                        padding: 20px;
                        background-color: #fff;
                        border-radius: 8px;
                        box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
                    }
                    .header {
                        text-align: center;
                        margin-bottom: 30px;
                    }
                    .header h1 {
                        font-size: 32px;
                        color: #2C3E50;
                    }
                    .content {
                        font-size: 16px;
                        line-height: 1.5;
                        color: #555;
                    }
                    .content p {
                        margin: 10px 0;
                    }
                    .cta-button {
                        display: inline-block;
                        padding: 12px 25px;
                        background-color: #2ecc71;
                        color: #fff;
                        text-decoration: none;
                        border-radius: 30px;
                        font-weight: bold;
                        text-align: center;
                        margin: 20px 0;
                    }
                    .footer {
                        font-size: 14px;
                        text-align: center;
                        color: #999;
                        margin-top: 30px;
                    }
                    .footer a {
                        color: #3498db;
                        text-decoration: none;
                    }
                </style>
            </head>
            <body>
                <div class="email-container">
                    <div class="header">
                        <h1>Verification Successful!</h1>
                    </div>
                    <div class="content">
                        <p>Hey <b>%s</b>!!!</p>
                        <p>Your email address has been successfully verified, and you're all set up on VR ur Job Buddy. Welcome aboard!</p>
                        <p>We are excited to have you with us. Now, you're ready to explore job opportunities and take the next step in your career.</p>
                        <p>If you have any questions or need assistance, feel free to contact us.</p>
                        <p>Best regards,<br>Your VR ur Job Buddy Team</p>
                    </div>
                    <div class="footer">
                        <p>&copy; 2025 VR ur Job Buddy | <a href="http://yourcompany.com/privacy-policy">Privacy Policy</a></p>
                    </div>
                </div>
            </body>
            </html>
            """;
    public static final String verificationSubject = "Welcome! Confirm Your Email for Full Access";
    public static final String verificationSuccessfulSubject = "Your Email is Verified! Welcome to VR ur Job Buddy";
    public static final String htmlContentType = "text/html";
}
