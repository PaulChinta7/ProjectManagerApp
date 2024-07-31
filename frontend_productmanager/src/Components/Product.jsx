const Product = (props) => {
    const data=props.product;
    return ( 
        <div className="ProductContainer">
            <span className="f8 flex" >{data.product_id}</span>
            <div className="flex">
            <span className="f16 bold500">{data.product_name}</span>
            <span className="f12 p5 bold500">${data.product_price}</span>
            </div>
           
        </div>
     );
}
 
export default Product;