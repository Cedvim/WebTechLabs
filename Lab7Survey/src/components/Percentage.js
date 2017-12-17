import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import PropTypes from 'prop-types';

//var idName = "percent" + props.id;
const Percentage = (props) => (
        <div id={"percent" + props.id} className="percentages">
          {props.content} :  {props.percentage}%
        </div>
);
export default Percentage;

Percentage.propTypes = {
  id: PropTypes.number.isRequired,
  content: PropTypes.string.isRequired,
  percentage: PropTypes.number.isRequired
}

// class Percentages extends Component {


//     render() {
    
//       var idName = "percent" + this.props.id;
//       console.log(this.props.percentage)
//       return (
//         <div id={idName} className="percentages">
//           {this.props.content} :  {this.props.percentage}%
//         </div>
//       );
//     }
//   }
  //console.log(choicesList);
  