import { useEffect, useState } from "react";
import Product from "./Product";

const Products = () => {
    const [data,setdata]=useState([]);
    const [error,setError]=useState(null);
   
    useEffect(() =>{
        const fetchData = async () => {
            try {
                const response = await fetch("http://localhost:8080/products/getProducts");
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                const json_data = await response.json();
                
                setdata(json_data);
            } catch (error) {
            
                setError("API might be down, Failed to fetch the data")
            }
        };

        fetchData();
            },[]);
    return ( 
        <div className="content">
        <div className="productsContainer">
            <p className="flex p10y">Products</p>
            {error && <div style={{ marginTop: '10px', padding: '10px', backgroundColor:'#FF0000', color: 'white' }}>
          {error}
        </div>}
        {/* add loader */}
            {data.map((item) => (<Product key={item.product_id} product={item}/>) )}


        </div>
        </div>
     );
}
 
export default Products;