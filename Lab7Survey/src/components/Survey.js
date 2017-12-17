import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Choices from './Choices';
import Percentages from './Percentages';
import AddChoice from './AddChoice';
import {choiceHelper} from '../ChoiceHelper'


const defaultChoices = [
  {id: 1,
    content: "Game of thrones",
    votes: 0,
    percentage: 0},
  {id: 2,
    content: "The Walking Dead",
    votes: 0,
    percentage: 0},
    {id: 3,
      content: "Je n'en regarde pas",
      votes: 0,
      percentage: 0}
];



class Survey extends Component {


    constructor(){
      super();
      this.state = {
        choices: defaultChoices
      }
    }

    render() {
      return (
        <div className ="survey">
          <h1>Quel est votre série préférée ?</h1>
          <br/>
          <Percentages choices={this.state.choices}/>
          <Choices choices={this.state.choices} updateMethod={this.changePercentages}/>
          <AddChoice addChoice={this.addChoicesToState}/>
        </div>
      );
    }

    //Change les pourcentages en changeant l'état
    changePercentages = (e) => {
      var id = e.target.id;
      var vote = e.target.value;
      if(vote!="" && vote>=0){
        this.updateState(id,vote);
      }
    }

    updateState = (id, newVote) => {
      var newState = choiceHelper.modifyChoicesList(this.state.choices,id,newVote);
      this.setState({choices: newState});

    };

    addChoicesToState = (name) => {
      // this.state.choices.push({
      //   id: Math.floor((Math.random()*1000)+1),
      //   content: name,
      //   percentage: 0
      // })
      
      // this.setState(this.state);
      //let updateState = UpdateState(this.state);

      var newState = choiceHelper.addChoiceToList(this.state.choices, name);
      this.setState({choices: newState});

    };


  }

  export default Survey;
  