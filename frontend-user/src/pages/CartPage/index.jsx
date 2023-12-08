import Header from "../../components/Layout/Header";
import CartList from "../../components/CartList";
import { useCart } from "../../contexts/CartContext";
import React from "react";
export default function CartPage() {
  const { cartItems } = useCart();
  return (
    <>
      <Header cartItems={cartItems} />
      <CartList />
    </>
  );
}
