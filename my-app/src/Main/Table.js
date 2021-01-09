import React, { useEffect, useState } from 'react';
import axios from "axios";
import './Table.css';
import { Tab } from 'bootstrap';

function Table(props) {

    const [priceList, setPriceList] = useState([]);

    const getPriceList = async() => {
        try {
            const resp = await axios.get("http://localhost:8080/priceList?startQuantity=1&endQuantity=50");
            if (resp.status === 200) {
                setPriceList(resp.data);
            } 
        } catch(err){
            console.error(err);
        }
    };

    useEffect(() => {
        getPriceList();
    }, []);

    return (
        <div className="col-md-12">
            <br/>
            <h5> Price List</h5>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price (Penguin-ears)</th>
                        <th scope="col">Price (HorseShoe)</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        priceList.map( p =>
                        <tr key = {p.quantity} >
                            <th scope="row"> {p.quantity}</th>
                            <td>{p.productMap['Horseshoe']}</td>
                            <td>{p.productMap['Penguin-ears']}</td>
                        </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    );

}

export default Table;