import React, {useEffect, useState} from 'react';
import axios from "axios"; 
import './Form.css';

function Form (props) {

    const [product, setProduct] = useState("");
    const [quantity, setQuantity] = useState(0);
    const [total, setTotal] = useState(0.0);
    const [products, setProducts] = useState([]);
    // this.state = {
    //     quantity: 0,
    //     total: 0.0,
    //     products: []
    // };

    // this.handleInputChange = this.handleInputChange.bind(this);

    const populateDropdown = async() => {
        try {
            const resp = await axios.get("http://localhost:8080/products");
            setProducts(resp.data);
            if (resp.data.length > 0) {
                setProduct(resp.data[0].name);
            }            
        } catch(err){
            console.error(err);
        }
    };

    useEffect(() => {
            populateDropdown();
    }, []);

    function isNormalInteger(str) {
        return /^\+?(0|[1-9]\d*)$/.test(str);
    }

    function handleSubmit(event){
        event.preventDefault();
        if(!isNormalInteger(quantity)){
            alert("Invalid Quantity");
            return;
        }
        axios.get(`http://localhost:8080/calculate?productName=${product}&quantity=${quantity}`)
          .then(res=>{
            setTotal(res.data);
          })
      }

    function handleInputChange(event){
        const target = event.target;
        const value = target.value;
        const name = target.name;

        if ( name === 'product') {
            setProduct(value);
            setQuantity(0);
            setTotal(0.0);
        } else if (name === 'quantity') {
            setQuantity(value);
        };
    }

    return (
        <div className="CalculateForm col-md-3 col-md-offset-4">
            <form onSubmit={handleSubmit}>
                <div className="col-md-12">
                    <label>
                        Select product:
                    </label>
                </div>
                <div className="col-md-12">
                    <select name="product" value={product} onChange={handleInputChange}>
                        {products.map(p=><option key = {p.id} value={p.name}>{p.name}</option>)}
                    </select>
                </div>
                <br />
                <div className="col-md-12">
                    <label>
                        Quantity:
                </label>
                </div>
                <div className="col-md-12">
                    <input
                        name="quantity"
                        type="text"
                        value={quantity}
                        onChange={handleInputChange} />
                </div>
                <br />
                <div className="col-md-12">
                    <button type="submit" className="btn btn-primary" name="btn-submit"> Calculate </button>
                </div>
            </form>
            <br />
            <div className="col-md-12">
                <label>
                    Total Price is (Rs):
                </label>
                <br/>
                <input
                    className="InputTotal"
                    name="totalPrice"
                    type="text"
                    value={total} 
                    readOnly/>
            </div>
        </div>
    );
}

export default Form;