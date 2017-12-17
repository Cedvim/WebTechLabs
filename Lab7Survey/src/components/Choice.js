import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Votes from './Votes';
import PropTypes from 'prop-types';


const Choice = (props) => (
        <div className="choice"> {props.content}
          <Votes id={props.id} name={props.content} updateMethod={props.updateMethod}/>
        </div>
);

Choice.propTypes = {
  id: PropTypes.number.isRequired,
  content: PropTypes.string.isRequired,
  percentage: PropTypes.number.isRequired
}

  
  export default Choice;