import React from "react";
import AddressCard from "../AddressCard";
import "./style.scss";
import CartHistory from "../CartHistory";

export default function OrderSummary() {
  return (
    <>
      <div className="ordersummary">
        <AddressCard />
      </div>
      <CartHistory />
    </>
  );
}
