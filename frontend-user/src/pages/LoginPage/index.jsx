import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast, ToastContainer } from "react-toastify";
import "./style.scss";

export default function LoginPage() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [rememberMe, setRememberMe] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    console.log(rememberMe);
  }, [rememberMe]);
  const handleLogin = async () => {
    try {
      const formData = {
        email: username,
        password,
      };
      const response = await axios.post(
        "https://pbl6-shoes-shop-production-9e98.up.railway.app/auth/signin",
        formData
      );
      console.log(response);
      if (response) {
        toast.success("Đăng nhập thành công");
        console.log("response", response);
        localStorage.setItem("token", response?.data?.jwt);
        localStorage.setItem("user", JSON.stringify(formData));

        setTimeout(() => {
          navigate("/");
        }, 2000);
      }
    } catch (error) {
      toast.error(error?.message);
    }
  };

  return (
    <div className="login-control body-login">
      <ToastContainer />
      <div className="wrapper">
        <div className="form-box login">
          <h1>Welcome Back!</h1>
          <form id="login-form">
            <div className="input-box">
              <input
                type="text"
                id="username"
                name="username"
                value={username}
                onChange={(event) => setUsername(event.target.value)}
                required
              />
              <label>Username</label>
            </div>
            <div className="input-box">
              <input
                type="password"
                id="password"
                name="password"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
                required
              />
              <label>Password</label>
            </div>

            <div className="remember-forgot">
              <div>
                <input
                  type="checkbox"
                  checked={rememberMe}
                  onChange={() => setRememberMe(!rememberMe)}
                />
                <label>Remember me</label>
              </div>

              <Link to={"/forgetpassword"}>Forget Password</Link>
            </div>
            <button
              type="button"
              onClick={handleLogin}
              className="btn"
              id="btn-login"
            >
              LOGIN
            </button>
            <div className="login-register">
              <p>
                Don't have an account?
                <Link to={"/register"} className="register-link">
                  Register
                </Link>
              </p>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}
