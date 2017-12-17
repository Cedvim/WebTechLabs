import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Choice from './Choice';
import PropTypes from 'prop-types';

class AddChoice extends Component {

    constructor(){
      super();
      this.state = {
        newChoice: ''
      }
    }

    render() {
      return (
        <div>
            <input onKeyDown={this.testEnter} className="addChoice" type="text" value={this.state.newChoice} onChange={this.changeName}/>
            <button onClick={this.addChoice}>+</button>
        </div>
      );
    }

    changeName = (e) => (
        this.setState({newChoice: e.target.value})
    )

    testEnter = (e) => {;
      if(e.keyCode ==13) this.addChoice();
    };

    addChoice = () => {
        if(this.state.newChoice !=''){
          this.props.addChoice(this.state.newChoice);
        }
        this.setState({newChoice: ''});
    }

  }
  AddChoice.propTypes = {
    newChoice : PropTypes.string
  }
  
  export default AddChoice;