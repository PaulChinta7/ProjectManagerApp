const Product = (props) => {
    const data=props.product;

    const Handledelete = async()=>{
        try {
            const response = await fetch(`http://localhost:8080/products/delete?product_id=${data.product_id}`, {
              method: 'DELETE',
              headers: {
                'Content-Type': 'application/json',
              },
              
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
    return ( 
        <div className="ProductContainer">
            <span className="f8 flex" >{data.product_id}</span>
            <div className="flex">
            <span className="f12 bold500 " >{data.product_name}</span>
            <div >

            <span className="f10  bold500 p10y">${data.product_price}</span>
            <span><button className="deletebutton" onClick={Handledelete}>Delete</button></span>
            </div>
            </div>
           
        </div>
     );
}
 
export default Product;