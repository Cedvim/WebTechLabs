import React, { Component } from 'react';
import Choice from './Choice';
import PropTypes from 'prop-types';

//Composant Choix (multiples)
class Choices extends Component {

    //Fonction d'affichage général => on affiche un seul composant, donc pas de besoin d'une fonction "displayChoices"
    render() {
      return (
        this.props.choices.map(
          t =>  <Choice
            key={t.id}
            {...t}
            updateMethod={this.props.updateMethod}
          />
        ) 
      )
    }
  }
  
  export default Choices;