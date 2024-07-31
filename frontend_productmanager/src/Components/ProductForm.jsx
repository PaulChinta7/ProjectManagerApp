import { useState } from "react";

const ProductFrom = () => {
    const [productName,setproductName]=useState("");
    const [productPrice,setproductPrice]=useState("");
    const HandleSubmit= async (e)=>{
        e.preventDefault();
         const product={"product_name":productName,"product_price":parseFloat(productPrice)};
         console.log(product);
    try {
        const response = await fetch('http://localhost:8080/products/addProduct', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(product),
        });
  
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
  
        const result = await response.json();
        console.log('Success:', result);
      } catch (error) {
        console.error('Error:', error);
      }
    }
    return ( <div className="productFormContainer">

        <p className="flex p10y">Product Form</p>
        <div className="textbox">
        <span className="f10 flex bold500">Product Name</span>
        <input  onChange={(e)=>{setproductName(e.target.value)}} className="textinput" type="text" />
        </div>

        <div className="textbox">
        <span className="f10 flex bold500">Product Price</span>
        <input  onChange={(e)=>{setproductPrice(e.target.value)}} className="textinput" type="text" />
        </div>
        <span className=" p10y"><button className="addbutton" onClick={HandleSubmit}>Add</button></span>
        
    </div> );
}
 
export default ProductFrom;