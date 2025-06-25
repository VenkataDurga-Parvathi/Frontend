const validUsername = "student";
const validPassword = "admin123";

function login() {
  const user = document.getElementById("username").value;
  const pass = document.getElementById("password").value;
  const msg = document.getElementById("message");

  if (user === validUsername && pass === validPassword) {
    msg.style.color = "green";
    msg.innerText = "Login successful!";
  } else {
    msg.style.color = "red";
    msg.innerText = "Invalid credentials.";
  }
}

function toggleDarkMode() {
  document.body.classList.toggle("dark-mode");
}
