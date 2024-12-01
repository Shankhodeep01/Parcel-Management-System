document.addEventListener("DOMContentLoaded", function () {
    var form = document.getElementById("registrationForm");
    var modal = document.getElementById("modal");
    var modalMessage = document.getElementById("modalMessage");
    var closeBtn = document.querySelector(".close-btn");
    var loginButton = document.getElementById("loginButton");

    form.addEventListener("submit", function (e) {
        e.preventDefault(); // Prevent traditional form submission

        // Collect form data and convert to URL-encoded string
        var formData = new URLSearchParams(new FormData(form)).toString();

        // Send data to the backend using fetch
        fetch("register", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: formData,
        })
            .then(function (response) {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Network response was not ok.");
                }
            })
            .then(function (result) {
                if (result === "success") {
                    modalMessage.textContent = "Registration Successful!";
                    modalMessage.style.color = "green";
                    loginButton.style.display = "inline-block"; // Show Login button
                } else {
                    modalMessage.textContent = "Registration Failed!";
                    modalMessage.style.color = "red";
                    loginButton.style.display = "none"; // Hide Login button if failed
                }
            })
            .catch(function (error) {
                modalMessage.textContent = "An error occurred: " + error.message;
                modalMessage.style.color = "red";
                loginButton.style.display = "none"; // Hide Login button on error
            });

        // Show the modal
        modal.style.display = "block";
    });

    // Close modal when clicking the close button
    closeBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Close modal when clicking outside of the modal content
    window.addEventListener("click", function (e) {
        if (e.target === modal) {
            modal.style.display = "none";
        }
    });

    // Redirect to login page when clicking the Login button
    loginButton.addEventListener("click", function () {
        window.location.href = "login.html"; // Replace 'login.html' with your actual login page URL
    });
});
