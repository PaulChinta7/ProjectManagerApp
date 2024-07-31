import { useEffect, useState } from "react";

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
            <p>Products</p>
            {data.map((item) => (<p>{item}</p>) )}


        </div>
     );
}
 
export default Products;