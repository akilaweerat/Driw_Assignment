import './Sidebar.css';
import React from "react";

function Sidebar(props) {
    return (
        <div className="side-bar" style={{ width: props.width, minHeight: props.height }}>
            <React.Fragment>{props.children}</React.Fragment>
       </div>
    );
}

export default Sidebar;