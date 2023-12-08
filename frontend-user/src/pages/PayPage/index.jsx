import React from "react";
import Header from "../../components/Layout/Header";
import PayCard from "../../components/PayCard";
import { useCart } from "../../contexts/CartContext";

export default function PayPage() {
  const { cartItems } = useCart();
  return (
    <>
      <Header cartItems={cartItems} />
      <PayCard />
    </>
  );
}
