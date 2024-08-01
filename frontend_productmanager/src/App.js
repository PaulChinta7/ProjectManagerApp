
import './App.css';
import Products from './Components/Products';
import ProductForm from './Components/ProductForm';
import NavBar from './Components/NavBar';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
    <Router>
        <NavBar />
        <Routes>
          <Route path="/" element={<h1>Welcome to the Home Page</h1>} />
          <Route path="/products" element={<Products />} />
          <Route path="/product-form" element={<ProductForm />} />
        </Routes>
    </Router>
        </div>
  );
}

export default App;
