import { useEffect, useState } from "react";
import Product from "./Product";

const Products = () => {
    const [data,setdata]=useState([]);
   
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
                console.error("Error fetching data:", error);
            }
        };

        fetchData();
            },[]);
    return ( 
        
        <div className="productsContainer">
            <p className="flex p10y">Products</p>
            {data.map((item,index) => (<Product key={item.product_id} product={item}/>) )}


        </div>
     );
}
 
export default Products;