import { Link } from "react-router-dom";

const NavBar = () => {
    return ( <div className="navbar">
       
        <ul>
            <li> <p className="f12 bold500 p10y">Product Manager</p></li>
            <li><Link to="/products">Products</Link></li>
            <li><Link to="/product-form">AddProduct</Link></li>
        </ul>
    </div> );
}
 
export default NavBar;