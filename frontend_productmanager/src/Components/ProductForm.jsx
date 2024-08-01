import { useEffect, useState } from "react";

const ProductFrom = () => {
    const [productName,setproductName]=useState("");
    const [productPrice,setproductPrice]=useState("");
    const [alert,setAlert]=useState(null);
    const [BgColor,setBgColor]=useState(null);
    const HandleSubmit= async (e)=>{
        e.preventDefault();
         const product={"product_name":productName,"product_price":parseFloat(productPrice)};
         
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
        setAlert(`Product ${productName} added to the DB`)
        setBgColor("#4caf50");
        console.log('Success:', result);
      } catch (error) {
        console.error('Error:', error);
        setBgColor("#FF0000");
        setAlert(`Failed to add Product ${productName} to the DB`)
      }
    }
    useEffect(() => {
      if (alert) {
        const timer = setTimeout(() => {
          setAlert(null);
        }, 5000); 
        setproductName("");
        setproductPrice("");
  
        return () => clearTimeout(timer); 
      }
    }, [alert]);
    return ( 
    <div className="content">

    <div className="productFormContainer">

        <p className="flex p10y">Product Form</p>
        <div className="textbox">
        <span className="f10 flex bold500">Product Name</span>
        <input  onChange={(e)=>{setproductName(e.target.value)}} className="textinput" type="text" value={productName}/>
        </div>

        <div className="textbox">
        <span className="f10 flex bold500">Product Price</span>
        <input  onChange={(e)=>{setproductPrice(e.target.value)}} className="textinput" type="text" value={productPrice}/>
        </div>
        <span className=" p10y"><button className="addbutton" onClick={HandleSubmit}>Add</button></span>
        {alert && (
        <div style={{ marginTop: '10px', padding: '10px', backgroundColor:BgColor, color: 'white' }}>
          {alert}
        </div>
      )}
        
    </div> 
    </div>
    );
}
 
export default ProductFrom;