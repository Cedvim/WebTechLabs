import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import PropTypes from 'prop-types';

const Votes = (props) => (
    <div className="votesNumber"> 
         
          <input id={props.id} min="0" name={props.name} defaultValue="0" type="number" className="inputs" onChange={props.updateMethod}/>

        </div>
);

Votes.propTypes = {
  id: PropTypes.number.isRequired,
  name: PropTypes.string.isRequired
}

  
  export default Votes;

// class Votes extends Component {


//     changePercentages = (e) => {
//       var id = e.target.id;
//       var vote = e.target.value;
//       this.props.updateMethod(id,vote)
//     }


//     render() {
//       return (
//         <div className="votesNumber"> 
         
//           <input id={this.props.id} name={this.props.name} defaultValue="0" type="number" className="inputs" onChange={this.changePercentages}/>

//         </div>
//       );
//     }
//   }
  
//   export default Votes;