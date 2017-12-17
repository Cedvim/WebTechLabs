import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Percentage from './Percentage';



class Percentages extends Component {
  
  displayPercentages(){
    return this.props.choices.map(
      
      t => 
      <Percentage
        key={t.id}
        {...t}
      />
    ); 
  }

    render() {
      return ( 
        <div id="percentageDiv">
          <h2>Percentages</h2>
          <br/>
          {this.displayPercentages()}
        </div>
      ); 
    }
  }
  //console.log(choicesList);
  export default Percentages;
  