import React from 'react';
import './Card.css';
import { Link } from 'react-router-dom';

function MainCard(props) {
	return (
		<div className="Card">
			<img src={props.image}></img>
			<Link to={props.to}>
				<button> {props.buttonText} </button>
			</Link>
		</div>
	);
}

export default MainCard;
