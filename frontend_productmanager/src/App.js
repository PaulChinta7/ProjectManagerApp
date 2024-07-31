import logo from './logo.svg';
import './App.css';
import Products from './Components/Products';
import ProductForm from './Components/ProductForm';
import NavBar from './Components/NavBar';

function App() {
  return (
    <div className="App">
      <NavBar/>
       <div className='content'>

      <Products/>
      <ProductForm/>
       </div>
    </div>
  );
}

export default App;
