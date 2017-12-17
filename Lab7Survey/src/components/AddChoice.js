import React, { Component } from 'react';
import PropTypes from 'prop-types';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

//Composant addChoice pour ajouter un choix
class AddChoice extends Component {

    //Constructeur
    constructor(){
      super();
      this.state = {
        newChoice: ''
      }
      //Choix vide au départ
    }

    //Fonction d'affichage général => un input text et un bouton d'ajout (TextField et RaisedButton en Material-UI)
    render() {
      return (
        <div>
          <TextField
            id = "inputAddChoice"
            onKeyDown={this.testEnter}
            onChange={this.changeName}
            value={this.state.newChoice} 
            hintText="Your choice"
            floatingLabelText="Enter a new choice"
          />

            <RaisedButton onClick={this.addChoice} label="Add" primary={(this.state.newChoice=="") ? false : true } />
        </div>
      );
    }

    //Fonction de changement de nom dans this.state.newChoices
    changeName = (e) => (
        this.setState({newChoice: e.target.value})
    )

    //Test de la touche entrée sur le clavier 
    testEnter = (e) => {
      if(e.keyCode ==13) this.addChoice(); //si la touche est "Enter" (keyCode), on ajoute le choix
    };

    //Fonction d'ajout du choix
    addChoice = () => {
        if(this.state.newChoice !=''){
          this.props.addChoice(this.state.newChoice);
        }
        this.setState({newChoice: ''});
    }
  }


//Proptypes
AddChoice.propTypes = {
  newChoice : PropTypes.string
}

export default AddChoice;