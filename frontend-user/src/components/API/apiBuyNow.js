// Trong apiBuyNow.js
import axiosClient from "./axiosClient";

const apiBuyNow = {
  postBuyNow(orderInfo) {
    const url = `/payment/submitOrder`;
    return axiosClient.post(url, null, { params: orderInfo });
  },
};

export default apiBuyNow;
