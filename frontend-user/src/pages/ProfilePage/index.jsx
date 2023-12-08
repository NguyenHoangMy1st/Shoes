import React from "react";
import { ToastContainer } from "react-toastify";
import Header from "../../components/Layout/Header";
import ProfileCard from "../../components/ProfileCard";
import { useCart } from "../../contexts/CartContext";

export default function ProfilePage() {
  const { cartItems } = useCart();
  return (
    <>
      <Header cartItems={cartItems} />
      <ProfileCard />
      <ToastContainer />
    </>
  );
}
