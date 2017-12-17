import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Choice from './Choice';
import PropTypes from 'prop-types';

// const Choices = (props) => props.choices.map(
        
//         t =>
//         <div className="choices">
//           <Choice
//                 key={t.id}
//                 {...t}
//                 updateMethod={props.updateMethod}
//               />
//         </div>
// );

// // Choices.propTypes = {
// //   id: PropTypes.number.isRequired
// // }

  
//   export default Choices;

class Choices extends Component {

    displayChoices(){
      return this.props.choices.map(
        
        t => 
        <Choice
          key={t.id}
          {...t}
          updateMethod={this.props.updateMethod}
        />
      ); 
    }

    render() {
      return (
        <div className="choices">
          {this.displayChoices()}
        </div>
      );
    }
  }
  
  export default Choices;