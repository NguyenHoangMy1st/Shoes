import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import ForgetPassPage from "./pages/ForgerPassPage";
import HomePage from "./pages/HomePage";
import ProductPage from "./pages/ProductPage";
import AboutPage from "./pages/AboutPage";
import WarehousePage from "./pages/WarehousePage";
import CartPage from "./pages/CartPage";
import ServicePage from "./pages/ServicePage";
import PayPage from "./pages/PayPage";
import AddProductPage from "./pages/AddProductPage";
import ProfilePage from "./pages/ProfilePage";
import HotTrendPage from "./pages/HotTrendPage";

import "react-toastify/dist/ReactToastify.css";
import { CartProvider } from "./contexts/CartContext";

function App() {
  return (
    <BrowserRouter>
      <CartProvider>
        <Routes>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/forgetpassword" element={<ForgetPassPage />} />
          <Route path="/" element={<HomePage />} />
          <Route path="/product" element={<ProductPage />} />
          <Route path="/product/:id" element={<AboutPage />} />
          <Route path="/hot" element={<HotTrendPage />} />
          <Route path="/cart" element={<CartPage />} />
          <Route path="/service" element={<ServicePage />} />
          <Route path="/warehouse" element={<WarehousePage />} />
          <Route path="/pay" element={<PayPage />} />
          <Route path="/addproduct" element={<AddProductPage />} />
          <Route path="/profile" element={<ProfilePage />} />
        </Routes>
      </CartProvider>
    </BrowserRouter>
  );
}

export default App;
