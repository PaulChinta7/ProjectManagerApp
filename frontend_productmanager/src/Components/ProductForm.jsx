const ProductFrom = () => {
    return ( <div className="productFormContainer">
        <p className="flex p10y">Product Form</p>
        <div className="textbox">
        <span className="f10 flex bold500">Product Name</span>
        <input  className="textinput" type="text" />
        </div>

        <div className="textbox">
        <span className="f10 flex bold500">Product Price</span>
        <input  className="textinput" type="text" />
        </div>
        <span className=" p10y"><button className="addbutton">Add</button></span>
        
    </div> );
}
 
export default ProductFrom;