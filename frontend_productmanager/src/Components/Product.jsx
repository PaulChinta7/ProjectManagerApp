import { useState } from "react";

const Product = (props) => {
    const data=props.product;
    // const regex="/^[0-9]*\.?[0-9]+$/";
    const [typeError,setTypeError]=useState(false);
    const [updatedprice,setUpdatedPrice]=useState('');
    const HandleChange_updatePrice=(e)=>{ setUpdatedPrice( e.target.value); }
    const Handledelete = async()=>{
        try {
            const response = await fetch(`http://localhost:9000/products/delete?product_id=${data.product_id}`, {
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
        const Handleupdate= async()=>{
          if(/^[0-9]*\.?[0-9]+$/.test(updatedprice)){
            setTypeError(false);
            const updateEvent={"id":data.product_id,"price":parseFloat(updatedprice),"msg":"Updated the price of "+data.product_id+" to "+updatedprice};
            try {
              const response = await fetch('http://localhost:9000/products/update', {
                method: 'POST',
                headers: {
                  'Content-Type': 'application/json',
                },
                body: JSON.stringify(updateEvent),
              });
              setUpdatedPrice('');
  
        
              if (!response.ok) {
                throw new Error('Network response was not ok');
              }
          }
          catch(error){
            console.error('Error:', error);
          }
          }
          else{
            setTypeError(alert("Only Number/Float values are accepted"));
          }
         
      }
    return ( 
      
        <div className="ProductContainer">
          {typeError && <div style={{ marginTop: '5px', padding: '5px', backgroundColor:'#FF0000', color: 'white' }}>
          {typeError}
          </div>}
            <span className="f8 flex" >{data.product_id}</span>
            <div className="flex">
            <span className="f12 bold500 " >{data.product_name}</span>
            <div>
            <span className="f10  bold500 p10y">${parseFloat(data.product_price).toFixed(2)}</span>
            <span><button className="deletebutton" onClick={Handledelete}>Delete</button></span>
            <span className="p10y"><input className="textinput2 f10  bold500" type="text" onChange={HandleChange_updatePrice} value={updatedprice}/></span>
            <span><button className="deletebutton" onClick={Handleupdate}>Update</button></span>
            </div>
            </div>
           
        </div>
     );
}
 
export default Product;