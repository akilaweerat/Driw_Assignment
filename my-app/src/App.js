import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from './Navigation/Navbar.js';
import MainCard from './Main/Card.js';
import Form from './Main/Form.js';
import Table from './Main/Table.js';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Router>
      <Navbar />
      <Switch>
          <Route path="/calculate">
            <Form/>
          </Route>
          <Route path="/list">
            <Table/>
          </Route>
          <Route path="/">
            <MainCard image="images/calculate-price.png" buttonText="Calculate Price" to="/calculate"/>
            <MainCard image="images/price-list.jpg" buttonText="Price List" to="/list" />
          </Route>
      </Switch>
      </Router>
    </div>
  );
}


function About() {
  return <h2>About</h2>;
}

export default App;
